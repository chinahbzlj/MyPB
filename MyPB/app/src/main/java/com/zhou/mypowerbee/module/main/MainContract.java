package com.zhou.mypowerbee.module.main;

import com.zhou.mypowerbee.common.BasePersenter;
import com.zhou.mypowerbee.common.BaseView;
import com.zhou.mypowerbee.model.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by zhou on 17-3-10.
 */

public interface MainContract {
    interface View extends BaseView<Persenter> {
        void setViewPager(List<Map<String, Object>> fragments);

        void setHead(User user);
    }

    interface Persenter extends BasePersenter {

    }
}
