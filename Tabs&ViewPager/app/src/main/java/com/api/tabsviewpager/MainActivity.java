package com.api.tabsviewpager;

import android.provider.ContactsContract;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager pager = (ViewPager)findViewById(R.id.viewPager);
        //pager.setCurrentItem();
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));


        /*
        final List<String> list = new ArrayList();
        list.add("http://pngimg.com/uploads/pokemon/pokemon_PNG88.png");
        list.add("http://www.hobbyconsolas.com/sites/hobbyconsolas.com/public/styles/main_element/public/media/image/2016/11/pokemon-go-pokemon-primera-generacion-evoluciones-segunda.jpg?itok=Z2haVjTJ");
        list.add("https://vignette2.wikia.nocookie.net/pokemon/images/b/b1/025Pikachu_XY_anime_3.png/revision/latest?cb=20140902050035");
        SlidingPagerAdapter<String> adapter = new SlidingPagerAdapter<String>(this,list) {
            @Override
            public View initiateItem(LayoutInflater inflater, ViewGroup view, int position) {
                View myView = inflater.inflate(R.layout.pokemon,view,false);
                ImageView img = myView.findViewById(R.id.img);
                final ContentLoadingProgressBar loadingProgressBar = myView.findViewById(R.id.progress);
                loadingProgressBar.show();
                Log.d("initiateItem","initiateItem");

                Picasso.with(MainActivity.this).load(list.get(position)).into(img, new Callback() {
                    @Override
                    public void onSuccess() {
                        loadingProgressBar.hide();
                    }

                    @Override
                    public void onError() {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });

                view.addView(myView, 0);

                return myView;
            }
        };

        pager.setAdapter(adapter);

        */
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        TabLayout tabs = (TabLayout)findViewById(R.id.tabs);
        tabs.setupWithViewPager(pager);


        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //tabs.getTabAt();

        // tabs.addTab(new TabLayout(this).newTab().setIcon(R.mipmap.ic_launcher).setText("aaa"));

    }


}
