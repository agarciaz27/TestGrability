package com.eelseth.testgrability.presenters;

import android.util.Log;

import com.eelseth.testgrability.interfaces.presenters.ICategoriesPresenter;
import com.eelseth.testgrability.interfaces.views.ICategoriesView;
import com.eelseth.testgrability.model.Category;
import com.eelseth.testgrability.model.Content;
import com.eelseth.testgrability.model.Entry;
import com.eelseth.testgrability.model.Feed;
import com.eelseth.testgrability.model.GenericTag;
import com.eelseth.testgrability.services.FeedService;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observables.GroupedObservable;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by eelSeth on 9/3/2016.
 */
public class CategoriesPresenter implements ICategoriesPresenter {

    private ICategoriesView categoriesView;
    private FeedService feedService;

    private CompositeSubscription compositeSubscription;
    private Subscription subscriptionFeed;

    private Content content;
    List<Category> categoriesList = new ArrayList<>();


    public CategoriesPresenter(ICategoriesView categoriesView) {
        this.categoriesView = categoriesView;
        this.feedService = new FeedService();

        compositeSubscription = new CompositeSubscription();

    }

    @Override
    public void loadFeed() {
        subscriptionFeed = feedService.getFeedAppsObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Content>() {
                    @Override
                    public void onCompleted() {
                        loadCategories();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Content contentFeed) {
                        content = contentFeed;
                    }
                });

        compositeSubscription.add(subscriptionFeed);
    }

    private void loadCategories() {

        Observable.from(content.getFeed().getEntry())
                .groupBy(new Func1<Entry, String>() {
                    @Override
                    public String call(Entry entry) {
                        return entry.getCategory().getAttributes().getLabel();
                    }
                })
                .subscribe(new Subscriber<GroupedObservable<String, Entry>>() {
                    @Override
                    public void onCompleted() {
                        categoriesView.showListCategories(categoriesList);
                        categoriesView.hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        categoriesView.hideLoading();
                    }

                    @Override
                    public void onNext(final GroupedObservable<String, Entry> entry) {
                        final Category category = new Category();
                        entry.toList().subscribe(new Subscriber<List<Entry>>() {
                            @Override
                            public void onCompleted() {
                                category.setLabel(entry.getKey());
                                categoriesList.add(category);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(List<Entry> entries) {
                                category.setAppsList(entries);
                            }
                        });
                    }
                });
    }

    public void onDestroy() {
        compositeSubscription.clear();
    }
}
