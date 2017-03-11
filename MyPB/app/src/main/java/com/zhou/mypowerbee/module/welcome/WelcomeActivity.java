package com.zhou.mypowerbee.module.welcome;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.zhou.mypowerbee.R;
import com.zhou.mypowerbee.common.BaseActivity;
import com.zhou.mypowerbee.module.main.MainActivity;

/**
 * Created by zhou on 17-3-5.
 */

public class WelcomeActivity extends BaseActivity implements WelcomeContract.View {
    private WelcomeContract.Persenter persenter;

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void doBusiness(Context mContext) {
        persenter = new WelcomePersenter(this);
        persenter.getAllData();
    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void setPersenter(Object persenter) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.detach();
    }

    @Override
    public void syncSuccess() {
        startActivity(MainActivity.class);
        this.finish();
    }
}
