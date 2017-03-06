package com.zhou.mypowerbee.module.user;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;

import com.zhou.mypowerbee.R;
import com.zhou.mypowerbee.app.MyApplication;
import com.zhou.mypowerbee.app.MyGlobal;
import com.zhou.mypowerbee.common.BaseSubscriber;
import com.zhou.mypowerbee.common.Constants;
import com.zhou.mypowerbee.model.entity.UserInfoDTO;
import com.zhou.mypowerbee.model.entity.VidInfoDTO;
import com.zhou.mypowerbee.sdk.core.ServiceEngiine;
import com.zhou.mypowerbee.sdk.define.RequestServers;
import com.zhou.mypowerbee.sdk.define.RetrofitHelper;
import com.zhou.mypowerbee.util.SPUtil;
import com.zhou.mypowerbee.util.SnackbarUtils;
import com.zhou.mypowerbee.util.ToastUtil;
import com.orhanobut.logger.Logger;

import java.io.IOException;

import io.netty.util.internal.StringUtil;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.adapter.rxjava.Result;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by zhou on 17-2-26.
 */

public class UserPersenter implements UserContract.Persenter {
    private UserContract.View view;
    private UserContract.SignView signView;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    //    CompositeSubscription cs;
    private String vid;

    public UserPersenter(UserContract.View view) {
//        cs = new CompositeSubscription();
        replaceView(view);
    }

    @Override
    public void start() {

    }

    @Override
    public void replaceView(UserContract.View view) {
        if (view instanceof UserContract.SignView) {
            this.signView = (UserContract.SignView) view;
            this.signView.setPersenter(this);
        } else {
            this.view = view;
            this.view.setPersenter(this);
        }
    }

    @Override
    public void login(String loginAccountText, String loginPassText) {
        RequestServers requestServers = RetrofitHelper.getInstance().getDefaultRxApi();
        requestServers.userLogin(loginAccountText, loginPassText)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<Result<UserInfoDTO>, Result<UserInfoDTO>>() {
                    @TargetApi(Build.VERSION_CODES.KITKAT)
                    @Override
                    public Result<UserInfoDTO> call(Result<UserInfoDTO> userInfoDTOResult) {
                        if (!userInfoDTOResult.isError()) {
                            Response<UserInfoDTO> userInfoDTOResponse = userInfoDTOResult.response();
                            if (userInfoDTOResponse != null) {
                                UserInfoDTO userInfoDTO = userInfoDTOResponse.body();
                                UserInfoDTO.UserDTO userdto = userInfoDTO.Data;
                                if (userInfoDTO.isSuccess()) {
                                    view.startActivity();
                                    SPUtil.getSpUtil().putUUID(userdto.getUuid());
                                    SPUtil.getSpUtil().putToken(userInfoDTO.Expand);
                                    RetrofitHelper.getInstance().setTokenAndUid(userdto.getUuid(),userInfoDTO.Expand);
                                    RetrofitHelper.getInstance().setTokenAndUid(userdto.getUuid(),userInfoDTO.Expand);
                                }
                            }
                        } else {

                        }
                        return userInfoDTOResult;
                    }
                })
                .subscribe(new BaseSubscriber<Result<UserInfoDTO>>() {
                    @Override
                    public void onNext(Result<UserInfoDTO> userInfoDTOResult) {
                        Response<UserInfoDTO> userInfoDTOResponse = userInfoDTOResult.response();
//                        UserInfoDTO userInfoDTO = userInfoDTOResponse.body();
//                        ToastUtil.getInstance().toastShowS("登陆成功！");
                        view.loginSuccess();
                    }
                });
    }

    @Override
    public void signUp() {

    }

    @Override
    public void getVerficationCode(String vid) {
//        cs.add(
//        RetrofitHelper.getInstance().getDefaultRxApi()
//                .getverficationCode(vid)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new BaseSubscriber<ResponseBody>() {
//                    @Override
//                    public void onNext(ResponseBody responseBody) {
//                        try {
//                            signView.setVerficationCode(responseBody.bytes());
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                        try {
//                            Logger.d("下载文件类型", String.valueOf(responseBody.contentLength()) + String.valueOf(responseBody.bytes().length));
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                })
////        )
//        ;
    }

    @Override
    public void getVid(String account) {
        RetrofitHelper.getInstance().getDefaultRxApi()
                .getVid(account)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<VidInfoDTO>() {
                    @Override
                    public void onNext(VidInfoDTO vidInfoDTO) {
                        if (vidInfoDTO.isSuccess()) {
                            //获取vid之后获取验证码图片
                            Logger.d("验证码链接: %s ", Constants.VERIFYCODE_URL + vidInfoDTO.Data);
                            signView.setVerficationCode(Constants.VERIFYCODE_URL + vidInfoDTO.Data);
                            vid = vidInfoDTO.Data;
                        } else {
                            signView.showMessage(vidInfoDTO.Message);
                        }
                    }
                });
    }

    @Override
    public void register(UserInfoDTO.UserDTO userDTO, String vid, String verificationCode) {
        RetrofitHelper.getInstance().getDefaultRxApi().register(userDTO, this.vid, verificationCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<UserInfoDTO>() {
                    @Override
                    public void onNext(UserInfoDTO userInfoDTO) {
                        if (userInfoDTO.isSuccess()) {
//                            Logger
                        } else {
                            signView.showMessage(userInfoDTO.Message);
                        }
                    }
                });
    }
}
