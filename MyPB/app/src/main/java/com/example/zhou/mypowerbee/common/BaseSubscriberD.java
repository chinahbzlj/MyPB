package com.example.zhou.mypowerbee.common;

import android.util.Log;

import rx.Subscriber;

/**
 * Created by zhou on 17-2-27.
 */

public abstract class BaseSubscriberD<T> extends Subscriber<T> {
    private static final String TAG = "BaseSubscriberD";
    private BaseView.BaseViewDialog view;

    public BaseSubscriberD(BaseView.BaseViewDialog view) {
        this.view = view;
    }

    @Override
    public void onCompleted() {
        view.closeDialog();
        Log.d(TAG, "onCompleted: ");
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        view.closeDialog();
        Log.d(TAG, "onError: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        view.closeDialog();
        view.showDialog();
        Log.d(TAG, "onStart: ");
    }
}
