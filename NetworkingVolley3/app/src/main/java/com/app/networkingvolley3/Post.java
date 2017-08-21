package com.app.networkingvolley3;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by iSaleem on 8/20/17.
 */

public class Post {

    @Expose
    @SerializedName("id")
    private int postId;

    private String body;
    private String title;
    private int userId;

    public int getId() {
        return postId;
    }

    public void setId(int id) {
        this.postId = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
