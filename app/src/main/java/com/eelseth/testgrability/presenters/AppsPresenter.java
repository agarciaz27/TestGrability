package com.eelseth.testgrability.presenters;

import android.util.Log;

import com.eelseth.testgrability.interfaces.presenters.IAppsPresenter;
import com.eelseth.testgrability.interfaces.presenters.ICategoriesPresenter;
import com.eelseth.testgrability.interfaces.views.IAppsView;
import com.eelseth.testgrability.interfaces.views.ICategoriesView;
import com.eelseth.testgrability.model.Category;
import com.eelseth.testgrability.model.Content;
import com.eelseth.testgrability.model.Entry;
import com.eelseth.testgrability.services.FeedService;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.observables.GroupedObservable;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by eelSeth on 9/3/2016.
 */
public class AppsPresenter implements IAppsPresenter {

    private IAppsView appsView;
    List<Entry> appsList = new ArrayList<>();


    public AppsPresenter(IAppsView appsView) {
        this.appsView = appsView;

    }

    @Override
    public void loadAppsList(List<Entry> appsList) {
        this.appsList = appsList;
    }

    @Override
    public void onDestroy() {

    }
}
