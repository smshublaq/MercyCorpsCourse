package com.api.intentexamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        //Student student = (Student)intent.getSerializableExtra(Constants.MESSAGE_KEY);
        Employee employee = (Employee) intent.getParcelableExtra(Constants.MESSAGE_KEY);

        if(intent != null) {
            if (intent.hasExtra(Constants.MESSAGE_KEY))
                //Toast.makeText(this, intent.getStringExtra(Constants.MESSAGE_KEY), Toast.LENGTH_SHORT).show();
                //intent.getIntExtra(Constants.MESSAGE_KEY,-1)
            //Toast.makeText(this, student.getName() , Toast.LENGTH_SHORT).show();
            Toast.makeText(this, employee.getName() , Toast.LENGTH_SHORT).show();

        }

        Button btn = (Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
                data.putExtra(Constants.RESULT_KEY,"Laptop");
                setResult(Constants.RESULT_OK,data);
                finish();
            }
        });
    }
}
