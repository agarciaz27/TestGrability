package com.eelseth.testgrability.adapters;

import android.content.Context;
import android.view.ViewGroup;

import com.eelseth.testgrability.adapters.base.RecyclerViewAdapterBase;
import com.eelseth.testgrability.adapters.base.ViewWrapper;
import com.eelseth.testgrability.adapters.itemViews.AppItemView;
import com.eelseth.testgrability.adapters.itemViews.AppItemView_;
import com.eelseth.testgrability.adapters.itemViews.CategoryItemView;
import com.eelseth.testgrability.adapters.itemViews.CategoryItemView_;
import com.eelseth.testgrability.model.Category;
import com.eelseth.testgrability.model.Entry;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

/**
 * Created by agarcia on 04/09/2016.
 */

@EBean
public class AppsListAdapter extends RecyclerViewAdapterBase<Entry, AppItemView> {


    @RootContext
    Context context;


    @Override
    protected AppItemView onCreateItemView(ViewGroup parent, int viewType) {
        return AppItemView_.build(context);
    }

    @Override
    public void onBindViewHolder(ViewWrapper<AppItemView> viewHolder, int position) {
        AppItemView view = viewHolder.getView();
        Entry entry = items.get(position);
        view.bind(entry);
    }

    public void notifyData(List<Entry> entryList) {
        this.items = entryList;
        notifyDataSetChanged();
    }


}
