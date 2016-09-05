package com.eelseth.testgrability.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.eelseth.testgrability.R;
import com.eelseth.testgrability.adapters.AppsListAdapter;
import com.eelseth.testgrability.interfaces.presenters.IAppsPresenter;
import com.eelseth.testgrability.interfaces.views.IAppDetailView;
import com.eelseth.testgrability.interfaces.views.IAppsView;
import com.eelseth.testgrability.model.Category;
import com.eelseth.testgrability.model.Entry;
import com.eelseth.testgrability.model.events.ToolbarEvent;
import com.eelseth.testgrability.presenters.AppsPresenter;

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

@EFragment(R.layout.fragment_app_detail)
public class AppDetailFragment extends Fragment implements IAppDetailView {


    @ViewById
    TextView tvAppTitle;

    @ViewById
    TextView tvAppArtist;

    @ViewById
    TextView tvAppSummary;

    @ViewById
    TextView tvAppDate;

    @ViewById
    ImageView ivAppIcon;

    private Entry app;


    public static AppDetailFragment newInstance(Entry app) {
        AppDetailFragment appDetailFragment = new AppDetailFragment_();
        Bundle args = new Bundle();
        args.putSerializable("app", (Serializable) app);
        appDetailFragment.setArguments(args);

        return appDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        app = (Entry) getArguments().getSerializable("app");
    }


    @AfterViews
    void init() {
        EventBus.getDefault().post(new ToolbarEvent(app.getImName().getLabel()));
        loadInfoApp();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void loadInfoApp() {
        tvAppTitle.setText(app.getImName().getLabel());
        tvAppArtist.setText(app.getImArtist().getLabel());
        tvAppSummary.setText(app.getSummary().getLabel());
        tvAppDate.setText(app.getImReleaseDate().getAttributes().getLabel());
        Glide.with(this.getContext())
                .load(app.getImImage().get(2).getLabel())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .priority(Priority.HIGH)
                .fitCenter()
                .into(ivAppIcon);
    }
}
