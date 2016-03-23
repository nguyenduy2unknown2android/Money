package com.ahcoffee.nguyenduy.db.models;

import com.yahoo.squidb.annotations.ColumnSpec;
import com.yahoo.squidb.annotations.TableModelSpec;

/**
 * Created by nguyenduy on 22/03/2016.
 */
@TableModelSpec(className = "Person", tableName = "people")
public class PersonSpec {

    // A text column named "firstName"
    public String firstName;

    // A text column named "lastName"
    public String lastName;

    // A long column named "creationDate", but referred to as "birthday"
    // when working with the model
    @ColumnSpec(name = "creationDate")
    public long birthday;
}