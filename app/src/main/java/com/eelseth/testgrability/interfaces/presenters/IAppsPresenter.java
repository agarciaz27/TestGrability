package com.eelseth.testgrability.interfaces.presenters;

import com.eelseth.testgrability.model.Entry;

import java.util.List;

/**
 * Created by eelSeth on 9/3/2016.
 */
public interface IAppsPresenter {

    void loadAppsList(List<Entry> appsList);
    void onDestroy();

}
