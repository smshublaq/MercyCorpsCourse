package com.pogo.listviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by iSaleem on 7/30/16.
 */
public class MyCustomAdapter extends ArrayAdapter{

    List<MyItem> items;
    int layout;
    LayoutInflater inflater;

    public MyCustomAdapter(Context context, int resource,List<MyItem> items) {
        super(context, resource);
        this.items = items;
        this.layout = resource;
        inflater = LayoutInflater.from(context);
        //inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView =  inflater.inflate(layout,parent,false);

        ImageView img = (ImageView)convertView.findViewById(R.id.img);
        TextView tvTitle = (TextView)convertView.findViewById(R.id.tvTitle);
        TextView tvSubTitle = (TextView)convertView.findViewById(R.id.tvSubTitle);

        img.setImageResource(items.get(position).getImage());
        tvTitle.setText(items.get(position).getTitle());
        tvSubTitle.setText(items.get(position).getSubTitle());

        if(position %2 == 0){
           // convertView.setBackgroundColor();
        }
        else{
            // convertView.setBackgroundColor();
        }


        return convertView;
    }
}
