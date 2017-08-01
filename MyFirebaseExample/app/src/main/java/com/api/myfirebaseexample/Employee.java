package com.api.myfirebaseexample;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by iSaleem on 8/1/17.
 */
@IgnoreExtraProperties
public class Employee {

    public String name;
    public String id;

    public Employee(){

    }

    public Employee(String name,String id){
        this.name = name;
        this.id = id;
    }
}
