package com.ahcoffee.nguyenduy.ahcoffee;

import android.content.Context;

import com.ahcoffee.nguyenduy.squiddb.AhCoffeeDb;
import com.ahcoffee.nguyenduy.squiddb.business.PersonBusiness;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nguyen duy on 02/04/2016.
 */
@Module(injects = PersonBusiness.class,library = true)
public class DbModule {

    @Provides AhCoffeeDb provideAhCoffeeDb() {
        AhCoffeeDb db = AhCoffeeDb.getInstance();
        return db;
    }
}
