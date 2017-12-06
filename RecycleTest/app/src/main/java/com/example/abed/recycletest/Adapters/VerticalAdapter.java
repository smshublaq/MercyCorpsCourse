package com.example.abed.recycletest.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abed.recycletest.Items.Item;
import com.example.abed.recycletest.R;

import java.util.List;

/**
 * Created by abed on 7/23/17.
 */

public class VerticalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Item> list;

    private static final int IMAGE_POST = 0, TEXT_POST = 1, RECYCLER = 2;

    public VerticalAdapter(List<Item> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);

        switch (viewType) {
            case R.layout.image_recycler_layout:
                return new ImagePostViewHolder(view);

            case R.layout.text_recycler_layout:
                return new TextPostViewHolder(view);

            case R.layout.recycler_recycler_layout:
                return new RecyclerViewHolder(view);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Item item = list.get(position);
        item.fill(holder);
    }

    @Override
    public int getItemViewType(int position) {
        Item item = list.get(position);
        return item.getType();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class TextPostViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvDate;
        public ImageView imgProfile;
        public TextView tvContent;

        public TextPostViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.txt_name);
            tvDate = itemView.findViewById(R.id.txt_date);
            imgProfile = itemView.findViewById(R.id.img_profile);
            tvContent = itemView.findViewById(R.id.txt_content);
        }
    }

    public static class ImagePostViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvDate;
        public ImageView imgProfile;
        public ImageView imgContent;

        public ImagePostViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.txt_name);
            tvDate = itemView.findViewById(R.id.txt_date);
            imgProfile = itemView.findViewById(R.id.img_profile);
            imgContent = itemView.findViewById(R.id.img_content);

        }
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public RecyclerView recyclerView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.horizontal_recycler);
        }
    }
}