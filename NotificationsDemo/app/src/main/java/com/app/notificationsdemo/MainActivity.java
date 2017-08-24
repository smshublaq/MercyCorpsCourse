package com.app.notificationsdemo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.RemoteInput;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import static android.app.NotificationManager.IMPORTANCE_LOW;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.btn);

        final NotificationManager notificationManage = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        NotificationChannel channel = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            channel = new NotificationChannel("myChannel","aaa",IMPORTANCE_LOW);
            notificationManage.createNotificationChannel(channel);
        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent goToSecond = new Intent(view.getContext(),SecondActivity.class);

                PendingIntent replyIntent = PendingIntent.getActivity(view.getContext(),1,goToSecond,PendingIntent.FLAG_UPDATE_CURRENT);


                RemoteInput.Builder remoteInput = new RemoteInput.Builder("replyKey");
                remoteInput.setLabel("Reply");
                RemoteInput myRemoteInput = remoteInput.build();

                NotificationCompat.Action.Builder replyActionBuilder = new NotificationCompat.Action.Builder(R.mipmap.ic_launcher,"Reply",replyIntent);
                NotificationCompat.Action replyAction = replyActionBuilder.addRemoteInput(myRemoteInput).build();
                NotificationCompat.Action send = replyActionBuilder.build();

                final NotificationCompat.Builder notificationCompat = new NotificationCompat
                        .Builder(view.getContext());
                notificationCompat.setSmallIcon(R.mipmap.ic_launcher);
                notificationCompat.setContentText("aaa");
                notificationCompat.setContentInfo("bbbb");
                notificationCompat.addAction(replyAction);
                notificationCompat.addAction(R.mipmap.ic_launcher,"Ok",replyIntent);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i= 0;i<100;i+=10){
                            notificationCompat.setProgress(100,i,false);
                            notificationManage.notify(1,notificationCompat.build());
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        notificationCompat.setProgress(0,0,false);
                        notificationManage.notify(1,notificationCompat.build());


                    }
                }).start();

                TaskStackBuilder taskStackBuilder = TaskStackBuilder
                        .create(view.getContext());
                taskStackBuilder.addParentStack(SecondActivity.class);
                taskStackBuilder.addNextIntent(goToSecond);

                //PendingIntent pendingIntent = PendingIntent.getActivity(view.getContext(),1,goToSecond,PendingIntent.FLAG_UPDATE_CURRENT);

                PendingIntent pendingIntent = taskStackBuilder
                        .getPendingIntent(1,PendingIntent.FLAG_UPDATE_CURRENT);

                Intent deleteIntent = new Intent(view.getContext(),
                        DeleteIntentBroadcast.class);
                PendingIntent pendingDeleteIntent = PendingIntent
                        .getBroadcast(view.getContext(),
                                200,deleteIntent,PendingIntent.FLAG_UPDATE_CURRENT);

                notificationCompat.setDeleteIntent(pendingDeleteIntent);
                notificationCompat.setAutoCancel(true);
                //notificationCompat.setVibrate(new long[]{2000,1000,2000});

                //notificationCompat.setContentIntent(pendingIntent);

                NotificationCompat.InboxStyle myStyle = new NotificationCompat.InboxStyle();

                myStyle.setBigContentTitle("Big Content");

                myStyle.addLine("a");
                myStyle.addLine("b");
                myStyle.addLine("c");
                myStyle.addLine("d");
                myStyle.addLine("e");
                myStyle.addLine("f");
                myStyle.addLine("g");

                notificationCompat.setStyle(myStyle);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(view.getContext());

                managerCompat.notify(1,notificationCompat.build());




                //managerCompat.cancelAll();
                //managerCompat.cancel(1);
            }
        });

    }

    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
    */
}
