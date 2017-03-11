package com.zhou.mypowerbee.module.welcome;


import com.orhanobut.logger.Logger;
import com.zhou.mypowerbee.util.ToastUtil;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by zhou on 17-3-5.
 */

public class WelcomePersenter implements WelcomeContract.Persenter {
    private WelcomeContract.View view;
    private SyncUtil syncUtil;
    private CompositeSubscription cs;

    public WelcomePersenter(WelcomeContract.View view) {
        this.view = view;
        cs = new CompositeSubscription();
    }

    @Override
    public void start() {

    }

    @Override
    public void detach() {
        cs.unsubscribe();
    }

    @Override
    public void getAllData() {
        syncUtil = SyncUtil.getSyncUtil();
        syncUtil.setCompositeSubscription(cs);
        syncUtil.setSycnListener(new SyncUtil.SyncListener() {
            @Override
            public void success() {
                view.syncSuccess();
            }

            @Override
            public void failed() {
                ToastUtil.getInstance().toastShowS("同步失败");
                Logger.d("同步失败");
            }
        });
        syncUtil.startSync();
    }

    public void get() {
        Observable.create(new Observable.OnSubscribe<Object>() {
            @Override
            public void call(Subscriber<? super Object> subscriber) {
                //从数据库获取数据
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Object>() {
                    @Override
                    public void call(Object o) {
                        //更新ui
                    }
                });
    }
}
