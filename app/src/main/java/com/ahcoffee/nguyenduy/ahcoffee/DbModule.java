package com.ahcoffee.nguyenduy.ahcoffee;

import android.content.Context;

import com.ahcoffee.nguyenduy.activities.MainActivity;
import com.ahcoffee.nguyenduy.ahcoffee.AhCoffee;
import com.ahcoffee.nguyenduy.db.AhCoffeeDb;
import com.ahcoffee.nguyenduy.db.business.PersonBusiness;

import javax.inject.Singleton;

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
