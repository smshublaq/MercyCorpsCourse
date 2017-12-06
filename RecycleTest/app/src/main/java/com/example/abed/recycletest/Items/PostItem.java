package com.example.abed.recycletest.Items;

/**
 * Created by abed on 7/22/17.
 */

public abstract class PostItem implements Item {
    protected int profileImage;
    protected String userName;
    protected String date;

    public PostItem() {
    }

    public PostItem(int profileImage, String userName, String date) {
        this.profileImage = profileImage;
        this.userName = userName;
        this.date = date;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
