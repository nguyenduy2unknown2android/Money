package com.ahcoffee.nguyenduy.utility;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.ahcoffee.nguyenduy.ahcoffee.AhCoffee;
import com.ahcoffee.nguyenduy.ahcoffee.R;

/**
 * Created by nguyenduy on 09/03/2016.
 */
public class Configuration {

    private static Configuration _instance;

    protected Configuration(){

    }

    public Configuration Instance(){
        if (_instance == null){
            _instance = new Configuration();
        }

        return _instance;
    }

    private static SharedPreferences.Editor getEditor(int mode){
        SharedPreferences sharedPref = AhCoffee.Application.getSharedPreferences("AhCoffee", mode/*Context.MODE_PRIVATE*/);
        return sharedPref.edit();
    }

    public static void putInt(String key, int value, int mode) {
        getEditor(mode).putInt(key, value).commit();
    }

    public static void putString(String key, String value, int mode) {
        getEditor(mode).putString(key, value).commit();
    }

    public static void putBoolean(String key, boolean value, int mode) {
        getEditor(mode).putBoolean(key, value).commit();
    }
}