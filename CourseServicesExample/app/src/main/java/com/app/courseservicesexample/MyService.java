package com.app.courseservicesexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by iSaleem on 8/27/17.
 */

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();

    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String msg = intent.getStringExtra("msg");
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        
        /*
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
        */


        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        Toast.makeText(this, "Destroyed", Toast.LENGTH_SHORT).show();

        super.onDestroy();

    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
