package com.example.stickview.commonview;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/**
 * 用于解决SwipeRefreshLayout中嵌套使用viewpager出现viewpager滑动不灵敏问题
 */

public class VpSwipeRefreshLayout extends SwipeRefreshLayout {

    private float mStartY;
    private float mStartX;
    private boolean mIsVpDragger;
    private final int mTouchSlop;


    public VpSwipeRefreshLayout(Context context) {
        super(context);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public VpSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                mStartY = ev.getY();
                mStartX = ev.getX();
                mIsVpDragger = false;
                break;
            case MotionEvent.ACTION_MOVE:
                if (mIsVpDragger) {
                    return false;
                }
                float endY = ev.getY();
                float endX = ev.getX();
                float distanceX = Math.abs(endX - mStartX);
                float distanceY = Math.abs(endY - mStartY);
                if (distanceX > mTouchSlop && distanceX > distanceY) {
                    mIsVpDragger = true;
                    return false;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mIsVpDragger = false;
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
}