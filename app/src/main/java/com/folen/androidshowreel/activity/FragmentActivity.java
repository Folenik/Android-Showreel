package com.folen.androidshowreel.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.folen.androidshowreel.R;
import com.folen.androidshowreel.base.BaseActivity;
import com.folen.androidshowreel.base.BaseFragment;

import java.text.DateFormat;
import java.util.Date;

public class FragmentActivity extends BaseActivity {

    private Toolbar mToolbar;
    private Fragment fragment;
    private String time;
    private Bundle bundle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        setupToolbar();
    }

    private void setupToolbar() {
        mToolbar = findViewById(R.id.fragment_toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle(R.string.feature_fragment_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                fragment = new BaseFragment();
                addFragment(fragment);
                getTime();
                setFragmentText(getString(R.string.added_fragment));
                break;
            case R.id.action_replace:
                fragment = new BaseFragment();
                replaceFragment(fragment);
                getTime();
                setFragmentText(getString(R.string.replaced_fragment));
                break;
            case R.id.action_remove:
                removeFragment(fragment);
                break;
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }

    private void setFragmentText(String textToAdd) {
        if(bundle == null) {
            bundle = new Bundle();
        }

        bundle.putString("fragmentMessage", textToAdd + " " + time);
        fragment.setArguments(bundle);
    }

    private void getTime() {
        time = DateFormat.getTimeInstance(DateFormat.MEDIUM).format(new Date());
    }

    private void addFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_content, fragment);
        fragmentTransaction.commit();
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_content, fragment);
        fragmentTransaction.commit();
    }

    private void removeFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
    }

    public static Intent intent(Context context) {
        return new Intent(context, FragmentActivity.class);
    }
}
