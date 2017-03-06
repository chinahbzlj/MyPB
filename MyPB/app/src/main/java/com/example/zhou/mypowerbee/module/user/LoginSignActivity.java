package com.example.zhou.mypowerbee.module.user;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;

import com.example.zhou.mypowerbee.R;
import com.example.zhou.mypowerbee.module.welcome.WelcomeActivity;
import com.example.zhou.mypowerbee.sdk.core.ServiceEngiine;
import com.example.zhou.mypowerbee.ui.BaseFragment;
import com.example.zhou.mypowerbee.ui.CheckPermissionsActivity;
import com.example.zhou.mypowerbee.ui.MainActivity;

/**
 * Created by zhou on 17-2-16.
 */

public class LoginSignActivity extends CheckPermissionsActivity implements ICallBack {
    private Fragment mFragment;
    private MyFragmentManager myFragmentManager;
    private UserPersenter persenter;

    @Override
    public int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void doBusiness(Context mContext) {
        LoginFragment loginFragment = new LoginFragment();
        persenter = new UserPersenter(loginFragment);
        myFragmentManager = new MyFragmentManager();
        myFragmentManager.setCallBack(this);
        myFragmentManager.setFragment(loginFragment);
    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void callback(Object o) {
        if (o != null && o instanceof Fragment) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, (BaseFragment) o).commit();
        } else {
            finish();
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            myFragmentManager.gotoBlack();
            return false;
        }
        return true;
    }

    public MyFragmentManager getMyFragmentManager() {
        return myFragmentManager;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ServiceEngiine.getServiceEngiine().interuptService();
    }

    public void loginSucces() {
        startActivity(WelcomeActivity.class);
        this.finish();
    }
}
