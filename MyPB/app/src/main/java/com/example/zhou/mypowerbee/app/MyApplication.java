package com.example.zhou.mypowerbee.app;

import android.app.Application;
import android.content.res.Configuration;

import com.example.zhou.mypowerbee.R;
import com.example.zhou.mypowerbee.util.ToastUtil;
import com.orhanobut.logger.Logger;

/**
 * Created by zhou on 17-2-19.
 */

public class MyApplication extends Application {

    public static MyApplication instance = null;
    public static boolean isDebug = false;
    public static String APP_NAME = null;

    @Override
    public void onCreate() {
        super.onCreate();
        APP_NAME = getResources().getString(R.string.app_name);
        instance = this;
        ToastUtil.getInstance().setActivity(getApplicationContext());
        //打印日志
        Logger.init("MDD");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    public synchronized static MyApplication getInstance() {
        if (null == instance) {
            instance = new MyApplication();
        }
        return instance;
    }
}
