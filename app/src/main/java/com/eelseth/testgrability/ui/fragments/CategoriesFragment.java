package com.eelseth.testgrability.ui.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.eelseth.testgrability.R;
import com.eelseth.testgrability.adapters.CategoriesListAdapter;
import com.eelseth.testgrability.interfaces.presenters.ICategoriesPresenter;
import com.eelseth.testgrability.interfaces.views.ICategoriesView;
import com.eelseth.testgrability.model.Category;
import com.eelseth.testgrability.model.GenericTag;
import com.eelseth.testgrability.model.events.ToolbarEvent;
import com.eelseth.testgrability.presenters.CategoriesPresenter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.BooleanRes;
import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by eelSeth on 9/3/2016.
 */

@EFragment(R.layout.fragment_categories)
public class CategoriesFragment extends Fragment implements ICategoriesView {

    @ViewById
    RecyclerView rvCategoriesList;

    @ViewById
    ProgressBar pbList;

    @BooleanRes
    Boolean isPhone;

    private ICategoriesPresenter categoriesPresenter;

    @Bean
    CategoriesListAdapter categoriesListAdapter;


    @AfterViews
    void init() {
        EventBus.getDefault().post(new ToolbarEvent("Categories"));
        setRetainInstance(true);
        //Initialize Recycler
        if(isPhone){
            rvCategoriesList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        }else{
            rvCategoriesList.setLayoutManager(new GridLayoutManager(getContext(), 3));
        }

        categoriesPresenter = new CategoriesPresenter(this);
        categoriesPresenter.loadFeed();
    }

    @AfterViews
    void bindAdapter() {
        rvCategoriesList.setAdapter(categoriesListAdapter);
    }

    @Override
    public void showListCategories(List<Category> categoriesList) {
        categoriesListAdapter.notifyData(categoriesList);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        pbList.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pbList.setVisibility(View.GONE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        categoriesPresenter.onDestroy();
    }
}
