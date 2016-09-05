package com.eelseth.testgrability.ui.activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.eelseth.testgrability.R;
import com.eelseth.testgrability.model.Category;
import com.eelseth.testgrability.model.Entry;
import com.eelseth.testgrability.model.events.AppEvent;
import com.eelseth.testgrability.model.events.CategoryEvent;
import com.eelseth.testgrability.model.events.ToolbarEvent;
import com.eelseth.testgrability.ui.fragments.AppDetailFragment;
import com.eelseth.testgrability.ui.fragments.AppDetailFragment_;
import com.eelseth.testgrability.ui.fragments.AppsFragment;
import com.eelseth.testgrability.ui.fragments.AppsFragment_;
import com.eelseth.testgrability.ui.fragments.CategoriesFragment;
import com.eelseth.testgrability.ui.fragments.CategoriesFragment_;
import com.eelseth.testgrability.utils.NetworkHelper;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.AnimationRes;
import org.androidannotations.annotations.res.BooleanRes;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


@EActivity(R.layout.activity_home)

public class HomeActivity extends AppCompatActivity {

    @ViewById
    FrameLayout flContainer;

    @ViewById
    Toolbar tbHome;

    @BooleanRes
    Boolean isPhone;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @AfterViews
    void init(){
        EventBus.getDefault().register(this);
        fragmentManager = getSupportFragmentManager();
        setOrientation();
        setupToolbar();
        checkNetworkConnection();
        addCategoriesFragment();
    }

    private void setupToolbar(){
        setSupportActionBar(tbHome);
    }

    private void setOrientation(){
        if(isPhone){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else{
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    private void addCategoriesFragment(){
        CategoriesFragment categoriesFragment = new CategoriesFragment_();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.flContainer, categoriesFragment, null);
        fragmentTransaction.commit();
    }

    private void addAppsFragment(Category category){
        AppsFragment appsFragment = AppsFragment_.newInstance(category);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        fragmentTransaction.replace(R.id.flContainer, appsFragment, null);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void addAppDetailFragment(Entry app){
        AppDetailFragment appDetailFragment = AppDetailFragment_.newInstance(app);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        fragmentTransaction.replace(R.id.flContainer, appDetailFragment, null);

        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEvent(CategoryEvent event) {
        addAppsFragment(event.category);
    };

    @Subscribe
    public void onEvent(AppEvent event) {
        addAppDetailFragment(event.app);
    };

    @Subscribe
    public void onEvent(ToolbarEvent event) {
        getSupportActionBar().setTitle(event.name);
    }

    private void checkNetworkConnection(){
        if(!NetworkHelper.checkIfHasNetwork(this)){
            Snackbar.make(tbHome, "No internet connection", Snackbar.LENGTH_LONG).show();
        }
    }



}
