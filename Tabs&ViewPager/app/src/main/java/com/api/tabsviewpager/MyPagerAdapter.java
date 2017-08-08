package com.api.tabsviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by iSaleem on 8/8/17.
 */

//FragmentStatePagerAdapter
public class MyPagerAdapter extends FragmentPagerAdapter {

    final int FRAGMENT_ONE = 0;
    final int FRAGMENT_TWO = 1;
    final int COUNT = 2;
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case FRAGMENT_ONE:
                fragment = new FirstFragment();
                break;

            case FRAGMENT_TWO:
                fragment = new SecondFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case FRAGMENT_ONE:
                title = "Fragment One";
                break;
            case FRAGMENT_TWO:
                title = "Fragment Two";
                break;

        }
        return title;
    }
}
