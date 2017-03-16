package com.zhou.mypowerbee.common;

import com.orhanobut.logger.Logger;
import com.zhou.mypowerbee.util.ToastUtil;

import java.net.SocketTimeoutException;

import rx.Subscriber;

/**
 * Created by zhou on 17-2-27.
 */

public abstract class BaseSubscriber<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {
//        Logger.d("请求完成");
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        Logger.d("请求错误:%s", e.getMessage());
        if(e instanceof SocketTimeoutException){
            ToastUtil.getInstance().toastShowS("超时");
        }
    }
}
