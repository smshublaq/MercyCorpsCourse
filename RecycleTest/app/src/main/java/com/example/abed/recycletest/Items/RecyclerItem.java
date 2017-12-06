package com.example.abed.recycletest.Items;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.abed.recycletest.Adapters.HorizontalAdapter;
import com.example.abed.recycletest.Adapters.VerticalAdapter;
import com.example.abed.recycletest.R;

import java.util.List;

/**
 * Created by abed on 7/24/17.
 */

public class RecyclerItem<T> implements Item {
    private List<T> list;

    public RecyclerItem(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public void fill(RecyclerView.ViewHolder viewHolder) {
        VerticalAdapter.RecyclerViewHolder vh = (VerticalAdapter.RecyclerViewHolder) viewHolder;
        HorizontalAdapter adapter = new HorizontalAdapter(this.getList());

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(viewHolder.itemView.getContext()
                        , LinearLayoutManager.HORIZONTAL, false);

        vh.recyclerView.setAdapter(adapter);
        vh.recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public int getType() {
        return R.layout.recycler_recycler_layout;
    }

}
