package com.eelseth.testgrability.interfaces.views;

import com.eelseth.testgrability.model.Category;
import com.eelseth.testgrability.model.Entry;

import java.util.List;

/**
 * Created by eelSeth on 9/3/2016.
 */
public interface IAppsView {

    void showListApps(List<Entry> appsList);
    void showMessage(String message);
}
