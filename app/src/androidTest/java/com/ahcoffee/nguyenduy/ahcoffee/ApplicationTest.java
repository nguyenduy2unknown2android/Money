package com.ahcoffee.nguyenduy.ahcoffee;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.test.ApplicationTestCase;
import android.test.MoreAsserts;

import com.ahcoffee.nguyenduy.squiddb.AhCoffeeDb;
import com.ahcoffee.nguyenduy.squiddb.business.PersonBusiness;
import com.ahcoffee.nguyenduy.squiddb.models.Person;
import com.yahoo.squidb.data.SquidCursor;
import com.yahoo.squidb.sql.Query;

import junit.framework.Assert;

import javax.inject.Inject;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<AhCoffee> {
    private Context context;
    public ApplicationTest() {
        super(AhCoffee.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        this.context = getContext();
    }

    public void testCorrectVersion() throws Exception {
        PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        assertNotNull(info);
        MoreAsserts.assertMatchesRegex("\\d\\.\\d", info.versionName);
    }

    public void testDb() throws Exception {
        AhCoffeeDb db = AhCoffeeDb.getInstance();
        Assert.assertNotNull(db);
        Assert.assertEquals(db.getName(), "ahcoffee-database.db");
    }

    public void testPersonSpec() throws Exception{
        AhCoffeeDb db = AhCoffeeDb.getInstance();
        Query query = Query.select(Person.PROPERTIES);
        SquidCursor<Person> result = db.query(Person.class, query);
        Assert.assertNotNull(result);
    }

    public void testPersonBus() throws Exception{
        PersonBusiness bus = new PersonBusiness();
        Assert.assertNotNull(bus.getAllPersons());
    }

    private AhCoffeeDb ahdb;
    public void testInjectedDb() throws Exception{
        Query query = Query.select(Person.PROPERTIES);
        SquidCursor<Person> result = ahdb.query(Person.class, query);
        Assert.assertNotNull(result);
    }
}