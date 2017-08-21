package com.app.networkingvolley3;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by iSaleem on 8/17/17.
 */

public class MyRequests extends Observable implements Response.Listener<JSONObject>{

    /*
    public void getPosts(String url , final ICompletionListener completionListener){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("JSON",response.toString());
                completionListener.onCompletionListener(response);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        UIApplication.getInstance().addRequestQueue(jsonObjectRequest);
    }
    */

    public void getPosts(String url){
        /*
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null, this, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        UIApplication.getInstance().addRequestQueue(jsonObjectRequest);
        */
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                setChanged();
                notifyObservers(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        UIApplication.getInstance().addRequestQueue(jsonArrayRequest);


    }

    @Override
    public void onResponse(JSONObject response) {
        setChanged();
        notifyObservers(response);
    }
}
