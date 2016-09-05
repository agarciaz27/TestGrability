package com.eelseth.testgrability.adapters.itemViews;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.eelseth.testgrability.R;
import com.eelseth.testgrability.model.Category;
import com.eelseth.testgrability.model.Entry;
import com.eelseth.testgrability.model.events.AppEvent;
import com.eelseth.testgrability.model.events.CategoryEvent;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.EventBus;

@EViewGroup(R.layout.item_app)
public class AppItemView extends LinearLayout {

    @ViewById
    TextView tvAppTitle;

    @ViewById
    TextView tvAppArtist;

    @ViewById
    ImageView ivAppIcon;

    @ViewById
    CardView cvItemApp;


    public AppItemView(Context context) {
        super(context);
    }

    public void bind(final Entry entry) {
        tvAppTitle.setText(entry.getImName().getLabel());
        tvAppArtist.setText(entry.getImArtist().getLabel());

        if(entry.getImImage() != null && !entry.getImImage().isEmpty()){
            Glide.with(this.getContext())
                    .load(entry.getImImage().get(2).getLabel())
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .priority(Priority.HIGH)
                    .fitCenter()
                    .into(ivAppIcon);
        }


        cvItemApp.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new AppEvent(entry));
            }
        });
    }

}