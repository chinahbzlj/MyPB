package com.zhou.mypowerbee.sdk.request;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.zhou.mypowerbee.sdk.define.RequestServers;
import com.zhou.mypowerbee.sdk.define.RetrofitHelper;
import com.zhou.mypowerbee.sdk.protocl.IServiceRequest;

/**
 * Created by zhou on 2015-09-08.
 */
public class BaseRequest implements IServiceRequest {

    @Override
    public String getURL() {
        return null;
    }

    @Override
    public boolean validateParams() {
        return true;
    }

    @Override
    public String getMethod() {
        return "POST";
    }

    @Override
    public Object getEntity() {
        return null;
    }

    @Override
    public Map<String, String> getHeader() {
        return null;
    }

    @Override
    public void executeHttp() {

    }

    @Override
    public void setResponse(HttpResponseResult result) {
        this.responseResult = result;
    }

    protected RequestServers requestServers = RetrofitHelper.getInstance().getRetrofit().create(RequestServers.class);

//    protected HttpEngine.HttpRequestListener listener;

    protected HttpResponseResult responseResult;

    public interface HttpResponseResult {
        void success(Response<String> response);

        void failure(String msg);
    }

    protected Callback callback = new Callback<String>() {
        @Override
        public void onResponse(Call<String> call, Response<String> response) {
            responseResult.success(response);
        }

        @Override
        public void onFailure(Call<String> call, Throwable t) {
            responseResult.failure("");
        }

    };
}
