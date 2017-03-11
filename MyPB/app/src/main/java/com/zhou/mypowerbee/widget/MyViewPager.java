package com.zhou.mypowerbee.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by zhou on 16-6-30.
 * 禁止滑动viewpager
 */
public class MyViewPager extends ViewPager {
    private boolean isNoScroll = false;

    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void isNoScroll(boolean isNoScroll) {
        this.isNoScroll = isNoScroll;
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (isNoScroll)
            return super.onTouchEvent(ev);
        else
            return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (isNoScroll)
            return super.onInterceptTouchEvent(ev);
        else
            return false;
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        // TODO Auto-generated method stub
        super.setCurrentItem(item, smoothScroll);
    }

    //取消滑动效果
    @Override
    public void setCurrentItem(int item) {
        // TODO Auto-generated method stub
        super.setCurrentItem(item, isNoScroll);
    }

    @Override
    public void setOffscreenPageLimit(int limit) {
        super.setOffscreenPageLimit(getChildCount());
    }
}
