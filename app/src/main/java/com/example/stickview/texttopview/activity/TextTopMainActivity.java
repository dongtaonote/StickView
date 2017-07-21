package com.example.stickview.texttopview.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.TextView;

import com.example.stickview.R;
import com.example.stickview.coordinatorLayout.adapter.MyPagerAdapter;
import com.example.stickview.coordinatorLayout.fragment.TestFragment;
import com.example.stickview.texttopview.adapter.ListMyAdapter;

import java.util.ArrayList;

public class TextTopMainActivity extends FragmentActivity {

    private ViewPager bannerViewPager;
    private ViewPager contentViewPager;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView tab_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texttop_main);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiprefresh);
        bannerViewPager = (ViewPager) findViewById(R.id.viewpager);
        contentViewPager = (ViewPager) findViewById(R.id.viewpager_home_page_products);
        tab_title = (TextView) findViewById(R.id.tab_title);

        PagerAdapter adapter = new MyPagerAdapter(this);
        bannerViewPager.setAdapter(adapter);

        ArrayList<TestFragment> mSubFragments = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mSubFragments.add(TestFragment.newInstance());
        }

        PagerAdapter ad = new ListMyAdapter(getSupportFragmentManager(), this, mSubFragments);
        contentViewPager.setAdapter(ad);


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });
    }


}
