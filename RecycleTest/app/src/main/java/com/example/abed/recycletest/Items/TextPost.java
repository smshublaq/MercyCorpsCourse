package com.example.abed.recycletest.Items;

import android.support.v7.widget.RecyclerView;

import com.example.abed.recycletest.Adapters.VerticalAdapter;
import com.example.abed.recycletest.R;

/**
 * Created by abed on 7/22/17.
 */

public class TextPost extends PostItem {
    private String contentText;

    public TextPost() {
    }

    public TextPost(int profileImage, String userName, String date, String contentText) {
        super(profileImage, userName, date);
        this.contentText = contentText;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }

    @Override
    public void fill(RecyclerView.ViewHolder viewHolder) {
        VerticalAdapter.TextPostViewHolder vh = (VerticalAdapter.TextPostViewHolder) viewHolder;
        vh.tvName.setText(this.userName);
        vh.tvDate.setText(this.date);
        vh.imgProfile.setImageResource(this.profileImage);
        vh.tvContent.setText(this.contentText);

    }

    @Override
    public int getType() {
        return R.layout.text_recycler_layout;
    }
}
