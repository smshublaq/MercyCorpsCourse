package com.app.networkingvolley3;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by iSaleem on 8/17/17.
 */

public class UIApplication extends Application {

    private static UIApplication anInstance = null;

    private RequestQueue requestQueue;
    private  ImageLoader imageLoader;

    @Override
    public void onCreate() {
        super.onCreate();
        anInstance = this;
    }

    public synchronized static UIApplication getInstance(){
        return anInstance;
    }

    private RequestQueue getRequestQueue(){
        if(requestQueue == null)
            requestQueue = Volley.newRequestQueue(this);
        return requestQueue;
    }

    public void addRequestQueue(Request request){
        getRequestQueue().add(request);
    }

    public void addRequestQueue(Request request,String tag){
        request.setTag(tag);
        getRequestQueue().add(request);
    }

    public void cancelRequest(String tag){
        getRequestQueue().cancelAll(tag);
    }

    public ImageLoader getImageLoader(){
        if(imageLoader == null)
            return imageLoader = new ImageLoader(getRequestQueue(),new MyLruCache());
        return imageLoader;
    }


}
