package com.api.dynamicfragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyFragment myFragment2 = (MyFragment)getSupportFragmentManager().findFragmentById(R.id.container);

        /*
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment myFragment = new MyFragment();
        transaction.add(R.id.container,myFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        */
        if(savedInstanceState == null) {
            Fragment myFragment = new MyListFragment();

            FragmentsUtil.addFragment(this, R.id.container,
                    myFragment, false);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        }
    }
}
