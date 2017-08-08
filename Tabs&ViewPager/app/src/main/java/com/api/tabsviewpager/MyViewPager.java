package com.api.tabsviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;

/**
 * Created by iSaleem on 8/8/17.
 */

public class MyViewPager extends ViewPager {
    public MyViewPager(Context context) {
        super(context);
    }

    @Override
    protected void onPageScrolled(int position, float offset, int offsetPixels) {
        super.onPageScrolled(position, offset, offsetPixels);
    }

    @Override
    public boolean beginFakeDrag() {
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
