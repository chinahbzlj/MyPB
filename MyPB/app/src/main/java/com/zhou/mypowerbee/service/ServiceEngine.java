package com.zhou.mypowerbee.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

import java.util.List;

/**
 * Created by zhou on 17-2-27.
 */

public class ServiceEngine {
    private List<Handler> handlerList;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };
    private MyService service;

    private Messenger serviceMessenger;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            serviceMessenger = new Messenger(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            serviceMessenger = null;
            service = null;
        }
    };

    public void startService(Context context) {
        Intent i = new Intent(context, MyService.class);
        context.bindService(i, serviceConnection, Context.BIND_AUTO_CREATE);
        context.startService(i);
    }

    public void addListenerHandler(Handler handler) {

    }
}
