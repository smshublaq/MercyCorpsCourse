package com.app.pushnotification;

/**
 * Created by iSaleem on 8/13/17.
 */

public class Singleton {

    private static Singleton anInstance = null;


    private Singleton(){

    }

    public static Singleton getAnInstance(){
        if(anInstance == null)
            return anInstance = new Singleton();

        return anInstance;
    }
}
