package com.eelseth.testgrability.interfaces.views;

import com.eelseth.testgrability.model.Category;
import com.eelseth.testgrability.model.GenericTag;

import java.util.List;

/**
 * Created by eelSeth on 9/3/2016.
 */
public interface ICategoriesView {

    void showListCategories(List<Category> categoriesList);
    void showMessage(String message);

    void showLoading();
    void hideLoading();
}
