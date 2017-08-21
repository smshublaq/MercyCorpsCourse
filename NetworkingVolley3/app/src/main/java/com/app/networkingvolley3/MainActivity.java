package com.app.networkingvolley3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class MainActivity extends AppCompatActivity implements Observer{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NetworkImageView networkImageView = (NetworkImageView)findViewById(R.id.img);
        String url = "https://jsonplaceholder.typicode.com/posts";
        MyRequests requests = new MyRequests();
        requests.addObserver(this);
        requests.getPosts(url);
        /*
        MyRequests requests = new MyRequests();
        requests.getPosts(url,new ICompletionListener() {
            @Override
            public void onCompletionListener(JSONObject jsonObject) {
                Log.d("JSON",jsonObject.toString());
            }
        });
        */

    }


    @Override
    public void update(Observable observable, Object o) {
        /*
        JSONObject jsonObject = (JSONObject)o;
        Log.d("Observer",jsonObject.toString());
        */


        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        //gson.toJson();
        //Post post = gson.fromJson(o.toString(),Post.class);
        //Type typeOfObjectsList = new TypeToken<List<Post>>() {}.getType();

        List<Post> postList = gson.fromJson(o.toString(),new TypeToken<List<Post>>(){}.getType());
        Log.d("POST",postList.get(0).getId()+"");
    }
}
