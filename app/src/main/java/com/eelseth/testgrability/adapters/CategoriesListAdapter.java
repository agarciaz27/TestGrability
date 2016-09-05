package com.eelseth.testgrability.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.eelseth.testgrability.R;
import com.eelseth.testgrability.adapters.base.RecyclerViewAdapterBase;
import com.eelseth.testgrability.adapters.base.ViewWrapper;
import com.eelseth.testgrability.adapters.itemViews.CategoryItemView;
import com.eelseth.testgrability.adapters.itemViews.CategoryItemView_;
import com.eelseth.testgrability.model.Category;


import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.ViewById;

import java.util.List;

/**
 * Created by agarcia on 04/09/2016.
 */

@EBean
public class CategoriesListAdapter extends RecyclerViewAdapterBase<Category, CategoryItemView> {


    @RootContext
    Context context;


    @Override
    protected CategoryItemView onCreateItemView(ViewGroup parent, int viewType) {
        return CategoryItemView_.build(context);
    }

    @Override
    public void onBindViewHolder(ViewWrapper<CategoryItemView> viewHolder, int position) {
        CategoryItemView view = viewHolder.getView();
        Category category = items.get(position);
        view.bind(category);
    }

    public void notifyData(List<Category> categoryList) {
        this.items = categoryList;
        notifyDataSetChanged();
    }


}
