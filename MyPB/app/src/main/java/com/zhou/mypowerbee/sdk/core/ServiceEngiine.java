package com.zhou.mypowerbee.sdk.core;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

import com.zhou.mypowerbee.service.MyService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhou on 17-2-23.
 */

public class ServiceEngiine {
    private List<Handler> handlerList;
    private static ServiceEngiine serviceEngiine = new ServiceEngiine();
    private Messenger messenger;
    private MyService service;
    private Context c;

    public ServiceEngiine() {
        handlerList = new ArrayList<>();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    private Messenger uiMessager = new Messenger(handler);
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            messenger = new Messenger(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            messenger = null;
            service = null;
        }
    };

    public static ServiceEngiine getServiceEngiine() {
        return serviceEngiine;
    }

    public void startService(Context context) {
        c = context;
        Intent i = new Intent(context, MyService.class);
        context.bindService(i, serviceConnection, Context.BIND_AUTO_CREATE);
        context.startService(i);
    }

    public void interuptService() {
        if (c != null)
            c.unbindService(serviceConnection);

    }
}
