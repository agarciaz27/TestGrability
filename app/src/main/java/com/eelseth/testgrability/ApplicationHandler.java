package com.eelseth.testgrability;

import android.app.Application;
import android.content.Context;

import com.eelseth.testgrability.utils.NetworkHelper;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by eelSeth on 3/9/2016.
 */
public class ApplicationHandler extends Application {

    public static final String SERVER_URL = "https://itunes.apple.com/";
    public static final String TOP_FREE_URL = "us/rss/topfreeapplications/";

    private static Context context;
    private static ApplicationHandler instance;
    public static Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        context = getApplicationContext();
    }

    public static ApplicationHandler getInstance() {
        return instance;
    }

    public static Context getContext() {
        return context;
    }

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(SERVER_URL)
                    .client(NetworkHelper.provideOkHttpClient(getContext()))
                    .build();
        }
        return retrofit;
    }


}
