package com.zhou.mypowerbee.sdk.protocl;


import com.zhou.mypowerbee.sdk.request.BaseRequest;

import java.util.Map;

/**
 * Created by zhou on 2015-09-08.
 */
public interface IServiceRequest {
    /**获取url */
    public String getURL();
    /** 检查参数是否有效 */
    public boolean validateParams();
    /** 获取通信方法 get 或 post */
    public String getMethod();
    /** 获取参数用例 "?&newpass=" + newPass + "&oldpass=" + oldPass; */
    public Object getEntity();
    public Map<String, String> getHeader();

    public void executeHttp();

    public void setResponse(BaseRequest.HttpResponseResult result);
}
