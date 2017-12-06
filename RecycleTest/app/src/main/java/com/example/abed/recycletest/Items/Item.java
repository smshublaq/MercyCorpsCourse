package com.example.abed.recycletest.Items;

import android.support.v7.widget.RecyclerView;

/**
 * Created by abed on 7/22/17.
 */

public interface Item {
    void fill(RecyclerView.ViewHolder viewHolder);

    int getType();

}
