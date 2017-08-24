package com.app.notificationsdemo;

import android.support.v4.app.RemoteInput;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Bundle remoteInput = RemoteInput.getResultsFromIntent(getIntent());
        if(remoteInput != null) {
            Toast.makeText(this, remoteInput.getCharSequence("replyKey"), Toast.LENGTH_SHORT).show();
        }
    }
}
