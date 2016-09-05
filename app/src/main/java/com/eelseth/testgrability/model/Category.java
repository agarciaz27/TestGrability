package com.eelseth.testgrability.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by eelSeth on 9/4/2016.
 */
public class Category implements Serializable{

    String label;
    List<Entry> appsList;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Entry> getAppsList() {
        return appsList;
    }

    public void setAppsList(List<Entry> appsList) {
        this.appsList = appsList;
    }
}
