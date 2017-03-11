package com.zhou.mypowerbee.app;

import android.app.Application;
import android.content.res.Configuration;
import android.database.sqlite.SQLiteDatabase;

import com.zhou.mypowerbee.R;
import com.zhou.mypowerbee.util.SPUtil;
import com.zhou.mypowerbee.util.ToastUtil;
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
        MyGlobal.getMyGlobal().init(getApplicationContext());
        //初始化Toast
        ToastUtil.getInstance().setActivity(getApplicationContext());
        //初始化SharedPreferences
        SPUtil.getSpUtil().init(APP_NAME, getApplicationContext());
        //打印日志
        Logger.init("MDD");
        //初始化数据库
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
