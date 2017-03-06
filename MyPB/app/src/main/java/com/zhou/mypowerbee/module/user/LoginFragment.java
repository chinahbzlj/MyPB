package com.zhou.mypowerbee.module.user;


import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

import com.zhou.mypowerbee.R;
import com.zhou.mypowerbee.sdk.core.HttpEngine;
import com.zhou.mypowerbee.sdk.core.ServiceEngiine;
import com.zhou.mypowerbee.ui.BaseFragment;
import com.zhou.mypowerbee.util.ToastUtil;
import com.zhou.mypowerbee.util.ValidateUtil;

import butterknife.OnClick;

/**
 * Created by zhou on 17-2-19.
 */

public class LoginFragment extends BaseFragment implements UserContract.View {
    private UserContract.Persenter persenter;
    private EditText loginAccountEdittext;
    private EditText loginPassEdittext;


    @Override
    public int bindLayout() {
        return R.layout.fragment_login;
    }

    @Override
    public void initView(View view) {
        loginAccountEdittext = (EditText) view.findViewById(R.id.login_account);
        loginPassEdittext = (EditText) view.findViewById(R.id.login_pass);
    }

    @Override
    public void doBusiness(Context mContext) {
        loginAccountEdittext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus)
                    loginAccountEdittext.setError(null);
            }
        });
        loginPassEdittext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus)
                    loginAccountEdittext.setError(null);
            }
        });
    }


    @Override
    @OnClick({R.id.btn_login, R.id.login_forgot_pwd, R.id.btn_sign_up})
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                checkInfo();
                break;
            case R.id.login_forgot_pwd:
                ToastUtil.getInstance().toastShowS("忘记密码！！！");
                break;
            case R.id.btn_sign_up:
                SignFragment fragment = new SignFragment();
                persenter.replaceView(fragment);
                ((LoginSignActivity) getActivity()).getMyFragmentManager().setFragment(fragment);
                break;
        }
    }

    private void checkInfo() {
        String loginAccountText = loginAccountEdittext.getText().toString().trim();
        String loginPassText = loginPassEdittext.getText().toString().trim();
        SpannableStringBuilder accountSp = ValidateUtil.setErrorInfo(getResources(), R.color.txt_color_black, "用户名不能为空");
        SpannableStringBuilder passSp = ValidateUtil.setErrorInfo(getResources(), R.color.txt_color_black, "密码不能为空");
        if (ValidateUtil.isEmpty(loginAccountText)) {
            loginAccountEdittext.setError(accountSp);
            loginAccountEdittext.requestFocus();
        } else if (ValidateUtil.isEmpty(loginPassText)) {
            loginPassEdittext.setError(passSp);
            loginPassEdittext.requestFocus();
        } else {
            persenter.login(loginAccountText, loginPassText);
        }
    }

//        UserLoginRequest request = new UserLoginRequest(loginAccountText, loginPassText);
//        HttpEngine.getEngine().executeHttp(request, UserLoginResponse.class);

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void setPersenter(UserContract.Persenter persenter) {
        this.persenter = persenter;
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void startActivity() {
    }

    @Override
    public void loginSuccess() {
        ((LoginSignActivity)getActivity()).loginSucces();
    }


}
