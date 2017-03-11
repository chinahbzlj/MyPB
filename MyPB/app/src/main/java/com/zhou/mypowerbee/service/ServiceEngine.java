package com.zhou.mypowerbee.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import com.zhou.mypowerbee.model.serviceread.SetUiMessengerReadMsg;
import com.zhou.mypowerbee.sdk.define.IServiceReadMsg;
import com.zhou.mypowerbee.sdk.define.IServiceSendMsg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhou on 17-2-27.
 */

public class ServiceEngine {
    private static ServiceEngine serviceEngine;
    private List<Handler> handlerList;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg == null) return;
            if (msg.obj instanceof IServiceSendMsg) {

                for (Handler handler : handlerList) {
                    handler.sendMessage(Message.obtain(msg));
                }
            }
        }
    };

    private boolean isBound = false;

    private ServiceEngine() {
        this.handlerList = new ArrayList<>();
    }

    private MyService service;

    private Messenger serviceMessenger;

    private Messenger uiMessenger = new Messenger(handler);
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            serviceMessenger = new Messenger(service);
            SetUiMessengerReadMsg setUiMessengerReadMsg = new SetUiMessengerReadMsg(uiMessenger);
            sendDataToService(setUiMessengerReadMsg);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            serviceMessenger = null;
            service = null;
        }
    };
    private Intent i;
    private Context context;

    public void startService(Context context) {
        this.context = context;
        i = new Intent(context, MyService.class);
        isBound = context.bindService(i, serviceConnection, Context.BIND_AUTO_CREATE);
        context.startService(i);
        Log.d("service", " isbound " + isBound);
    }

    public void addListenerHandler(Handler handler) {
        if (handler != null && !handlerList.contains(handler))
            this.handlerList.add(handler);
    }

    public void removeListenerHandler(Handler handler) {
        if (handler != null && handlerList.contains(handler))
            this.handlerList.remove(handler);
    }

    public void sendDataToService(IServiceReadMsg iServiceReadMsg) {
        try {
            serviceMessenger.send(Message.obtain(null, 0, iServiceReadMsg));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static ServiceEngine getServiceEngine() {
        if (serviceEngine == null)
            initSycnClient();
        return serviceEngine;
    }

    private static synchronized void initSycnClient() {
        if (serviceEngine == null)
            serviceEngine = new ServiceEngine();
    }

    public void interuptService(Context context) {
        if (serviceConnection != null && isBound)
            context.unbindService(serviceConnection);
        this.context.stopService(i);
    }

}
