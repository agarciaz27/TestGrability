package com.eelseth.testgrability.services;

import com.eelseth.testgrability.ApplicationHandler;
import com.eelseth.testgrability.model.Category;
import com.eelseth.testgrability.model.Content;
import com.eelseth.testgrability.model.Feed;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by eelSeth on 9/3/2016.
 */
public class FeedService {


    public Observable<Content> getFeedAppsObservable(){
        return  ApplicationHandler.getRetrofit()
                .create(FeedApi.class)
                .getFeedApps();
    }

    private interface FeedApi {

        @GET(ApplicationHandler.TOP_FREE_URL + "/limit=20/json")
        public Observable<Content> getFeedApps();

    }
}
