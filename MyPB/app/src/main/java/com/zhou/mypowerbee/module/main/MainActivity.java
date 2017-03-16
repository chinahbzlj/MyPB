package com.zhou.mypowerbee.module.main;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhou.mypowerbee.R;
import com.zhou.mypowerbee.model.entity.User;
import com.zhou.mypowerbee.service.ServiceEngine;
import com.zhou.mypowerbee.common.BaseActivity;
import com.zhou.mypowerbee.util.LoadImageUtil;
import com.zhou.mypowerbee.util.ToastUtil;
import com.zhou.mypowerbee.widget.MyTabLayout;
import com.zhou.mypowerbee.widget.MyTabLayout.MyTabLayoutListener;
import com.zhou.mypowerbee.widget.MyViewPager;

import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainContract.View {
    @BindView(R.id.tool_bar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.title)
    TextView titleTextView;
    @BindView(R.id.viewpager)
    MyViewPager myViewPager;
    @BindView(R.id.tab)
    MyTabLayout tabLayout;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    ImageView userHead;
    TextView userName, userEmail;
    private ExitRunnable exitRunnable = new ExitRunnable();
    private MyFragmentAdapter adapter;
    private MainContract.Persenter persenter;

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(View view) {
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        titleTextView.setText(R.string.home);
        adapter = new MyFragmentAdapter(getSupportFragmentManager());
        adapter.setContext(this);

        View headView = navigationView.getHeaderView(0);
        userHead = (ImageView) headView.findViewById(R.id.user_head);
        userName = (TextView) headView.findViewById(R.id.user_name);
        userEmail = (TextView) headView.findViewById(R.id.user_email);
    }

    @Override
    public void doBusiness(Context mContext) {
        new MainPersenter(this);
        persenter.start();
        ServiceEngine.getServiceEngine().startService(getApplicationContext());
    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            repressToExitApp(3000);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        String title = titleTextView.getText().toString();
        if (title.equals(getResources().getString(R.string.home))) {
            getMenuInflater().inflate(R.menu.fragment_home, menu);
        } else if (title.equals(getResources().getString(R.string.scene))) {
            getMenuInflater().inflate(R.menu.fragment_scene, menu);
        } else if (title.equals(getResources().getString(R.string.timer))) {
            getMenuInflater().inflate(R.menu.fragment_timer, menu);
        } else if (title.equals(getResources().getString(R.string.sensor))) {
            getMenuInflater().inflate(R.menu.fragment_sensor, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.add_device) {
            ToastUtil.getInstance().toastShowS("设置");
        } else if (id == R.id.unbind_device) {
            ToastUtil.getInstance().toastShowS("解绑设备");
        } else if (id == R.id.folder) {
            ToastUtil.getInstance().toastShowS("文件夹");
        } else if (id == R.id.add_scene) {
            ToastUtil.getInstance().toastShowS("添加场景");
        } else if (id == R.id.add_timer) {
            ToastUtil.getInstance().toastShowS("添加定时器");
        } else if (id == R.id.add_sensor) {
            ToastUtil.getInstance().toastShowS("添加传感器");
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_device) {

        } else if (id == R.id.nav_intelligent_scene) {

        } else if (id == R.id.nav_set_up) {

        } else if (id == R.id.nav_about) {

        } else if (id == R.id.nav_exit) {

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ServiceEngine.getServiceEngine().interuptService(getApplicationContext());
    }

    private void repressToExitApp(int delayMillis) {
        if (exitRunnable.getIsRun()) {
            this.finish();
        } else {
            exitRunnable.setIsRun(true);
            ToastUtil.getInstance().toastShowS("在点击一次退出应用！");
            ToastUtil.getInstance().postDelayed(exitRunnable, delayMillis);
        }
    }

    @Override
    public void setPersenter(MainContract.Persenter persenter) {
        this.persenter = persenter;
    }

    @Override
    public void setViewPager(List<Map<String, Object>> fragments) {
        adapter.setData(fragments);
        myViewPager.setAdapter(adapter);
        tabLayout.setMyTabLayoutListener(new MyTabLayoutListener() {
            @Override
            public void setTitle(String title) {
                titleTextView.setText(title);
                //刷新menu
                getWindow().invalidatePanelMenu(Window.FEATURE_OPTIONS_PANEL);
                invalidateOptionsMenu();
            }
        });
        tabLayout.setupWithViewPager(myViewPager);
    }

    @Override
    public void setHead(User user) {
        if (!TextUtils.isEmpty(user.getAvatarpath()))
            LoadImageUtil.loadImage(this, user.getAvatarpath(), userHead);
        userName.setText(user.getUserid());
        userEmail.setText(user.getEmail());
    }

    private class ExitRunnable implements Runnable {
        private boolean isRun = false;

        public void setIsRun(boolean isRun) {
            this.isRun = isRun;
        }

        public boolean getIsRun() {
            return isRun;
        }

        @Override
        public void run() {
            isRun = false;
        }
    }

}
