package com.zhou.mypowerbee.module.main.home;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.zhou.mypowerbee.R;
import com.zhou.mypowerbee.common.BaseFragment;
import com.zhou.mypowerbee.model.entity.Device;
import com.zhou.mypowerbee.util.ScreenUtils;
import com.zhou.mypowerbee.util.ToastUtil;
import com.zhou.mypowerbee.widget.MyIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhou on 17-3-10.
 */

public class HomeFragment extends BaseFragment implements HomeContract.View {
    @BindView(R.id.camera)
    FrameLayout cameraFragment;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.indicator)
    MyIndicator myIndicator;
    private HomeContract.Persenter persenter;

    @Override
    public int bindLayout() {
        return R.layout.fragment_main_home;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void doBusiness(Context mContext) {
        new HomePersenter(this);
        getNumber();
        persenter.start();
    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void setPersenter(HomeContract.Persenter persenter) {
        this.persenter = persenter;
    }

    public void getNumber() {
        int cameraHeight = ScreenUtils.getScreenWidth() * 9 / 16;
        cameraFragment.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, cameraHeight));
    }

    @Override
    public void setData(List<List<Device>> lists) {
        List<View> views = new ArrayList<>();

        for (List<Device> devices : lists) {
            GridView gridview = new GridView(getActivity());
            gridview.setPadding(10, 10, 10, 10);
            gridview.setSelector(new ColorDrawable(Color.TRANSPARENT));
            gridview.setNumColumns(4);
            gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Device device = ((GridViewAdapter.ViewHolder) view.getTag()).device;
                    ToastUtil.getInstance().toastShowS(device.getTitle());
                }
            });
            GridViewAdapter adapter = new GridViewAdapter(getActivity());
            adapter.setData(devices);
            gridview.setAdapter(adapter);
            views.add(gridview);
        }
        MyPagerAdapter pagerAdapter = new MyPagerAdapter();
        pagerAdapter.setData(views);
        viewpager.setAdapter(pagerAdapter);
        myIndicator.setViewPager(viewpager, views.size());
    }
}
