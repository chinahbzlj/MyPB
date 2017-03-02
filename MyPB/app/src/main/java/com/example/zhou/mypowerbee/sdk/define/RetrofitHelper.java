package com.example.zhou.mypowerbee.sdk.define;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

import com.example.zhou.mypowerbee.app.MyApplication;
import com.example.zhou.mypowerbee.common.Constants;
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
    private Retrofit retrofit;
    /**
     * 结合rxjava 的retrofit
     */
    private Retrofit rxRetrofit;

    private Retrofit initRetrofit() {
        return new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private RetrofitHelper() {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                MediaType contentType = response.body().contentType();
                String bodyString = response.body().string();
                try {
                    Field field = contentType.getClass().getDeclaredField("mediaType");
                    field.setAccessible(true);
                    field.set(contentType, "application/json");
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                Logger.d("request.head: %s \n" +
                                "request.url: %s \n" +
                                "request.body.string: %s \n" +
                                "request.heads: %s \n" +
                                "response.body.string: %s \n"
//                        "....：%s \n"
                        ,
                        request.headers(),
                        request.url(),
                        request.body() == null ? "" : request.body().toString(),
                        response.headers(), bodyString
//                        ,                        buffer.outputStream().toString()
                );
                ResponseBody body = ResponseBody.create(contentType, bodyString);
                return response.newBuilder().body(body).build();
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

    /**
     * 获得 rxRetrofit
     *
     * @return
     */
    public Retrofit getRxRetrofit() {
        if (null != rxRetrofit) return rxRetrofit;
        rxRetrofit = generateRxRetrofit();
        return rxRetrofit;
    }

    private Retrofit generateRxRetrofit() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;

    }
}
