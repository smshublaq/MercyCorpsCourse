package com.example.abed.recycletest.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abed.recycletest.Items.ImagePost;
import com.example.abed.recycletest.R;

import java.util.List;

/**
 * Created by abed on 7/22/17.
 */

public class HorizontalAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<T> posts;

    public HorizontalAdapter(List<T> list) {
        this.posts = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_recycler_layout, parent, false);
        VerticalAdapter.ImagePostViewHolder pvh = new VerticalAdapter.ImagePostViewHolder(view);
        return pvh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ImagePost post = (ImagePost) posts.get(position);
        post.fill(holder);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


}
