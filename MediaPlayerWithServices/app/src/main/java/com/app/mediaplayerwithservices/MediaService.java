package com.app.mediaplayerwithservices;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by iSaleem on 8/27/17.
 */

public class MediaService extends Service implements MediaPlayer.OnCompletionListener,MediaPlayer.OnPreparedListener,MediaPlayer.OnErrorListener {
    MyBinder myBinder = new MyBinder();
    MediaPlayer mediaPlayer;
    boolean isPlay;
    private NotificationCompat.Builder notificationCompatBuilder;
    private RemoteViews remoteViews;


    @Override
    public void onCreate() {
        super.onCreate();
        initMediaPlayer();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if(intent !=null) {
            if (intent.getAction() != null) {

                switch (intent.getAction()) {
                    case "stop":
                        Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();

                        pause();
                        break;
                    case "delete":
                        stopSelf();
                        stopForeground(true);
                        mediaPlayer.release();
                        mediaPlayer = null;
                        break;
                }
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    public void initMediaPlayer(){
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnErrorListener(this);
        try {
            mediaPlayer.setDataSource("https://www.hrupin.com/wp-content/uploads/mp3/testsong_20_sec.mp3");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void play(){
        mediaPlayer.prepareAsync();
    }



    public void pause(){
        if(isPlay) {
            mediaPlayer.pause();
            isPlay = false;
            remoteViews.setImageViewResource(R.id.btnPlay, android.R.drawable.ic_media_play);
            startForeground(1,notificationCompatBuilder.build());
        }
        else {
            mediaPlayer.start();
            isPlay = true;
            remoteViews.setImageViewResource(R.id.btnPlay, android.R.drawable.ic_media_pause);
            startForeground(1,notificationCompatBuilder.build());
        }

    }

    public void stop(){
        mediaPlayer.reset();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

    }

    @Override
    public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
        isPlay = true;
        remoteViews = new RemoteViews(getPackageName(),R.layout.notification_view);
        remoteViews.setTextViewText(R.id.tvTitle,"Title");
        remoteViews.setImageViewUri(R.id.img,Uri.parse("http://img14.deviantart.net/5600/i/2012/034/c/f/haunted_castle___by_alzstock-d4ohpz0.png"));
        remoteViews.setImageViewResource(R.id.btnPlay, android.R.drawable.ic_media_pause);
        notificationCompatBuilder = new NotificationCompat.Builder(this);
        notificationCompatBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notificationCompatBuilder.setCustomBigContentView(remoteViews);
        notificationCompatBuilder.setAutoCancel(true);
        Intent returnToAppIntent = new Intent(this,MainActivity.class);
        PendingIntent returnToApp = PendingIntent.getActivity(this,200,returnToAppIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        notificationCompatBuilder.setContentIntent(returnToApp);



        Intent actions = new Intent(this,MediaService.class);
        actions.setAction("stop");
        PendingIntent pendingIntentPlay = PendingIntent.getService(this,201,actions,PendingIntent.FLAG_UPDATE_CURRENT);
        remoteViews.setOnClickPendingIntent(R.id.btnPlay,pendingIntentPlay);

        actions = new Intent(this,MediaService.class);
        actions.setAction("delete");
        notificationCompatBuilder.setDeleteIntent(getPendingIntent(actions,300));


        startForeground(1,notificationCompatBuilder.build());

    }

    class MyBinder extends Binder{
        MediaService getService(){
            return MediaService.this;
        }
    }

    public PendingIntent getPendingIntent(Intent intent,int requestCode){
        PendingIntent pendingIntent = PendingIntent.getService(this,requestCode,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        return pendingIntent;
    }

    /*
    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
        //stopForeground(true);
    }
    */


    /*
    @Override
    public boolean onUnbind(Intent intent) {
        myBinder = null;
        return true;
    }
    */
}
