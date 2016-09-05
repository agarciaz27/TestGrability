package com.eelseth.testgrability.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.eelseth.testgrability.R;
import com.eelseth.testgrability.adapters.AppsListAdapter;
import com.eelseth.testgrability.adapters.CategoriesListAdapter;
import com.eelseth.testgrability.interfaces.presenters.IAppsPresenter;
import com.eelseth.testgrability.interfaces.presenters.ICategoriesPresenter;
import com.eelseth.testgrability.interfaces.views.IAppsView;
import com.eelseth.testgrability.interfaces.views.ICategoriesView;
import com.eelseth.testgrability.model.Category;
import com.eelseth.testgrability.model.Entry;
import com.eelseth.testgrability.model.events.ToolbarEvent;
import com.eelseth.testgrability.presenters.AppsPresenter;
import com.eelseth.testgrability.presenters.CategoriesPresenter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.BooleanRes;
import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;
import java.util.List;

/**
 * Created by eelSeth on 9/3/2016.
 */

@EFragment(R.layout.fragment_apps)
public class AppsFragment extends Fragment implements IAppsView {

    @ViewById
    RecyclerView rvAppsList;


    @BooleanRes
    Boolean isPhone;

    private IAppsPresenter appsPresenter;
    private Category category;

    @Bean
    AppsListAdapter appsListAdapter;


    public static AppsFragment newInstance(Category category) {
        AppsFragment appsFragment = new AppsFragment_();
        Bundle args = new Bundle();
        args.putSerializable("category", (Serializable) category);
        appsFragment.setArguments(args);

        return appsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        category = (Category) getArguments().getSerializable("category");
    }


    @AfterViews
    void init() {
        EventBus.getDefault().post(new ToolbarEvent(category.getLabel()));
        //Initialize Recycler
        if(isPhone){
            rvAppsList.setLayoutManager(new GridLayoutManager(getContext(), 2));
        }else{
            rvAppsList.setLayoutManager(new GridLayoutManager(getContext(), 4));
        }

        appsPresenter = new AppsPresenter(this);
        showListApps(category.getAppsList());
    }

    @AfterViews
    void bindAdapter() {
        rvAppsList.setAdapter(appsListAdapter);
    }

    @Override
    public void showListApps(List<Entry> appsList) {
        appsListAdapter.notifyData(appsList);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        appsPresenter.onDestroy();
    }
}
