package com.example.abed.recycletest.Items;

import android.support.v7.widget.RecyclerView;

import com.example.abed.recycletest.Adapters.VerticalAdapter;
import com.example.abed.recycletest.Items.PostItem;
import com.example.abed.recycletest.R;

/**
 * Created by abed on 7/22/17.
 */

public class ImagePost extends PostItem {
    private int contentImage;

    public ImagePost(int profileImage, int contentImage, String userName, String date) {
        super(profileImage, userName, date);
        this.contentImage = contentImage;
    }

    public int getContentImage() {
        return contentImage;
    }

    public void setContentImage(int contentImage) {
        this.contentImage = contentImage;
    }

    @Override
    public void fill(RecyclerView.ViewHolder viewHolder) {
        VerticalAdapter.ImagePostViewHolder vh = (VerticalAdapter.ImagePostViewHolder) viewHolder;
        vh.tvName.setText(this.userName);
        vh.tvDate.setText(this.date);
        vh.imgProfile.setImageResource(this.profileImage);
        vh.imgContent.setImageResource(this.contentImage);
    }

    @Override
    public int getType() {
        return R.layout.image_recycler_layout;
    }
}