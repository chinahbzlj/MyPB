package com.zhou.mypowerbee.module.main;

import android.content.Context;

import com.zhou.mypowerbee.R;
import com.zhou.mypowerbee.module.main.home.HomeFragment;
import com.zhou.mypowerbee.module.main.scene.SceneFragment;
import com.zhou.mypowerbee.module.main.sensor.SensorFragment;
import com.zhou.mypowerbee.module.main.timer.TimerFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhou on 17-3-10.
 */

public class MainPersenter implements MainContract.Persenter {
    private MainContract.View view;
    private Context mContext;

    public MainPersenter(MainContract.View view) {
        this.view = view;
        this.view.setPersenter(this);
        mContext = (Context) this.view;
    }

    @Override
    public void start() {
        List<Map<String, Object>> fragments = new ArrayList<>();
        Map<String, Object> homeFragment = new HashMap<>();
        homeFragment.put(mContext.getResources().getString(R.string.title), mContext.getResources().getString(R.string.home));
        homeFragment.put(mContext.getResources().getString(R.string.fragmennt), new HomeFragment());
        fragments.add(homeFragment);
        Map<String, Object> sceneFragment = new HashMap<>();
        sceneFragment.put(mContext.getResources().getString(R.string.title), mContext.getResources().getString(R.string.scene));
        sceneFragment.put(mContext.getResources().getString(R.string.fragmennt), new SceneFragment());
        fragments.add(sceneFragment);
        Map<String, Object> timerFragment = new HashMap<>();
        timerFragment.put(mContext.getResources().getString(R.string.title), mContext.getResources().getString(R.string.timer));
        timerFragment.put(mContext.getResources().getString(R.string.fragmennt), new TimerFragment());
        fragments.add(timerFragment);
        Map<String, Object> sensorFragment = new HashMap<>();
        sensorFragment.put(mContext.getResources().getString(R.string.title), mContext.getResources().getString(R.string.sensor));
        sensorFragment.put(mContext.getResources().getString(R.string.fragmennt), new SensorFragment());
        fragments.add(sensorFragment);
        view.setViewPager(fragments);
    }

    @Override
    public void detach() {

    }
}
