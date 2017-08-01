package com.api.myfirebaseexample;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iSaleem on 8/1/17.
 */

public class Post {

    public String uid;
    public String author;
    public String title;
    public String body;

    public Post(){

    }

    public Post(String uid, String author, String title, String body) {
        this.uid = uid;
        this.author = author;
        this.title = title;
        this.body = body;
    }

    public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("uid",uid);
        map.put("author",author);
        map.put("title",title);
        map.put("body",body);

        return map;

    }
}
