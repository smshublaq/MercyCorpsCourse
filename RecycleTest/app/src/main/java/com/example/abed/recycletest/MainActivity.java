package com.example.abed.recycletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.abed.recycletest.Adapters.VerticalAdapter;
import com.example.abed.recycletest.Items.ImagePost;
import com.example.abed.recycletest.Items.Item;
import com.example.abed.recycletest.Items.RecyclerItem;
import com.example.abed.recycletest.Items.TextPost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.vertical_recycler);

        List<Item> list = new ArrayList<>(Arrays.asList(
                new TextPost(R.drawable.chees_cake, "Abdelrahman", "03:27:32 AM", "Hello every One"),
                new ImagePost(R.drawable.meal, R.drawable.chees_cake, "Abdelrahman", "03:27:32 AM"),
                new TextPost(R.drawable.coffe, "Abdelrahman", "03:27:32 AM", "Hello every One"),
                new ImagePost(R.drawable.baby, R.drawable.baby, "Faraj", "03:27:32 AM"),
                new ImagePost(R.drawable.bus, R.drawable.bus, "Sami", "03:27:32 AM"),
                new ImagePost(R.drawable.chees_cake, R.drawable.chees_cake, "Rami", "03:27:32 AM"),
                new TextPost(R.drawable.chees_cake, "Abdelrahman", "03:27:32 AM", "Hello every One"),

                new RecyclerItem<>(new ArrayList<>(Arrays.asList(
                        new ImagePost(R.drawable.chees_cake, R.drawable.rail_road, "Rami", "03:27:32 AM"),
                        new ImagePost(R.drawable.chees_cake, R.drawable.flower, "Khalid", "03:27:32 AM"),
                        new ImagePost(R.drawable.chees_cake, R.drawable.decoration, "Ahmed", "03:27:32 AM"),
                        new ImagePost(R.drawable.chees_cake, R.drawable.cake, "Abdelrahman", "03:27:32 AM"), new ImagePost(R.drawable.chees_cake, R.drawable.chees_cake, "Rami", "03:27:32 AM"),
                        new ImagePost(R.drawable.chees_cake, R.drawable.moon, "Khalid", "03:27:32 AM"),
                        new ImagePost(R.drawable.chees_cake, R.drawable.sweet, "Ahmed", "03:27:32 AM"),
                        new ImagePost(R.drawable.chees_cake, R.drawable.dragon, "Abdelrahman", "03:27:32 AM")
                ))),

                new ImagePost(R.drawable.chees_cake, R.drawable.moon, "Khalid", "03:27:32 AM"),
                new TextPost(R.drawable.chees_cake, "Abdelrahman", "03:27:32 AM", "Hello every One"),
                new ImagePost(R.drawable.chees_cake, R.drawable.chees_cake, "Ahmed", "03:27:32 AM"),
                new TextPost(R.drawable.chees_cake, "Abdelrahman", "03:27:32 AM", "Hello every One"),

                new RecyclerItem<>(new ArrayList<>(Arrays.asList(
                        new ImagePost(R.drawable.chees_cake, R.drawable.rail_road, "Rami", "03:27:32 AM"),
                        new ImagePost(R.drawable.chees_cake, R.drawable.flower, "Khalid", "03:27:32 AM"),
                        new ImagePost(R.drawable.chees_cake, R.drawable.decoration, "Ahmed", "03:27:32 AM"),
                        new ImagePost(R.drawable.chees_cake, R.drawable.cake, "Abdelrahman", "03:27:32 AM"), new ImagePost(R.drawable.chees_cake, R.drawable.chees_cake, "Rami", "03:27:32 AM"),
                        new ImagePost(R.drawable.chees_cake, R.drawable.moon, "Khalid", "03:27:32 AM"),
                        new ImagePost(R.drawable.chees_cake, R.drawable.sweet, "Ahmed", "03:27:32 AM"),
                        new ImagePost(R.drawable.chees_cake, R.drawable.dragon, "Abdelrahman", "03:27:32 AM")
                ))),

                new ImagePost(R.drawable.chees_cake, R.drawable.chees_cake, "Abdelrahman", "03:27:32 AM"),
                new TextPost(R.drawable.chees_cake, "Abdelrahman", "03:27:32 AM", "Hello every One"),
                new ImagePost(R.drawable.chees_cake, R.drawable.cake, "Mohammed ", "03:27:32 AM"),
                new ImagePost(R.drawable.chees_cake, R.drawable.coffe, "Abdelrahman", "03:27:32 AM"),

                new RecyclerItem<>(new ArrayList<>(Arrays.asList(
                        new ImagePost(R.drawable.chees_cake, R.drawable.rail_road, "Rami", "03:27:32 AM"),
                        new ImagePost(R.drawable.chees_cake, R.drawable.flower, "Khalid", "03:27:32 AM"),
                        new ImagePost(R.drawable.chees_cake, R.drawable.decoration, "Ahmed", "03:27:32 AM"),
                        new ImagePost(R.drawable.chees_cake, R.drawable.cake, "Abdelrahman", "03:27:32 AM"), new ImagePost(R.drawable.chees_cake, R.drawable.chees_cake, "Rami", "03:27:32 AM"),
                        new ImagePost(R.drawable.chees_cake, R.drawable.moon, "Khalid", "03:27:32 AM"),
                        new ImagePost(R.drawable.chees_cake, R.drawable.sweet, "Ahmed", "03:27:32 AM"),
                        new ImagePost(R.drawable.chees_cake, R.drawable.dragon, "Abdelrahman", "03:27:32 AM")
                ))),

                new TextPost(R.drawable.chees_cake, "Abdelrahman", "03:27:32 AM", "Hello every One"),
                new ImagePost(R.drawable.chees_cake, R.drawable.kunafa, "Abdelrahman", "03:27:32 AM"),
                new TextPost(R.drawable.chees_cake, "Abdelrahman", "03:27:32 AM", "Hello every One"),
                new ImagePost(R.drawable.chees_cake, R.drawable.sweet, "Jamal", "03:27:32 AM"),
                new TextPost(R.drawable.chees_cake, "Abdelrahman", "03:27:32 AM", "Hello every One"),
                new ImagePost(R.drawable.chees_cake, R.drawable.cake, "Abdelrahman", "03:27:32 AM"),
                new ImagePost(R.drawable.chees_cake, R.drawable.coffe, "Jamal", "03:27:32 AM")
        ));

        VerticalAdapter verticalAdapter = new VerticalAdapter(list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setAdapter(verticalAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
