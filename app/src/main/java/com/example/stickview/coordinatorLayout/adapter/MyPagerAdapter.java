package com.example.stickview.coordinatorLayout.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stickview.R;

/**
 * Created by Administrator on 2017/6/7 0007.
 */

public class MyPagerAdapter extends PagerAdapter {
    private Context mContext;

    public MyPagerAdapter(Context scrollingActivity) {
        mContext = scrollingActivity;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.imageview, container, false);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
