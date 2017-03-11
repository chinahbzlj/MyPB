package com.zhou.mypowerbee.module.user;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;

import com.zhou.mypowerbee.R;
import com.zhou.mypowerbee.module.welcome.WelcomeActivity;
import com.zhou.mypowerbee.service.ServiceEngine;
import com.zhou.mypowerbee.common.BaseFragment;
import com.zhou.mypowerbee.common.CheckPermissionsActivity;

/**
 * Created by zhou on 17-2-16.
 */

public class LoginSignActivity extends CheckPermissionsActivity implements ICallBack {
    private MyFragmentManager myFragmentManager;
    private UserPersenter persenter;
    private boolean isLoginSuccess = false;

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
        loginFragment.setContext(mContext);
        persenter = new UserPersenter(loginFragment);
        myFragmentManager = new MyFragmentManager();
        myFragmentManager.setCallBack(this);
        myFragmentManager.setFragment(loginFragment);
        ServiceEngine.getServiceEngine().startService(getApplicationContext());
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
        persenter.detach();
        myFragmentManager.clear();
        if (!isLoginSuccess)
            ServiceEngine.getServiceEngine().interuptService(getApplicationContext());
    }

    public void loginSucces() {
        isLoginSuccess = true;
        startActivity(WelcomeActivity.class);
        this.finish();
    }
}
