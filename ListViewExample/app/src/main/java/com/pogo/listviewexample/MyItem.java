package com.pogo.listviewexample;

/**
 * Created by iSaleem on 7/30/16.
 */
public class MyItem {
    private String title;
    private String subTitle;
    private int image;

    public MyItem(String title, String subTitle, int image) {
        this.title = title;
        this.subTitle = subTitle;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public int getImage() {
        return image;
    }
}
