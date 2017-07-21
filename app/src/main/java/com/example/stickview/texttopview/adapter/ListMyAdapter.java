package com.example.stickview.texttopview.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.stickview.coordinatorLayout.fragment.TestFragment;

import java.util.ArrayList;


public class ListMyAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private ArrayList<TestFragment> mSubFragments;

    public ListMyAdapter(FragmentManager fm, Context con, ArrayList<TestFragment> mSubFragme) {
        super(fm);
        mContext = con;
        mSubFragments = mSubFragme;
    }

    @Override
    public Fragment getItem(int position) {
        return mSubFragments.get(position);
    }

    @Override
    public int getCount() {
        return mSubFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return position + "位";
    }
}
