package com.api.myfirebaseexample;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by iSaleem on 8/1/17.
 */

@IgnoreExtraProperties
class Student {

    public  String s;
    public  int i;

    public Student(String s, int i) {
        this.s = s;
        this.i = i;
    }

    public Student(){

    }
}
