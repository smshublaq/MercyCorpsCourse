package com.app.mediaplayerwithservices;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by iSaleem on 8/27/17.
 */

public class MyButton extends AppCompatImageButton {
    public MyButton(Context context) {
        super(context);
    }



    boolean isPlaying = false;

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {



        if (isPlaying) {
            setImageResource(android.R.drawable.ic_media_pause);
        }else{
            setImageResource(android.R.drawable.ic_media_play);

        }
        isPlaying = !isPlaying;

        super.setOnClickListener(l);

    }
}
