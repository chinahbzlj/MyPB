package com.zhou.mypowerbee.service;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.zhou.mypowerbee.model.serviceread.ServiceReadBase;
import com.zhou.mypowerbee.model.serviceread.SetUiMessengerReadMsg;
import com.zhou.mypowerbee.model.serviceread.UserLoginReadMsg;
import com.zhou.mypowerbee.model.servicesend.LoginSuccessSendMsg;
import com.zhou.mypowerbee.netty.ClientManager;
import com.zhou.mypowerbee.sdk.define.IServiceReadMsg;
import com.zhou.mypowerbee.sdk.define.IServiceSendMsg;
import com.zhou.mypowerbee.sdk.define.RetrofitHelper;
import com.zhou.mypowerbee.util.SPUtil;

/**
 * Created by zhou on 17-2-23.
 */

public class MyService extends Service {
    private Looper serviceLooper;
    private ServiceHandler serviceHandler;
    private ClientManager clientManager;
    private Messenger uiMessenger;

    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.obj instanceof IServiceReadMsg) {
                if (msg.obj instanceof ServiceReadBase) {
                    parseMessageFromUI((IServiceReadMsg) msg.obj);
                }
            } else if (msg.obj instanceof IServiceSendMsg) {
                if (uiMessenger != null) {
                    try {
                        //发送到ui
                        uiMessenger.send(Message.obtain(msg));
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    /**
     * 解析从UI传过来的消息
     *
     * @param obj
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void parseMessageFromUI(IServiceReadMsg obj) {
        if (obj instanceof UserLoginReadMsg) {
            UserLoginReadMsg userLoginReadMsg = (UserLoginReadMsg) obj;
            SPUtil.getSpUtil().putUUID(userLoginReadMsg.userId);
            SPUtil.getSpUtil().putToken(userLoginReadMsg.token);
            SPUtil.getSpUtil().putUserName(userLoginReadMsg.name);
            RetrofitHelper.getInstance().setTokenAndUid(userLoginReadMsg);
            //登陆成功，告诉登陆界面跳转到下一个界面
            sendToUI(new LoginSuccessSendMsg());
        } else if (obj instanceof SetUiMessengerReadMsg) {
            SetUiMessengerReadMsg uiMessenger = (SetUiMessengerReadMsg) obj;
            this.uiMessenger = uiMessenger.getMessenger();
        }
    }

    private void sendToUI(IServiceSendMsg iServiceSendMsg) {
        try {
            if (uiMessenger != null)
                this.uiMessenger.send(Message.obtain(null, 0, iServiceSendMsg));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d("service","onBind");
        return new Messenger(serviceHandler).getBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("service","oncreate");
        HandlerThread handlerThread = new HandlerThread("MyService", Process.THREAD_PRIORITY_BACKGROUND);
        handlerThread.start();
        serviceLooper = handlerThread.getLooper();
        serviceHandler = new ServiceHandler(serviceLooper);
        clientManager = ClientManager.getClientManager();
        clientManager.setServerHandler(serviceHandler);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("service","onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("service","onDestroy");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        clientManager.initClientManagerNetty("", "", "");
        Log.d("service","onstartcommand");
        return START_STICKY;
    }
}
