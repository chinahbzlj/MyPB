package com.zhou.mypowerbee.model.serviceread;

import android.os.Messenger;

import com.zhou.mypowerbee.sdk.define.IServiceReadMsg;
import com.zhou.mypowerbee.sdk.define.IServiceSendMsg;

/**
 * Created by zhou on 17-3-7.
 */

public class SetUiMessengerReadMsg extends ServiceReadBase {
    private Messenger uiMessenger;

    public SetUiMessengerReadMsg(Messenger uiMessenger) {
        this.uiMessenger = uiMessenger;
    }

    public Messenger getMessenger() {
        return uiMessenger;
    }
}
