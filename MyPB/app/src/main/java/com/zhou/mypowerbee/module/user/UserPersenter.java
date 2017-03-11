package com.zhou.mypowerbee.module.user;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.Message;

import com.zhou.mypowerbee.app.MyApplication;
import com.zhou.mypowerbee.common.BaseSubscriber;
import com.zhou.mypowerbee.common.Constants;
import com.zhou.mypowerbee.model.dto.UserInfoDTO;
import com.zhou.mypowerbee.model.dto.VidInfoDTO;
import com.zhou.mypowerbee.model.serviceread.UserLoginReadMsg;
import com.zhou.mypowerbee.model.servicesend.LoginSuccessSendMsg;
import com.zhou.mypowerbee.sdk.define.RequestServers;
import com.zhou.mypowerbee.sdk.define.RetrofitHelper;
import com.zhou.mypowerbee.service.ServiceEngine;
import com.orhanobut.logger.Logger;
import com.zhou.mypowerbee.util.ToastUtil;

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
    private CompositeSubscription cs;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.obj instanceof LoginSuccessSendMsg) {
                if (view != null) {
                    view.loginSuccess();
                } else if (signView != null) {
                    signView.loginSuccess();
                }
                ServiceEngine.getServiceEngine().removeListenerHandler(handler);
            }
        }
    };
    //    CompositeSubscription cs;
    private String vid;

    public UserPersenter(UserContract.View view) {
        replaceView(view);
        ServiceEngine.getServiceEngine().addListenerHandler(handler);
        cs = new CompositeSubscription();
    }

    @Override
    public void start() {

    }

    @Override
    public void detach() {
        cs.unsubscribe();
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
        cs.add(requestServers.userLogin(loginAccountText, loginPassText)
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
                                if (userInfoDTO.isSuccess()) {
                                    sendUserInfoToService(userInfoDTO);
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
//                        view.loginSuccess();
                    }
                }));
    }

    public void sendUserInfoToService(UserInfoDTO userInfoDTO) {
        UserLoginReadMsg userLoginReadMsg = new UserLoginReadMsg(userInfoDTO.Data.getUuid(), userInfoDTO.Expand, userInfoDTO.Data.getUserid());
        ServiceEngine.getServiceEngine().sendDataToService(userLoginReadMsg);

    }

    @Override
    public void signUp() {

    }

    @Override
    public void getVerficationCode(String vid) {
    }

    @Override
    public void getVid(String account) {
        cs.add(RetrofitHelper.getInstance().getDefaultRxApi()
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
                }));
    }

    @Override
    public void register(UserInfoDTO.UserDTO userDTO, String vid, String verificationCode) {
        cs.add(RetrofitHelper.getInstance().getDefaultRxApi().register(userDTO, this.vid, verificationCode)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<UserInfoDTO>() {
                    @Override
                    public void onNext(UserInfoDTO userInfoDTO) {
                        if (userInfoDTO.isSuccess()) {
                            sendUserInfoToService(userInfoDTO);
                        } else {
                            signView.showMessage(userInfoDTO.Message);
                        }
                    }
                }));
    }
}
