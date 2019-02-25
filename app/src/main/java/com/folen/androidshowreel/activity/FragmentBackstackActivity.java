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
import com.folen.androidshowreel.util.FirstFragment;
import com.folen.androidshowreel.util.SecondFragment;

public class FragmentBackstackActivity extends BaseActivity {

    private Toolbar mToolbar;
    private Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backstack_fragment);

        setupToolbar();
    }

    private void setupToolbar() {
        mToolbar = findViewById(R.id.fragment_toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("Fragments Backstack");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_backstack, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                fragment = new FirstFragment();
                addFragment(fragment);
                break;
            case R.id.action_replace:
                fragment = new SecondFragment();
                replaceFragment(fragment);
                break;
            case R.id.action_add_backstack:
                fragment = new FirstFragment();
                addFragmentWithBackStack(fragment);
                break;
            case R.id.action_replace_backstack:
                fragment = new SecondFragment();
                replaceFragmentWithBackStack(fragment);
                break;
            case R.id.action_remove:
                removeFragment(fragment);
                break;
            case android.R.id.home:
                removeFragment(fragment);
                break;
        }
        return true;
    }

    public void addFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_content, fragment);
        fragmentTransaction.commit();
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_content, fragment);
        fragmentTransaction.commit();
    }

    public void addFragmentWithBackStack(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void replaceFragmentWithBackStack(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void removeFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
    }

    public static Intent intent(Context context) {
        return new Intent(context, FragmentBackstackActivity.class);
    }

    @Override
    public void onBackPressed(){
        getSupportFragmentManager().popBackStack();
    }
}
