package com.api.menusexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ContextMenuActivity extends AppCompatActivity {

    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);
        ListView lst = (ListView)findViewById(R.id.lst);
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1);
        adapter.add("Ahmed");
        adapter.add("mohammed");

        lst.setAdapter(adapter);

        registerForContextMenu(lst);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu,menu);
        
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();


        int id = item.getItemId();
        switch (id){
            case R.id.delete:
                Toast.makeText(this, "Yousef Hamada", Toast.LENGTH_SHORT).show();
                adapter.remove(adapter.getItem(info.position));
                adapter.notifyDataSetChanged();
                break;
        }
        return super.onContextItemSelected(item);
    }
}
