package com.ahcoffee.nguyenduy.ahcoffee;

import android.content.Context;

import com.ahcoffee.nguyenduy.squiddb.AhCoffeeDb;

import dagger.Module;

/**
 * Created by nguyen duy on 02/04/2016.
 */
@Module(injects = {AhCoffeeDb.class})
public class DbModule {

    private Context context;

    public DbModule(AhCoffee app) {
        this.context = app;
    }
}
