package com.app.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Date;

/**
 * Created by iSaleem on 8/27/17.
 */

public class LocalService extends Service {

    Binder binder = new MyBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    class MyBinder extends Binder{
        LocalService getService(){
            return LocalService.this;
        }
    }

    public String getCurrentData(){
        return new Date().toString();
    }

}
