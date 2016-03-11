package com.ahcoffee.nguyenduy.utility;

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


}
