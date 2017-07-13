package example.com.boundservice;

import android.app.Service;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.text.format.DateFormat;

import java.util.Date;
import java.util.Locale;

/**
 * Created by iSaleem on 12/19/16.
 */

public class MyService extends Service {

    public final IBinder myBinder = new MyLocalBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    public String getCurrentTime(){
        return DateFormat.format("MM/dd/yy h:mmaa", System.currentTimeMillis())+"";
    }


    public class MyLocalBinder extends Binder {

        MyService getService(){
            return MyService.this;
        }


    }
}
