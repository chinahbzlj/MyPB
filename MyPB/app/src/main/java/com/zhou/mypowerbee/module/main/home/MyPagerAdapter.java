package com.zhou.mypowerbee.module.main.home;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhou on 17-3-14.
 */

public class MyPagerAdapter extends PagerAdapter {
    private List<View> views = new ArrayList<>();

    public void setData(List<View> views) {
        this.views.clear();
        this.views.addAll(views);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return views.size();
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ViewGroup parent = (ViewGroup) views.get(position).getParent();
        if (parent != null) {
            parent.removeAllViews();
        }
        container.addView(views.get(position), 0);
        return views.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
