package com.example.zhou.mypowerbee.service;

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

import com.example.zhou.mypowerbee.netty.ClientNetty;
import com.example.zhou.mypowerbee.sdk.netlog.NetConfigFile;

/**
 * Created by zhou on 17-2-23.
 */

public class MyService extends Service {
    private Looper serviceLooper;
    private ServiceHandler serviceHandler;

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
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                ClientNetty.getInstance().connect(NetConfigFile.SERVER_TCP_IP, NetConfigFile.SERVER_TCP_PORT);

            }
        }).start();
        return START_STICKY;
    }
}
