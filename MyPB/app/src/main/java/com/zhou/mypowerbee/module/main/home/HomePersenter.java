package com.zhou.mypowerbee.module.main.home;

import com.zhou.mypowerbee.app.MyGlobal;
import com.zhou.mypowerbee.model.entity.Device;
import com.zhou.mypowerbee.module.main.home.HomeContract.View;
import com.zhou.mypowerbee.util.ListUtil;

import java.util.List;

/**
 * Created by zhou on 17-3-11.
 */

public class HomePersenter implements HomeContract.Persenter {
    private View view;

    public HomePersenter(View view) {
        this.view = view;
        this.view.setPersenter(this);
    }

    @Override
    public void start() {
        List<Device> devices = MyGlobal.getMyGlobal().getTerminalDatas().queryAllControlDevices();
        List<List<Device>> lists = ListUtil.subList(devices, 8);
        this.view.setData(lists);
    }

    @Override
    public void detach() {

    }
}
