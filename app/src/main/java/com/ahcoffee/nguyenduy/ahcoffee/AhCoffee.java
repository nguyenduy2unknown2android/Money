package com.ahcoffee.nguyenduy.ahcoffee;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.firebase.client.Firebase;

public class AhCoffee extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initLib();
    }

    private void initLib(){
        Firebase.setAndroidContext(this);
    }
}
