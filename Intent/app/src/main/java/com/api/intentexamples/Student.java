package com.api.intentexamples;

import java.io.Serializable;

/**
 * Created by iSaleem on 7/23/17.
 */

public class Student implements Serializable{
    private String id;
    private String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
