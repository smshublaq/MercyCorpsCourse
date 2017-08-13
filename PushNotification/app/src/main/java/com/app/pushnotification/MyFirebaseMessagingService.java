package com.app.pushnotification;

import android.app.Service;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by iSaleem on 8/13/17.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(final RemoteMessage remoteMessage) {

        Handler h = new Handler(Looper.getMainLooper());
        h.post(new Runnable() {
            public void run() {
                Toast.makeText(getApplicationContext(), "Your message to main thread", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
