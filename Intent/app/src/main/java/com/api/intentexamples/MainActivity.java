package com.api.intentexamples;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button btn = (Button)findViewById(R.id.button);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),SecondActivity.class);
                //intent.putExtra(Constants.MESSAGE_KEY,"hello");
                //startActivity(intent);

                // serialization example
                /*
                Student student = new Student("120071744","Ayman Ayyad");

                intent.putExtra(Constants.MESSAGE_KEY,student);
                startActivityForResult(intent,Constants.RESULT_OK);
                */

                Employee employee = new Employee("ahmed","1232");
                intent.putExtra(Constants.MESSAGE_KEY,employee);
                startActivityForResult(intent,Constants.RESULT_OK);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Constants.RESULT_OK && resultCode == Constants.RESULT_OK){
            String value = data.getStringExtra(Constants.RESULT_KEY);
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
        }

    }
}
