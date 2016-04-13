package com.ahcoffee.nguyenduy.squiddb.business;

import com.ahcoffee.nguyenduy.squiddb.AhCoffeeDb;
import com.ahcoffee.nguyenduy.squiddb.models.Person;
import com.yahoo.squidb.data.SquidCursor;
import com.yahoo.squidb.sql.Query;

import junit.framework.Assert;

import javax.inject.Inject;

/**
 * Created by nguyenduy on 22/03/2016.
 */
public class PersonBusiness {
    private AhCoffeeDb db;
    public PersonBusiness(){

    }

    public SquidCursor<Person> getAllPersons(){
        Query query = Query.select(Person.PROPERTIES);
        SquidCursor<Person> result = db.query(Person.class, query);
        return result;
    }
}
