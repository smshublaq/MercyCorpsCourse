package com.app.boundservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LocalService localService;
    boolean isBound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this,LocalService.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);

        Button btnDate = (Button)findViewById(R.id.btnDate);
        final TextView tvDate = (TextView)findViewById(R.id.tvDate);
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBound){
                    tvDate.setText(localService.getCurrentData());
                }
            }
        });
    }


    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            localService = ((LocalService.MyBinder)iBinder).getService();
            isBound = true;
            Toast.makeText(localService, "Connected", Toast.LENGTH_SHORT).show();
        }


        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound = false;
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(serviceConnection);
    }
}
