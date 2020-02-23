package com.folen.androidshowreel.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;

import com.folen.androidshowreel.R;
import com.folen.androidshowreel.base.BaseActivity;
import com.folen.androidshowreel.model.Feature;
import com.folen.androidshowreel.util.FeatureRealization;
import com.folen.androidshowreel.util.listItems.FeatureListItem;
import com.folen.androidshowreel.util.manager.AssetManager;
import com.folen.androidshowreel.util.manager.IntentManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IItemAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.folen.androidshowreel.util.Const.DEFAULT_ANIMATION_DURATION;
import static com.folen.androidshowreel.util.Const.LIST_JSON_NAME;
import static com.folen.androidshowreel.util.Const.QR_SCANNER_ID;
import static com.folen.androidshowreel.util.Const.REQUEST_CODE_QR_SCANNER;

public class MainActivity extends BaseActivity {

    private RecyclerView recyclerView;

    private ItemAdapter<FeatureListItem> itemAdapter = new ItemAdapter<>();
    private FastAdapter<FeatureListItem> fastAdapter = FastAdapter.with(itemAdapter);
    private List<Feature> featureList = new ArrayList<>();

    private AppCompatCheckBox checkboxAll, checkboxDone, checkboxTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        setupViews();
        setupAdapter();
        setupRecyclerView();
        setupCheckboxes();
        if (loadListWithResult()) {
            addItems();
        }
    }

    private void setupViews() {
        checkboxAll = findViewById(R.id.checkbox_all);
        checkboxDone = findViewById(R.id.checkbox_done);
        checkboxTodo = findViewById(R.id.checkbox_todo);
        recyclerView = findViewById(R.id.recycler_view);
    }

    private void setupCheckboxes() {
        checkboxAll.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (checkboxTodo.isChecked() || checkboxDone.isChecked()) {
                if (isChecked) {
                    checkboxDone.setChecked(false);
                    checkboxTodo.setChecked(false);
                    checkboxAll.setChecked(true);
                    filterListBy(FeatureRealization.ALL.getType());
                }
            } else if (!checkboxTodo.isChecked() && !checkboxDone.isChecked()) {
                checkboxAll.setChecked(true);
            }
        });
        checkboxDone.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (checkboxTodo.isChecked() && isChecked) {
                checkboxDone.setChecked(false);
                checkboxTodo.setChecked(false);
                checkboxAll.setChecked(true);
                filterListBy(FeatureRealization.ALL.getType());
            } else if (!checkboxAll.isChecked() && !checkboxTodo.isChecked() && !isChecked) {
                checkboxAll.setChecked(true);
                filterListBy(FeatureRealization.ALL.getType());
            } else {
                checkboxAll.setChecked(false);
                filterListBy(FeatureRealization.DONE.getType());
            }
        });
        checkboxTodo.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (checkboxDone.isChecked() && isChecked) {
                checkboxDone.setChecked(false);
                checkboxTodo.setChecked(false);
                checkboxAll.setChecked(true);
                filterListBy(FeatureRealization.ALL.getType());
            } else if (!checkboxAll.isChecked() && !checkboxDone.isChecked() && !isChecked) {
                checkboxAll.setChecked(true);
                filterListBy(FeatureRealization.ALL.getType());
            } else {
                checkboxAll.setChecked(false);
                filterListBy(FeatureRealization.TODO.getType());
            }
        });

        checkboxAll.setChecked(true);
        checkboxDone.setChecked(false);
        checkboxTodo.setChecked(false);
    }

    private void filterListBy(String filterType) {
        itemAdapter.filter(filterType);
    }

    private void setupAdapter() {
        fastAdapter.withOnClickListener((v, adapter, item, position) -> {
            Intent intent = IntentManager.getIntentForFeature(this, item.getFeature());
            if (intent != null) {
                startActivity(intent);
                return true;
            }
            return false;
        });

        itemAdapter.getItemFilter().withFilterPredicate(new IItemAdapter.Predicate<FeatureListItem>() {
            @Override
            public boolean filter(FeatureListItem feature, CharSequence constraint) {
                if (constraint == FeatureRealization.DONE.getType()) {
                    return feature.getFeature().isDone();
                } else if (constraint == FeatureRealization.TODO.getType()) {
                    return !feature.getFeature().isDone();
                } else {
                    return true;
                }
            }
        });
    }

    private void setupRecyclerView() {

        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(fastAdapter);

        if (recyclerView.getItemAnimator() != null) {
            recyclerView.getItemAnimator().setAddDuration(DEFAULT_ANIMATION_DURATION);
            recyclerView.getItemAnimator().setRemoveDuration(DEFAULT_ANIMATION_DURATION);
        }
    }

    private Boolean loadListWithResult() {
        String featureListJson = AssetManager.loadJsonFromAssets(this, LIST_JSON_NAME);
        if (featureListJson != null) {
            try {
                featureList = new Gson().fromJson(featureListJson, new TypeToken<List<Feature>>() {
                }.getType());
            } catch (Exception e) {
                showLoadingError();
                return false;
            }
            return true;
        } else {
            showLoadingError();
            return false;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_QR_SCANNER && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Intent intent = IntentManager.getIntentForId(this, QR_SCANNER_ID);
            if (intent != null) {
                startActivity(intent);
            }
        }
    }

    private void showLoadingError() {
        Toast.makeText(this, getString(R.string.error_list_loading), Toast.LENGTH_SHORT).show();
    }

    private void addItems() {
        for (Feature feature : featureList) {
            itemAdapter.add(new FeatureListItem(feature));
        }
    }

}
