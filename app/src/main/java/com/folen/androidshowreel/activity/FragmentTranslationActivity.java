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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.folen.androidshowreel.R;
import com.folen.androidshowreel.base.BaseActivity;
import com.folen.androidshowreel.util.FirstTranslationFragment;
import com.folen.androidshowreel.util.SecondTranslationFragment;

public class FragmentTranslationActivity extends BaseActivity {

    private Toolbar mToolbar;
    private Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translation_fragment);

        setupToolbar();
    }

    private void setupToolbar() {
        mToolbar = findViewById(R.id.fragment_toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("Fragments");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_anim, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_fadein:
                fragment = new FirstTranslationFragment();
                addFragmentFadeAnim(fragment);
                break;
            case R.id.action_replace_fadein:
                fragment = new SecondTranslationFragment();
                replaceFragmentFadeAnim(fragment);
                break;
            case R.id.action_add_right:
                fragment = new FirstTranslationFragment();
                addFragmentSlideAnim(fragment);
                break;
            case R.id.action_replace_right:
                fragment = new SecondTranslationFragment();
                replaceFragmentSlideAnim(fragment);
                break;
            case R.id.action_remove_fadeout:
                removeFragmentFadeAnim(fragment);
                break;
            case R.id.action_remove_left:
                removeFragmentSlideAnim(fragment);
                break;
            case android.R.id.home:
                removeFragment(fragment);
                break;
        }
        return true;
    }

    public void addFragmentFadeAnim(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
        fragmentTransaction.add(R.id.fragment_content, fragment);
        fragmentTransaction.commit();
    }

    public void replaceFragmentFadeAnim(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
        fragmentTransaction.replace(R.id.fragment_content, fragment);
        fragmentTransaction.commit();
    }

    public void removeFragmentFadeAnim(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fade_out,R.anim.fade_in);
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
    }

    public void addFragmentSlideAnim(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_right,R.anim.slide_left);
        fragmentTransaction.add(R.id.fragment_content, fragment);
        fragmentTransaction.commit();
    }

    public void replaceFragmentSlideAnim(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_right,R.anim.slide_left);
        fragmentTransaction.replace(R.id.fragment_content, fragment);
        fragmentTransaction.commit();
    }

    public void removeFragmentSlideAnim(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_left,R.anim.slide_right);
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
    }

    public void removeFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
    }

    public static Intent intent(Context context) {
        return new Intent(context, FragmentTranslationActivity.class);
    }
}
