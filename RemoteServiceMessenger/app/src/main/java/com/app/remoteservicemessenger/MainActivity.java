package com.app.remoteservicemessenger;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Messenger remoteService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent intent = new Intent(this,RemoteService.class);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("",""));
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            remoteService = new Messenger(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    public void sendMessage(View v){
        Message msg = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putString("msg","aaaaa");
        msg.setData(bundle);
        try {
            remoteService.send(msg);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
