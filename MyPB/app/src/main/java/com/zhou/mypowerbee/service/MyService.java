package com.zhou.mypowerbee.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.support.annotation.Nullable;

import com.zhou.mypowerbee.netty.ClientManager;
import com.zhou.mypowerbee.netty.ClientNetty;
import com.zhou.mypowerbee.sdk.netlog.NetConfigFile;

/**
 * Created by zhou on 17-2-23.
 */

public class MyService extends Service {
    private Looper serviceLooper;
    private ServiceHandler serviceHandler;
    private ClientManager clientManager;


    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new Messenger(serviceHandler).getBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        HandlerThread handlerThread = new HandlerThread("MyService", Process.THREAD_PRIORITY_BACKGROUND);
        handlerThread.start();
        serviceLooper = handlerThread.getLooper();
        serviceHandler = new ServiceHandler(serviceLooper);
        clientManager = ClientManager.getClientManager();
        clientManager.setServerHandler(serviceHandler);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        clientManager.initClientManagerNetty("","","");
        return START_STICKY;
    }
}
