package com.api.myfirebaseexample;

import android.app.Application;

import com.google.firebase.FirebaseApp;

/**
 * Created by iSaleem on 7/31/17.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this);
    }
}
