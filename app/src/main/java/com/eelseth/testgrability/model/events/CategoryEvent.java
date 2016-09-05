package com.eelseth.testgrability.model.events;

import com.eelseth.testgrability.model.Category;

/**
 * Created by agarcia on 26/05/2016.
 */
public class CategoryEvent {

    public final Category category;

    public CategoryEvent(Category category) {
        this.category = category;
    }


}
