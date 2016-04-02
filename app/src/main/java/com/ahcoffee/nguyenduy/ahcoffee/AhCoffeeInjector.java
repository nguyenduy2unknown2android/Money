package com.ahcoffee.nguyenduy.ahcoffee;

import dagger.ObjectGraph;

/**
 * Created by nguyen duy on 02/04/2016.
 */
public class AhCoffeeInjector {
    private static AhCoffeeInjector _instance = null;
    private ObjectGraph mGraph;

    public static AhCoffeeInjector getInstatnce() {
        if (_instance == null) {
            throw new RuntimeException("Must call init(app) first");
        }
        return _instance;
    }

    public static AhCoffeeInjector init(AhCoffee app) {
        _instance = new AhCoffeeInjector(app);
        return _instance;
    }

    private AhCoffeeInjector(AhCoffee app) {
        mGraph = ObjectGraph.create(new DbModule(app));
    }

    public void inject(Object object) {
        mGraph.inject(object);
    }
}
