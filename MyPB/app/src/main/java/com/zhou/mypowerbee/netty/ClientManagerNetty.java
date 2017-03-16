package com.zhou.mypowerbee.netty;

import android.text.TextUtils;

import com.orhanobut.logger.Logger;

/**
 * Created by zhou on 17-3-3.
 * <p>
 * 管理ClientNetty，如启动，关闭
 * 实现ClientNetty中所要用到的NettyClientListener，处理接收到的数据
 * 发送数据
 */

public class ClientManagerNetty {
    private static ClientManagerNetty clientManagerNetty;
    private boolean isConnect = false;
    private ClientNetty clientNetty;
    public static ClientManagerNetty getClientManagerNetty() {
        if (clientManagerNetty == null)
            initSycnClient();
        return clientManagerNetty;
    }

    private static void initSycnClient() {
        if (clientManagerNetty == null)
            clientManagerNetty = new ClientManagerNetty();
    }

    public void connect(String userUUID, String token, String deviceUUID) {
        if (TextUtils.isEmpty(userUUID) || TextUtils.isEmpty(token) || TextUtils.isEmpty(deviceUUID)) {
            Logger.d("参数错误%s");
            return;
        }

        if (!isConnect) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if(clientNetty != null){
                        clientNetty.closeConnection();
                    }
                    if(clientNetty == null)
                        clientNetty = ClientNetty.getInstance();
                    clientNetty.connect("zg118.com",8000);
                }
            }).start();
        }

    }


}
