package com.app.pushnotification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Singleton singleton = Singleton.getAnInstance();

        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d("TOKEN",token+"");


    }
}
