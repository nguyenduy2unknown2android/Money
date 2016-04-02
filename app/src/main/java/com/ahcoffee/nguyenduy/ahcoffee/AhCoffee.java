package com.ahcoffee.nguyenduy.ahcoffee;

import android.content.Context;

import com.firebase.client.Firebase;

public class AhCoffee extends android.app.Application {
    public static Context Application;
    @Override
    public void onCreate() {
        super.onCreate();
        initLib();
    }

    private void initLib(){
        Application = getApplicationContext();
        Firebase.setAndroidContext(this);
        AhCoffeeInjector.init(this);
    }
}
