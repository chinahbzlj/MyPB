package com.example.zhou.mypowerbee.sdk.protocl;

/**
 * Created by zhou on 2015-09-08.
 */
public interface IServiceResponse {
    public void initData(String jsonStr);
//    public void initData(byte[] value);
    public boolean isError();
    public int errMsgRes();
    public String errMsg();
}
