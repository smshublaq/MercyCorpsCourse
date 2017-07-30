package com.api.sharedpreferencesexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // على مستوى الابلكيشن
        //PreferenceManager.getDefaultSharedPreferences(this);
        // على مستوى اكتفتي
        //SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        // على مستوى الابلكيشن لكن بناء على الاسم و يتم عمل ملف منفصل لكل واحدة
        SharedPreferences sharedPreferences = getSharedPreferences(Constants.USER_SHARED,MODE_PRIVATE);

        /*
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Constants.USERNAME,"ayman@ayman.com");
        //editor.apply();
        //boolean isCommitted = editor.commit();

        //editor.clear();
        //editor.apply();
        */
        Toast.makeText(this,sharedPreferences.getString(Constants.USERNAME,""), Toast.LENGTH_SHORT).show();
    }
}
