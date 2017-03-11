package com.zhou.mypowerbee.widget;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhou.mypowerbee.R;

/**
 * Created by zhou on 17-3-10.
 */

public class MyTab extends LinearLayout {
    private TextView tabTitle;
    private ImageView tabImage;
    private RelativeLayout relativeLayoutImg;

    public MyTab(Context context) {
        super(context);
        initView();
    }


    public MyTab(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MyTab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        tabTitle = new TextView(getContext());
        tabImage = new ImageView(getContext());
        tabImage.setImageResource(R.drawable.icon_home_page_normal);
        tabImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
        tabTitle.setText("首页");
        tabTitle.setTextColor(ContextCompat.getColor(getContext(), R.color.topbar_bg));
        tabTitle.setTextSize(12);
        tabTitle.setGravity(Gravity.CENTER);
//        tabTitle.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.topbar_bg));
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        relativeLayoutImg = new RelativeLayout(getContext());
        relativeLayoutImg.addView(tabImage, params);
        relativeLayoutImg.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.topbar_bg));
        LayoutParams imgLayoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        View v = LayoutInflater.from(getContext()).inflate(R.layout.layout_my_tab, null);
        addView(relativeLayoutImg);
        addView(v);
        LayoutParams titleLayoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        addView(tabTitle, titleLayoutParams);
//        ViewGroup.LayoutParams layoutParams = linearLayoutImg.getLayoutParams();
//        layoutParams.height = LayoutParams.MATCH_PARENT;
//        layoutParams.width = LayoutParams.MATCH_PARENT;
//        linearLayoutImg.setLayoutParams(layoutParams);
    }

    private void setView(String title, int img) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View childView = getChildAt(i);
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        relativeLayoutImg.layout(0, 0, getWidth(), (int) (getHeight() * 0.6));
        tabTitle.layout(0, (int) (getHeight() * 0.6), getWidth(), getHeight());
    }
}
