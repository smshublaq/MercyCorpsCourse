package com.app.notificationsdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by iSaleem on 8/24/17.
 */

public class DeleteIntentBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Delete Done", Toast.LENGTH_SHORT).show();

    }
}
