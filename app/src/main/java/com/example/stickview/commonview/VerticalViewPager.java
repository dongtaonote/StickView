package com.example.stickview.commonview;

import android.content.Context;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;


/**
 * 用于解决RecycleView在viewPager中展示不全的问题
 */
public class VerticalViewPager extends ViewPager implements NestedScrollingChild {
    public VerticalViewPager(Context context) {
        super(context);
    }

    public VerticalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            int h = child.getMeasuredHeight();
            if (h > height)
                height = h;
        }
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
