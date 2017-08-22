package com.app.broadcastrecieverexample;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.TextView;

/**
 * Created by iSaleem on 8/22/17.
 */

public class BatteryBroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        TextView tvLevel = ((Activity)context).findViewById(R.id.tvLevel);
        int level = intent.getIntExtra("level",0);
        tvLevel.setText(level+"");

        Intent goToMain = new Intent(context,MainActivity.class);
        goToMain.putExtra("name","ayman ayyad");

        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder notificationCompat = new NotificationCompat.Builder(context);
        notificationCompat.setAutoCancel(true);
        //notificationCompat.setOngoing(true);
        notificationCompat.setContentInfo("Info");
        notificationCompat.setContentText(level+"");
        notificationCompat.setContentTitle("Yamsahel");
        notificationCompat.setSmallIcon(R.mipmap.ic_launcher);
        notificationCompat.setContentIntent(pendingIntent);

        Notification notification = notificationCompat.build();
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(0,notification);

        //NotificationManager notificationManagerCompat = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

    }
}
