package com.example.zhou.mypowerbee.service;

import android.os.Handler;
import android.os.Message;

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

    public void addListenerHandler(Handler handler) {

    }
}
