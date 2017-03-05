package com.example.zhou.mypowerbee.netty;

/**
 * Created by zhou on 17-3-3.
 * Socket客户端管理
 * 1.提供初始化接口。2提供发送数据接口。3.提供接收数据接口。
 */

public class ClientManager {
    private ClientManager clientManager = new ClientManager();

    private ClientManager() {
    }

    public ClientManager getClientManager() {
        return clientManager;
    }
}
