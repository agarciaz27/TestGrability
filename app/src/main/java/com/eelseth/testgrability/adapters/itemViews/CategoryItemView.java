package com.eelseth.testgrability.adapters.itemViews;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eelseth.testgrability.R;
import com.eelseth.testgrability.model.Category;
import com.eelseth.testgrability.model.events.CategoryEvent;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;
import org.greenrobot.eventbus.EventBus;

@EViewGroup(R.layout.item_category)
public class CategoryItemView extends LinearLayout {

    @ViewById
    TextView tvCategoryTitle;

    @ViewById
    CardView cvItemCategory;


    public CategoryItemView(Context context) {
        super(context);
    }

    public void bind(final Category category) {
        tvCategoryTitle.setText(category.getLabel());
        cvItemCategory.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new CategoryEvent(category));
            }
        });
    }

}