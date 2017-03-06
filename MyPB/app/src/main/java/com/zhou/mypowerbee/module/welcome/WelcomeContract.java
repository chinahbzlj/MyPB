package com.zhou.mypowerbee.module.welcome;

import com.zhou.mypowerbee.common.BasePersenter;
import com.zhou.mypowerbee.common.BaseView;

/**
 * Created by zhou on 17-3-5.
 */

public class WelcomeContract {

    interface View extends BaseView {

    }

    interface Persenter extends BasePersenter {
        //获取所有设备信息
        void getAllData();
    }
}
