package com.zhou.mypowerbee.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.zhou.mypowerbee.R;
import com.zhou.mypowerbee.module.main.MyFragmentAdapter;
import com.zhou.mypowerbee.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhou on 17-3-9.
 */

public class MyTabLayout extends TabLayout {
    private MyTabLayoutListener listener;

    public MyTabLayout(Context context) {
        super(context);
        initView();

    }

    public MyTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();

    }

    public MyTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();

    }

    private void initView() {

    }

    @Override
    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        super.setupWithViewPager(viewPager);
        int count = getTabCount();
        for (int i = 0; i < count; i++) {
            TabLayout.Tab tab = getTabAt(i);
            Drawable drawable = null;
            switch (i) {
                case 0:
                    drawable = ContextCompat.getDrawable(getContext(), R.drawable.tab0);
                    break;
                case 1:
                    drawable = ContextCompat.getDrawable(getContext(), R.drawable.tab1);
                    break;
                case 2:
                    drawable = ContextCompat.getDrawable(getContext(), R.drawable.tab2);
                    break;
                case 3:
                    drawable = ContextCompat.getDrawable(getContext(), R.drawable.tab3);
                    break;
            }
            tab.setIcon(drawable);
        }

        addOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(Tab tab) {
                if (listener != null)
                    listener.setTitle(tab.getText().toString());
            }

            @Override
            public void onTabUnselected(Tab tab) {

            }

            @Override
            public void onTabReselected(Tab tab) {

            }
        });
    }

    public void setMyTabLayoutListener(MyTabLayoutListener listener) {
        this.listener = listener;
    }

    public interface MyTabLayoutListener {
        void setTitle(String title);
    }
}
