package com.app.videoviewexample;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;

import static android.media.AudioManager.STREAM_MUSIC;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback{
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        surfaceView = (SurfaceView)findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(this);
        /*
        VideoView videoView = (VideoView)findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse(""));
        videoView.setMediaController(new MediaController(this));
        videoView.start();
        */



    }

    @Override
    public void surfaceCreated(SurfaceHolder msurfaceHolder) {
        Log.d("VIDEO","INNNN");
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDisplay(msurfaceHolder);
        try {
            mediaPlayer.setDataSource("http://techslides.com/demos/sample-videos/small.mp4");
            mediaPlayer.setAudioStreamType(STREAM_MUSIC);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mewdiaPlayer) {
                    mediaPlayer.start();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}
