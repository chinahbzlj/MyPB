package com.example.zhou.mypowerbee.common;

import com.orhanobut.logger.Logger;

import rx.Subscriber;

/**
 * Created by zhou on 17-2-27.
 */

public abstract class BaseSubscriber<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        Logger.d("请求错误:%s", e.getMessage());
    }
}
