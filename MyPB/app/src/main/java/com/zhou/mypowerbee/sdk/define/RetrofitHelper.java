package com.example.zhou.mypowerbee.sdk.define;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;

import com.example.zhou.mypowerbee.app.MyApplication;
import com.example.zhou.mypowerbee.common.Constants;
import com.example.zhou.mypowerbee.util.SPUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by zhou on 16-10-24.
 */
public class RetrofitHelper {
    private static RetrofitHelper retrofitHelper;

    private OkHttpClient okHttpClient;
    private OkHttpClient headerOkHttpClient;
    private Retrofit retrofit;
    private Gson gson;
    /**
     * 结合rxjava 的retrofit
     */
    private Retrofit rxRetrofit;

    private Retrofit headerRxRetrofit;

    private Retrofit initRetrofit() {
        return new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    private void looger(Request request, Response response) {
        String bodyString = null;
        try {
            bodyString = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logger.d("request.head: %s \n" +
                        "request.url: %s \n" +
                        "request.body.string: %s \n" +
                        "request.heads: %s \n" +
                        "response.body.string: %s \n"
                ,
                request.headers(),
                request.url(),
                request.body() == null ? "" : request.body().toString(),
                response.headers(), bodyString
        );
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private RetrofitHelper() {
        gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .build();
                Response response = chain.proceed(request);
                looger(request, response);
                return chain.proceed(request);
            }
        };
        Context context = MyApplication.getInstance().getApplicationContext();
        File[] file = context.getExternalCacheDirs();
        okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor)
                .cache(new Cache(file[0], 20 * 1024 * 1024))
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void setTokenAndUid(final String uid, final String token) {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .header("uid", uid)
                        .header("token", token)
                        .build();
                Response response = chain.proceed(request);
                looger(request, response);
                return chain.proceed(request);
            }
        };
        Context context = MyApplication.getInstance().getApplicationContext();
        File[] file = context.getExternalCacheDirs();
        if (headerOkHttpClient != null)
            headerOkHttpClient = null;
        headerOkHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor)
                .cache(new Cache(file[0], 20 * 1024 * 1024))
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    private static synchronized void syncInit() {
        if (retrofitHelper == null)
            retrofitHelper = new RetrofitHelper();
    }

    public static RetrofitHelper getInstance() {
        if (retrofitHelper == null)
            syncInit();
        return retrofitHelper;
    }

    public Retrofit getRetrofit() {
        if (retrofit != null) return retrofit;
        retrofit = initRetrofit();
        return retrofit;
    }

    public RequestServers getDefaultRxApi() {
        return getRxRetrofit().create(RequestServers.class);
    }

    public RequestServers getHaveHeaderRxApi() {
        if (headerRxRetrofit == null)
            headerRxRetrofit = generateRxRetrofit(headerOkHttpClient);
        return headerRxRetrofit.create(RequestServers.class);
    }

    /**
     * 获得 rxRetrofit
     *
     * @return
     */
    public Retrofit getRxRetrofit() {
        if (null != rxRetrofit) return rxRetrofit;
        rxRetrofit = generateRxRetrofit(okHttpClient);
        return rxRetrofit;
    }

    private Retrofit generateRxRetrofit(OkHttpClient okHttpClient) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;

    }
}
