package com.pogo.listviewexample;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lst = (ListView)findViewById(R.id.lst);
        //GridView grid = (GridView)findViewById(R.id.grid);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_item,R.id.textView);
        adapter.add("Anas Mahjoud");
        adapter.add("Ibraheem Balousha");
        //lst.setAdapter(adapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String item = (String)parent.getItemAtPosition(position);
                MyItem item = (MyItem)parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, item.getTitle() + " " + item.getSubTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        List<MyItem> items = new ArrayList<>();
        items.add(new MyItem("aNAS","Nokia Owner",R.mipmap.ic_launcher));
        items.add(new MyItem("Samah","Google Owner",R.mipmap.ic_launcher));

        items.add(new MyItem("Hasan","Secretary of Anas",R.mipmap.ic_launcher));

        MyCustomAdapter myAdapter = new MyCustomAdapter(this,R.layout.my_list_item,items);

        lst.setAdapter(myAdapter);
    }


}
