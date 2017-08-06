package com.api.dynamicfragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by iSaleem on 8/3/17.
 */

public class FragmentsUtil {

    public static void addFragment(FragmentActivity activity, int layout, Fragment fragment){
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(layout,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public static void addFragment(FragmentActivity activity, int layout, Fragment fragment ,boolean addToBackStack){
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(layout,fragment);
        if(addToBackStack){
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

    public static void replaceFragment(FragmentActivity activity, int layout, Fragment fragment){
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(layout,fragment);
        transaction.commit();

    }

    public static void replaceFragment(FragmentActivity activity, int layout, Fragment fragment ,boolean addToBackStack){
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(layout,fragment);
        if(addToBackStack){
            transaction.addToBackStack(null);
        }
        transaction.commit();

    }
    public static void removeFragment(FragmentActivity activity,Fragment fragment){
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.remove(fragment);
        transaction.commit();

    }

}
