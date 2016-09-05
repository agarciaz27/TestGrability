package com.eelseth.testgrability.model.events;

import com.eelseth.testgrability.model.Category;
import com.eelseth.testgrability.model.Entry;

/**
 * Created by agarcia on 26/05/2016.
 */
public class AppEvent {

    public final Entry app;

    public AppEvent(Entry app) {
        this.app = app;
    }


}
