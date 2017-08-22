package example.com.boundservicesexample;

import android.app.IntentService;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.text.format.DateFormat;

/**
 * Created by iSaleem on 12/19/16.
 */

public class MyIntentService extends IntentService {

    IBinder binder = new MyBinder();



    public String getCurrentTime(){
        return DateFormat.format("MM/dd/yy h:mmaa", System.currentTimeMillis())+"";
    }

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public class MyBinder extends Binder {
        MyIntentService myService(){
            return MyIntentService.this;
        }
    }
}
