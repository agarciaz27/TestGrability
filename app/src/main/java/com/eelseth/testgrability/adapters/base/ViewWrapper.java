package com.eelseth.testgrability.adapters.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by eelSeth on 9/4/2016.
 */
public class ViewWrapper<V extends View> extends RecyclerView.ViewHolder {

    private V view;

    public ViewWrapper(V itemView) {
        super(itemView);
        view = itemView;
    }

    public V getView() {
        return view;
    }
}
