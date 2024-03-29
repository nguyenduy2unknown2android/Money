package com.ahcoffee.nguyenduy.squiddb;

import android.content.Context;

import com.ahcoffee.nguyenduy.ahcoffee.AhCoffee;
import com.ahcoffee.nguyenduy.squiddb.models.Person;
import com.yahoo.squidb.data.SquidDatabase;
import com.yahoo.squidb.data.adapter.SQLiteDatabaseWrapper;
import com.yahoo.squidb.sql.Table;

/**
 * Created by nguyenduy on 22/03/2016.
 */
public class AhCoffeeDb extends SquidDatabase {
    private static final int VERSION = 1;

    private static AhCoffeeDb _instance;

    private AhCoffeeDb(Context context) {
        super(context);
    }

    public static AhCoffeeDb getInstance(){
        if (_instance == null)
            _instance = new AhCoffeeDb(AhCoffee.Application);

        return _instance;
    }

    @Override
    public String getName() {
        return "ahcoffee-database.db";
    }

    @Override
    protected Table[] getTables() {
        return new Table[]{
                // List all tables here
                Person.TABLE,
        };
    }

    @Override
    protected boolean onUpgrade(SQLiteDatabaseWrapper db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
                tryCreateTable(Person.TABLE);
        }
        return false;
    }

    @Override
    protected int getVersion() {
        return VERSION;
    }
}