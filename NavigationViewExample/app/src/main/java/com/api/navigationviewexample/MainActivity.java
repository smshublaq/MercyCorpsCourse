package com.api.navigationviewexample;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });


        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        ActionBarDrawerToggle actionDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        actionDrawerToggle.syncState(); // show menu
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        Button btn = header.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),SecondActivity.class);
                startActivity(intent);
            }
        });
        //toolbar.setContentInsetsAbsolute(0,0);
        //TextView tv = (TextView)toolbar.findViewById(R.id.tv);
        //tv.setText(R.string.app_name);
        /*
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Ahmed");
        getSupportActionBar().setHomeButtonEnabled(true);
        */




    }

    public void flipMenu(int gravity){
        if(drawerLayout.isDrawerOpen(gravity)){
            drawerLayout.closeDrawer(gravity);
        }
        else {
            drawerLayout.openDrawer(gravity);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.settings:
                Toast.makeText(this, "ASS", Toast.LENGTH_SHORT).show();
                flipMenu(GravityCompat.START);
                break;
            case R.id.categories:
                flipMenu(GravityCompat.START);

                break;
            case R.id.home:
                flipMenu(GravityCompat.START);

                break;
        }
        return false;
    }


}
