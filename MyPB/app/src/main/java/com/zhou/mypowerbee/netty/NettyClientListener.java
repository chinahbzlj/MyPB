package com.zhou.mypowerbee.netty;

/**
 * Created by zhou on 17-3-2.
 */

public abstract class NettyClientListener {
    /**
     * 连接成功
     */
    public abstract void connectSuccess();

    /**
     * 断开连接回调, 断开后还有可能重连
     */
    public void interuptConnect() {

    }

    /**
     * 关闭连接回调，关闭后，网络不会再自动重连
     */
    public void closeConnect() {

    }

    /**
     * 链接出异常的时候，会掉用该方法，然后关闭链接
     */
    public void exceptionCaught() {

    }

    /**
     * 从网络上获得数据
     */
    public abstract void readData(Object data);
}
