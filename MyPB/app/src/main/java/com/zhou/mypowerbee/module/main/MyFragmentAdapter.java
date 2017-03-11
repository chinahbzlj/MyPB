package com.zhou.mypowerbee.module.main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zhou.mypowerbee.R;
import com.zhou.mypowerbee.common.BaseFragment;

import java.util.List;
import java.util.Map;

/**
 * Created by zhou on 17-3-10.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {
    private List<Map<String, Object>> fragmentList;
    private Context context;

    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return (CharSequence) fragmentList.get(position).get(context.getResources().getString(R.string.title));
    }

    @Override
    public Fragment getItem(int position) {
        return (BaseFragment) fragmentList.get(position).get(context.getResources().getString(R.string.fragmennt));
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void setData(List<Map<String, Object>> fragmentList) {
        this.fragmentList = fragmentList;

    }

    public void setContext(Context context) {
        this.context = context;
    }
}