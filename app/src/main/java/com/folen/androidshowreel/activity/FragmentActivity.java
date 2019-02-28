package com.folen.androidshowreel.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
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
import java.util.Calendar;
import java.util.Date;

public class FragmentActivity extends BaseActivity {

    private Toolbar mToolbar;
    private Fragment fragment;
    private String time;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        setupToolbar();
        setupTime();
    }

    private void setupToolbar() {
        mToolbar = findViewById(R.id.fragment_toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle(R.string.feature_fragment_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupTime() {
        time = DateFormat.getTimeInstance(DateFormat.MEDIUM).format(new Date());
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
                //czy to ma sens w ogóle używać tylko 1 fragmentu?
                //chciałbym właśnie w taki sposób rozróżniać akcję added od replace
                //ale tak jak gadaliśmy, ten textview nie istnieje
                //próbowałem robić wg. tego co mówiłeś mi przez tel, ale
                //nie potrafię do tego dojść, możesz mi zostawić jakieś wskazówki?
                //teraz wywala NPE tak jak gadaliśmy
                ((BaseFragment) fragment).setTextViewText(getString(R.string.added_fragment) + time);
                addFragment(fragment);
                break;
            case R.id.action_replace:
                fragment = new BaseFragment();
                ((BaseFragment) fragment).setTextViewText(getString(R.string.replaced_fragment) + time);
                replaceFragment(fragment);
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

    public void removeFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
    }

    public static Intent intent(Context context) {
        return new Intent(context, FragmentActivity.class);
    }
}
