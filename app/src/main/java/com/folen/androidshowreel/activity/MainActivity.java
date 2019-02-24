package com.folen.androidshowreel.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.folen.androidshowreel.R;
import com.folen.androidshowreel.base.BaseActivity;
import com.folen.androidshowreel.model.Feature;
import com.folen.androidshowreel.util.listItems.FeatureListItem;
import com.folen.androidshowreel.util.manager.AssetManager;
import com.folen.androidshowreel.util.manager.IntentManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.folen.androidshowreel.util.Const.DEFAULT_ANIMATION_DURATION;
import static com.folen.androidshowreel.util.Const.LIST_JSON_NAME;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView recyclerView;

    private ItemAdapter<FeatureListItem> itemAdapter = new ItemAdapter<>();
    private FastAdapter<FeatureListItem> fastAdapter = FastAdapter.with(itemAdapter);
    private List<Feature> featureList = new ArrayList<>();

    private AppCompatCheckBox checkboxAll, checkboxDone, checkboxTODO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        setupAdapter();
        setupRecyclerView();
        setupCheckboxes();
        if (loadListWithResult()) {
            addItems();
        }
    }

    private void setupCheckboxes() {
        checkboxAll = findViewById(R.id.checkbox_all);
        checkboxDone = findViewById(R.id.checkbox_done);
        checkboxTODO = findViewById(R.id.checkbox_todo);

        checkboxAll.setOnClickListener(this);
        checkboxDone.setOnClickListener(this);
        checkboxTODO.setOnClickListener(this);

        checkboxAll.setChecked(true);
        checkboxDone.setChecked(false);
        checkboxTODO.setChecked(false);
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

    private void showLoadingError() {
        Toast.makeText(this, getString(R.string.error_list_loading), Toast.LENGTH_SHORT).show();
    }

    private void addItems() {
        for (Feature feature : featureList) {
            itemAdapter.add(new FeatureListItem(feature));
        }
    }

    private void setOnCheckedChanges() {
        itemAdapter.clear();

        if (checkboxAll.isChecked()) {
            for (Feature feature : featureList) {
                itemAdapter.add(new FeatureListItem(feature));
            }
        } else if (checkboxDone.isChecked()) {
            for (Feature feature : featureList) {
                if (feature.isDone() == true) {
                    itemAdapter.add(new FeatureListItem(feature));
                }
            }

        } else if (checkboxTODO.isChecked()) {
            for (Feature feature : featureList) {
                if (feature.isDone() == false) {
                    itemAdapter.add(new FeatureListItem(feature));
                }
            }
        }
    }

    @Override
    public void onClick(View view) {
        if (view == checkboxAll) {
            checkboxDone.setChecked(false);
            checkboxTODO.setChecked(false);
        }
        if (view == checkboxDone) {
            checkboxAll.setChecked(false);
            checkboxTODO.setChecked(false);
        }
        if (view == checkboxTODO) {
            checkboxAll.setChecked(false);
            checkboxDone.setChecked(false);
        }

        setOnCheckedChanges();
    }
}
