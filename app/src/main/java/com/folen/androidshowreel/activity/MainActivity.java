package com.folen.androidshowreel.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.folen.androidshowreel.R;
import com.folen.androidshowreel.base.BaseActivity;
import com.folen.androidshowreel.model.Features;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;

import java.util.Arrays;

public class MainActivity extends BaseActivity {

    RecyclerView recyclerView;
    private FastAdapter<Features> fastAdapter;
    private ItemAdapter<Features> itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bindings();
        Setters();
        AddItems();
    }

    public void Bindings() {
        recyclerView = findViewById(R.id.recycler_view);
        itemAdapter = new ItemAdapter<>();
        fastAdapter = FastAdapter.with(Arrays.asList(itemAdapter));
    }

    public void Setters() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.getItemAnimator().setAddDuration(500);
        recyclerView.getItemAnimator().setRemoveDuration(500);
        recyclerView.setAdapter(fastAdapter);
    }

    public void AddItems() {
        itemAdapter.add(new Features(getString(R.string.list_data_pass),getString(R.string.list_data_pass_description),R.mipmap.ic_launcher));
        itemAdapter.add(new Features(getString(R.string.list_fragments),getString(R.string.list_fragments_description),R.mipmap.ic_launcher));
        itemAdapter.add(new Features(getString(R.string.list_dialogs),getString(R.string.list_dialogs_description),R.mipmap.ic_launcher));
        itemAdapter.add(new Features(getString(R.string.list_bottomnavigation),getString(R.string.list_bottomnavigation_description),R.mipmap.ic_launcher));
        itemAdapter.add(new Features(getString(R.string.list_bottomsheetfragment),getString(R.string.list_bottomshettfragment_description),R.mipmap.ic_launcher));
        itemAdapter.add(new Features(getString(R.string.list_googlemaps),getString(R.string.list_googlemaps_description),R.mipmap.ic_launcher));
        itemAdapter.add(new Features(getString(R.string.list_taking_photos),getString(R.string.list_taking_photos_description),R.mipmap.ic_launcher));
        itemAdapter.add(new Features(getString(R.string.list_qrcode_scanner),getString(R.string.list_qrcode_scanner_description),R.mipmap.ic_launcher));
    }
}
