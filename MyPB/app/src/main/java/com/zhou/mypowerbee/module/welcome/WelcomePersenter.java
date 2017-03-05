package com.example.zhou.mypowerbee.module.welcome;


import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by zhou on 17-3-5.
 */

public class WelcomePersenter implements WelcomeContract.Persenter {
    private WelcomeContract.View view;
    private SyncUtil syncUtil;

    public WelcomePersenter(WelcomeContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void getAllData() {
        syncUtil = SyncUtil.getSyncUtil();
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
