package com.folen.androidshowreel.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.folen.androidshowreel.R;
import com.folen.androidshowreel.base.BaseActivity;
import com.folen.androidshowreel.model.FeatureListItem;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;

import java.util.Arrays;

public class MainActivity extends BaseActivity {

    private static final int DEFAULT_ANIMATION_DURATION = 500;
    private RecyclerView recyclerView;
    private FastAdapter<FeatureListItem> fastAdapter;
    private ItemAdapter<FeatureListItem> itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindings();
        setupAdapter();
        setupRecyclerView();
        addItems();
    }

    public void bindings() {
        recyclerView = findViewById(R.id.recycler_view);

    }

    public void setupAdapter() {
        itemAdapter = new ItemAdapter<>();
        fastAdapter = FastAdapter.with(Arrays.asList(itemAdapter));
    }

    public void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.getItemAnimator().setAddDuration(DEFAULT_ANIMATION_DURATION);
        recyclerView.getItemAnimator().setRemoveDuration(DEFAULT_ANIMATION_DURATION);
        recyclerView.setAdapter(fastAdapter);
    }

    public void addItems() {
        itemAdapter.add(new FeatureListItem(getString(R.string.list_data_pass),getString(R.string.list_data_pass_description),R.mipmap.ic_launcher));
        itemAdapter.add(new FeatureListItem(getString(R.string.list_fragments),getString(R.string.list_fragments_description),R.mipmap.ic_launcher));
        itemAdapter.add(new FeatureListItem(getString(R.string.list_dialogs),getString(R.string.list_dialogs_description),R.mipmap.ic_launcher));
        itemAdapter.add(new FeatureListItem(getString(R.string.list_bottomnavigation),getString(R.string.list_bottomnavigation_description),R.mipmap.ic_launcher));
        itemAdapter.add(new FeatureListItem(getString(R.string.list_bottomsheetfragment),getString(R.string.list_bottomshettfragment_description),R.mipmap.ic_launcher));
        itemAdapter.add(new FeatureListItem(getString(R.string.list_googlemaps),getString(R.string.list_googlemaps_description),R.mipmap.ic_launcher));
        itemAdapter.add(new FeatureListItem(getString(R.string.list_taking_photos),getString(R.string.list_taking_photos_description),R.mipmap.ic_launcher));
        itemAdapter.add(new FeatureListItem(getString(R.string.list_qrcode_scanner),getString(R.string.list_qrcode_scanner_description),R.mipmap.ic_launcher));
    }
}
