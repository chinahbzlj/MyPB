package com.example.zhou.mypowerbee.module.welcome;

import android.os.Looper;
import android.text.TextUtils;

import com.example.zhou.mypowerbee.common.BaseSubscriber;
import com.example.zhou.mypowerbee.model.entity.BaseDTO;
import com.example.zhou.mypowerbee.model.entity.GroupInfoDTO;
import com.example.zhou.mypowerbee.model.entity.NodeInfoDTO;
import com.example.zhou.mypowerbee.model.entity.TerminalInfoDTO;
import com.example.zhou.mypowerbee.sdk.define.RetrofitHelper;
import com.example.zhou.mypowerbee.util.SPUtil;
import com.orhanobut.logger.Logger;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zhou on 17-3-5.
 */

public class SyncUtil {
    private static SyncUtil syncUtil;
    private String token;
    private String uid;

    private SyncUtil() {
    }

    private static synchronized void initSycnClient() {
        if (syncUtil == null)
            syncUtil = new SyncUtil();
    }

    public static SyncUtil getSyncUtil() {
        if (syncUtil == null)
            initSycnClient();
        return syncUtil;
    }

    public void startSync() {
        token = SPUtil.getSpUtil().getToken();
        uid = SPUtil.getSpUtil().getUuid();
        if (TextUtils.isEmpty(token) || TextUtils.isEmpty(uid)) {
            Logger.d("token或uid为空");
            return;
        }
        syncTerminalAndGroup();

    }

    private void syncTerminalAndGroup() {
        Observable<TerminalInfoDTO> terminalObservable = RetrofitHelper.getInstance().getHaveHeaderRxApi().getTerminal();
        Observable<GroupInfoDTO> groupObservable = RetrofitHelper.getInstance().getHaveHeaderRxApi().getGroup();
        Observable.merge(terminalObservable, groupObservable)
                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<BaseDTO>() {
                    @Override
                    public void onNext(BaseDTO baseDTO) {
                        if (baseDTO instanceof TerminalInfoDTO) {
                            TerminalInfoDTO terminalInfoDTO = (TerminalInfoDTO) baseDTO;
                            if (terminalInfoDTO.Data.size() != 0) {
                                //同步节点
                                syncNode();
                            }
                        } else if (baseDTO instanceof GroupInfoDTO) {
                            //保存数据
                        }
                    }

                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                    }
                });
    }

    private void syncNode() {
        RetrofitHelper.getInstance().getHaveHeaderRxApi().getNodes()
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<NodeInfoDTO>() {
                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                        syncDevice();
                    }

                    @Override
                    public void onNext(NodeInfoDTO nodeInfoDTO) {
                        if (nodeInfoDTO.Data.size() != 0) {

                        }
                    }
                });
    }

    private void syncDevice() {

    }
}
