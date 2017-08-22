package example.com.boundservicesexample;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyService myService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this,MyService.class);
        bindService(intent ,myServiceConnection, Context.BIND_AUTO_CREATE);
        //unbindService(myServiceConnection);
        //startService(intent);
        Button btnShow = (Button)findViewById(R.id.btnShow);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), myService.getCurrentTime(), Toast.LENGTH_SHORT).show();
            }
        });

        WebView web = (WebView)findViewById(R.id.web);
        web.loadUrl("http://www.aljazeera.net/portal");

    }

    private ServiceConnection myServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyService.MyBinder binder = (MyService.MyBinder)iBinder;
            myService = binder.myService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };


}
