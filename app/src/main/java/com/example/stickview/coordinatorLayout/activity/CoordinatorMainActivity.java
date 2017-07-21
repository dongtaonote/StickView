package com.example.stickview.coordinatorLayout.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;

import com.example.stickview.R;
import com.example.stickview.coordinatorLayout.adapter.ListMyAdapter;
import com.example.stickview.coordinatorLayout.adapter.MyPagerAdapter;
import com.example.stickview.coordinatorLayout.fragment.TestFragment;

import java.util.ArrayList;

public class CoordinatorMainActivity extends AppCompatActivity {
    private ViewPager bannerViewpager;
    private ViewPager contentViewpager;
    private TabLayout tablayout;
    private AppBarLayout appBarLayout;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swip);
        bannerViewpager = (ViewPager) findViewById(R.id.viewpager);
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        contentViewpager = (ViewPager) findViewById(R.id.contentviewpager);

        PagerAdapter adapter1 = new MyPagerAdapter(CoordinatorMainActivity.this);
        bannerViewpager.setAdapter(adapter1);

        appBarLayout = (AppBarLayout) findViewById(R.id.appbar_layout);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    mSwipeRefreshLayout.setEnabled(true);
                } else {
                    mSwipeRefreshLayout.setEnabled(false);
                }
            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mSwipeRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 1500);
            }
        });

        ArrayList<TestFragment> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(TestFragment.newInstance());
        }

        PagerAdapter adapter = new ListMyAdapter(getSupportFragmentManager(), list);
        contentViewpager.setAdapter(adapter);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            contentViewpager.setNestedScrollingEnabled(false);
        }
        tablayout.setupWithViewPager(contentViewpager);

    }
}
