package com.zhou.mypowerbee.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zhou.mypowerbee.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhou on 17-3-12.
 */

public class MyIndicator extends LinearLayout {
    private int count;
    private List<ImageView> imageViews;
    private ImageView curImageView;

    public MyIndicator(Context context) {
        super(context);
        init();
    }

    private void init() {
        imageViews = new ArrayList<>();
    }

    public MyIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }



    public MyIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setViewPager(ViewPager viewPager, int count) {
        this.count = count;
        this.removeAllViews();
        imageViews.clear();
        if (this.count > 1) {
            for (int i = 0; i < count; i++) {
                ImageView imageView = new ImageView(getContext());
                imageView.setImageResource(R.drawable.pageview_point_off);
                imageView.setPadding(10, 10, 10, 10);
                this.addView(imageView);
                imageViews.add(imageView);
            }
            setCurIndex(0);
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    setCurIndex(position);
                }

                @Override
                public void onPageSelected(int position) {

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
    }

    public void setCurIndex(int curIndex) {
        if (curImageView != null) curImageView.setImageResource(R.drawable.pageview_point_off);
        if (imageViews.size() != 0) {
            curImageView = imageViews.get(curIndex);
            curImageView.setImageResource(R.drawable.pageview_point_on);
        }
    }
}
