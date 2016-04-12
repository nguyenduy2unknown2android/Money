package com.ahcoffee.nguyenduy.ahcoffee;

import dagger.ObjectGraph;

/**
 * Created by nguyen duy on 02/04/2016.
 */
public class AppInjector {
    private static AppInjector _instance = null;

    private ObjectGraph mGraph;

    private AppInjector() {
        mGraph = ObjectGraph.create(new DbModule());
    }

    public static AppInjector getInstatnce() {
        if (_instance == null) {
            throw new RuntimeException("Must call init(app) first");
        }
        return _instance;
    }

    public static AppInjector init() {
        _instance = new AppInjector();
        return _instance;
    }

    public void inject(Object object) {
        mGraph.inject(object);
    }
}
