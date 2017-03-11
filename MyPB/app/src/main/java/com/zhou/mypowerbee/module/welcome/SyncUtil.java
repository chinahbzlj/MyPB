package com.zhou.mypowerbee.module.welcome;

import android.text.TextUtils;

import com.zhou.mypowerbee.app.MyGlobal;
import com.zhou.mypowerbee.common.BaseSubscriber;
import com.zhou.mypowerbee.model.dto.BaseDTO;
import com.zhou.mypowerbee.model.dto.DeviceInfoDTO;
import com.zhou.mypowerbee.model.dto.GroupInfoDTO;
import com.zhou.mypowerbee.model.dto.NodeInfoDTO;
import com.zhou.mypowerbee.model.dto.TerminalInfoDTO;
import com.zhou.mypowerbee.model.entity.Device;
import com.zhou.mypowerbee.model.entity.Group;
import com.zhou.mypowerbee.model.entity.Node;
import com.zhou.mypowerbee.model.entity.Terminal;
import com.zhou.mypowerbee.sdk.define.RetrofitHelper;
import com.zhou.mypowerbee.util.SPUtil;
import com.orhanobut.logger.Logger;
import com.zhou.mypowerbee.util.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by zhou on 17-3-5.
 */

public class SyncUtil {
    private static SyncUtil syncUtil;
    private String token;
    private String uid;
    private int syncCount;
    private boolean isSync = false;
    private boolean isSyncFail = false;
    private boolean isSyncTime = false;
    public static final int SYNC_SUCEESS = 1;
    public static final int SYNC_FAIL = 2;
    public static final int SYNC_TIMEOUT = 3;
    private static final int TIME_OUT_COUNT = 30000;        //同步超时时间
    private MyRunnable myRunnable;
    private SyncListener syncListener;
    private CompositeSubscription compositeSubscription;

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
        syncCount = 5;
        isSync = true;
        isSyncFail = false;
        syncTerminalAndGroup();
        myRunnable = new MyRunnable();
        ToastUtil.getInstance().postDelayed(myRunnable, 10000);
    }


    private synchronized void syncCount() {
        Logger.d("前syncCount" + syncCount);
        syncCount--;
        Logger.d("后syncCount" + syncCount + " isSyncCout" + isSync + " fail" + isSyncFail);
        if (!isSync || isSyncFail) {
            syncListener.failed();
        }
        if (syncCount == 0 && isSync && !isSyncFail) {
            isSync = false;
            syncListener.success();
        }
    }

    private void syncTerminalAndGroup() {
        Observable<TerminalInfoDTO> terminalObservable = RetrofitHelper.getInstance().getHaveHeaderRxApi().getTerminal();
        Observable<GroupInfoDTO> groupObservable = RetrofitHelper.getInstance().getHaveHeaderRxApi().getGroup();
        compositeSubscription.add(Observable.merge(terminalObservable, groupObservable)
                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<BaseDTO>() {
                    @Override
                    public void onNext(BaseDTO baseDTO) {
                        if (baseDTO instanceof TerminalInfoDTO) {
                            TerminalInfoDTO terminalInfoDTO = (TerminalInfoDTO) baseDTO;
                            if (terminalInfoDTO.Data != null && terminalInfoDTO.Data.size() != 0) {
                                List<Terminal> terminals = new ArrayList<>();
                                for (TerminalInfoDTO.TerminalDTO terminalDTO : terminalInfoDTO.Data) {
                                    terminals.add(terminalDTO.toTerminal());
                                }
                                MyGlobal.getMyGlobal().getTerminalDatas().setAllTerminals(terminals);

                            }
                        } else if (baseDTO instanceof GroupInfoDTO) {
                            GroupInfoDTO groupInfoDTO = (GroupInfoDTO) baseDTO;
                            if (groupInfoDTO.Data != null && groupInfoDTO.Data.size() != 0) {
                                List<Group> groups = new ArrayList<Group>();
                                for (GroupInfoDTO.GroupDTO groupDTO : groupInfoDTO.Data) {
                                    groups.add(groupDTO.toGroup());
                                }
                                MyGlobal.getMyGlobal().getGroupDatas().setAllGroup(groups);
                            }
                        }
                        syncCount();
                    }

                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                        syncNode();
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        isSyncFail = true;
                    }
                }));
    }

    private void syncNode() {
        compositeSubscription.add(RetrofitHelper.getInstance().getHaveHeaderRxApi().getNodes()
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<NodeInfoDTO>() {
                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                        syncSencorDevice();
                    }

                    @Override
                    public void onNext(NodeInfoDTO nodeInfoDTO) {
                        if (nodeInfoDTO.Data != null && nodeInfoDTO.Data.size() != 0) {
                            List<Node> nodes = new ArrayList<Node>();
                            for (NodeInfoDTO.NodeDTO nodeDTO : nodeInfoDTO.Data) {
                                nodes.add(nodeDTO.toNode());
                            }
                            MyGlobal.getMyGlobal().getTerminalDatas().setAllNodes(nodes);
                        }
                        syncCount();
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        isSyncFail = true;
                    }
                }));
    }

    private void syncSencorDevice() {
        compositeSubscription.add(RetrofitHelper.getInstance().getHaveHeaderRxApi().getSensorDevices()
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<DeviceInfoDTO>() {
                    @Override
                    public void onNext(DeviceInfoDTO deviceInfoDTO) {
//                        MyGlobal.getMyGlobal().saveDevices(deviceInfoDTO.Data);
                        if (deviceInfoDTO.Data != null && deviceInfoDTO.Data.size() != 0) {
                            List<Device> devices = new ArrayList<Device>();
                            for (DeviceInfoDTO.DeviceDTO deviceDTO : deviceInfoDTO.Data) {
                                devices.add(deviceDTO.toDevice());
                            }
                            MyGlobal.getMyGlobal().getTerminalDatas().setAllSensorDevices(devices);
                        }

                    }

                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                        syncControlDevice();
                        syncCount();
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        isSyncFail = true;
                    }
                }));
    }

    private void syncControlDevice() {
        compositeSubscription.add(RetrofitHelper.getInstance().getHaveHeaderRxApi().getControlDevices()
                .subscribeOn(Schedulers.io())
                .subscribe(new BaseSubscriber<DeviceInfoDTO>() {
                    @Override
                    public void onNext(DeviceInfoDTO deviceInfoDTO) {
                        if (deviceInfoDTO.Data != null && deviceInfoDTO.Data.size() != 0) {
                            List<Device> devices = new ArrayList<Device>();
                            for (DeviceInfoDTO.DeviceDTO deviceDTO : deviceInfoDTO.Data) {
                                devices.add(deviceDTO.toDevice());
                            }
                            MyGlobal.getMyGlobal().getTerminalDatas().setAllControlDevices(devices);
                        }
                        ToastUtil.getInstance().removeCallbacks(myRunnable);
                        MyGlobal.getMyGlobal().saveAllData();
                    }

                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                        syncCount();
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        isSyncFail = true;
                    }
                }));
    }

    public void setCompositeSubscription(CompositeSubscription compositeSubscription) {
        this.compositeSubscription = compositeSubscription;
    }


    private class MyRunnable implements Runnable {

        @Override
        public void run() {
            isSync = false;
        }
    }

    public void setSycnListener(SyncListener syncListener) {
        this.syncListener = syncListener;
    }

    public interface SyncListener {
        void success();

        void failed();
    }
}
