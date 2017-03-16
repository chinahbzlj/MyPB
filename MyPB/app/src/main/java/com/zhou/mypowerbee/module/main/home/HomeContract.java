package com.zhou.mypowerbee.module.main.home;

import com.zhou.mypowerbee.common.BasePersenter;
import com.zhou.mypowerbee.common.BaseView;
import com.zhou.mypowerbee.model.entity.Device;

import java.util.List;

/**
 * Created by zhou on 17-3-11.
 */

public class HomeContract {

    interface View extends BaseView<Persenter> {
        void setData(List<List<Device>> lists);
    }

    interface Persenter extends BasePersenter {

    }
}
