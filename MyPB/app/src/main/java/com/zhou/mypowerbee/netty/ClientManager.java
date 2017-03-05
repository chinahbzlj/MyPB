package com.example.zhou.mypowerbee.netty;

import android.os.Handler;

import com.example.zhou.mypowerbee.service.MyService;

/**
 * Created by zhou on 17-3-3.
 * Socket客户端管理
 * 1.提供初始化接口。2提供发送数据接口。3.提供接收数据接口。
 */

public class ClientManager {
    private static ClientManager clientManager = new ClientManager();
    private Handler serverHandler;
    private ClientManagerNetty clientManagerNetty;

    private ClientManager() {
    }

    public static ClientManager getClientManager() {
        return clientManager;
    }

    public void setServerHandler(Handler serviceHandler) {
        this.serverHandler = serviceHandler;
    }

    /**
     * @param userUUID   用户uuid
     * @param token      token
     * @param deviceUUID 设备uuid
     */
    public void initClientManagerNetty(String userUUID, String token, String deviceUUID) {
        clientManagerNetty = ClientManagerNetty.getClientManagerNetty();
        synchronized (clientManagerNetty) {
            clientManagerNetty.connect(userUUID, token, deviceUUID);
        }
    }
}
