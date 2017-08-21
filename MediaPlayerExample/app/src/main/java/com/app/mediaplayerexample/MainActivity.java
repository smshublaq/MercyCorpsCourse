package com.app.mediaplayerexample;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import butterknife.ButterKnife;

import static android.media.AudioManager.STREAM_RING;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener {

    private MediaPlayer player;
    private MediaPlayer mediaPlayer;
    private MediaRecorder mediaRecorder;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //utterKnife.

        Button btnPlay = (Button)findViewById(R.id.btnPlay);
        Button btnPause = (Button)findViewById(R.id.btnPause);
        Button btnStop = (Button)findViewById(R.id.btnStop);

        mediaPlayer = new MediaPlayer();

        try {
            mediaPlayer.setDataSource("https://download.tvquran.com/download/tilawa_01/TvQuran.com__040.mp3");
            mediaPlayer.prepareAsync();

        } catch (IOException e) {
            e.printStackTrace();
        }
        String recordPath = getExternalCacheDir().getAbsolutePath() + "record.3gp";
        path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/aa.mp3";
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        /*
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player = MediaPlayer.create(view.getContext(),R.raw.oxygen_android);
                player.setLooping(true);
                player.start();
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.pause();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.stop();
            }
        });
        */

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.setOnPreparedListener(MainActivity.this);

                    //mediaPlayer.prepare();
                    //mediaPlayer.start();

            }
        });


        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.RECORD_AUDIO},200);
        }else {
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFile(path);
            mediaRecorder.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //player.release();
        //player = null;
        mediaPlayer.release();
        mediaPlayer = null;
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 200){
            if(grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED){
                mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                mediaRecorder.setOutputFile(path);
                mediaRecorder.start();
            }
            else {
                finish();
            }
        }
    }
}
