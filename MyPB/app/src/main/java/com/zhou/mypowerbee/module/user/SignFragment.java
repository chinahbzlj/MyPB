package com.zhou.mypowerbee.module.user;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zhou.mypowerbee.R;
import com.zhou.mypowerbee.model.entity.UserInfoDTO;
import com.zhou.mypowerbee.ui.BaseFragment;
import com.zhou.mypowerbee.util.LoadImageUtil;
import com.zhou.mypowerbee.util.SnackbarUtils;
import com.zhou.mypowerbee.util.ToastUtil;
import com.zhou.mypowerbee.util.ValidateUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhou on 17-2-19.
 */

public class SignFragment extends BaseFragment implements UserContract.SignView {
    @BindView(R.id.register_account)
    EditText registerAccount;
    @BindView(R.id.register_email)
    EditText registerEmail;
    @BindView(R.id.register_verification_code)
    EditText registerVerificationCode;
    @BindView(R.id.register_pwd)
    EditText registerPwd;
    @BindView(R.id.register_confirm_pwd)
    EditText registerConfirmPwd;
    @BindView(R.id.get_verification_code)
    Button getVerificationCode;
    @BindView(R.id.get_verification_code_img)
    ImageView getVerificationCodeImg;
    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.btn_register)
    Button btnRegister;
    private UserContract.Persenter userPersenter;
    private String nameGetVerfication;
    private String vid;

    @Override
    public int bindLayout() {
        return R.layout.fragment_sign;
    }

    @Override
    public void initView(View view) {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolBar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.getInstance().toastShowS("返回");
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @OnClick({R.id.get_verification_code, R.id.get_verification_code_img, R.id.btn_register})
    @Override
    public void widgetClick(View v) {
        if (v.getId() == R.id.get_verification_code || v.getId() == R.id.get_verification_code_img) {
            //获取验证码需要先通过要注册的账户获取vid，再通过vid获取验证码图片
            String userName = registerAccount.getText().toString().trim();
            if (ValidateUtil.isEmpty(userName)) {
                showMessage(getString(R.string.please_enter_account));
            } else if (TextUtils.isEmpty(nameGetVerfication)) {
                nameGetVerfication = userName;
                userPersenter.getVid(nameGetVerfication);
            } else if (userName.equals(nameGetVerfication) && !TextUtils.isEmpty(vid)) {
                //多次点击验证码按钮，手动刷新验证码
                userPersenter.getVerficationCode(vid);
            } else {
                userPersenter.getVid(nameGetVerfication);
            }
        } else if (v.getId() == R.id.btn_register) {
            String email = registerEmail.getText().toString().trim();
            String verificationCode = registerVerificationCode.getText().toString().trim();
            String password = registerPwd.getText().toString().trim();
            String confirmPwd = registerConfirmPwd.getText().toString().trim();
            if (!ValidateUtil.isEmail(email)) {
                showMessage(getString(R.string.email_prompt));
            } else if (TextUtils.isEmpty(verificationCode)) {
                showMessage(getString(R.string.code_prompt));
            } else if (TextUtils.isEmpty(password)) {
                showMessage("请输入密码");
            } else if (TextUtils.isEmpty(confirmPwd)) {
                showMessage("请确认密码");
            } else if (!password.equals(confirmPwd)) {
                showMessage("两次输入的密码不一样，请先确认密码！");
            } else {
                UserInfoDTO.UserDTO userDTO = new UserInfoDTO.UserDTO();
                userDTO.setUserid(registerAccount.getText().toString().trim());
                userDTO.setEmail(email);
                userDTO.setPass(password);
                userPersenter.register(userDTO, vid, verificationCode);
            }
        }
    }

    @Override
    public void setPersenter(UserContract.Persenter persenter) {
        this.userPersenter = persenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void setVerficationCode(byte[] verficationCode) {
//        getVerificationCode.setVisibility(View.GONE);
//        getVerificationCodeImg.setVisibility(View.VISIBLE);
//        Glide.with(this).load(verficationCode).into(getVerificationCodeImg);
    }

    @Override
    public void setVerficationCode(String verficationCode) {
        getVerificationCode.setVisibility(View.GONE);
        getVerificationCodeImg.setVisibility(View.VISIBLE);
//        Glide.with(this).load(verficationCode).into(getVerificationCodeImg);
        LoadImageUtil.loadImage(this, verficationCode, getVerificationCodeImg);
    }

    @Override
    public void setVid(String vid) {

    }

    @Override
    public void loginSuccess() {
        ((LoginSignActivity) getActivity()).loginSucces();
    }

    @Override
    public void showMessage(String msg) {
        SnackbarUtils.showShortSnackbar(getVerificationCode, msg, ContextCompat.getColor(getContext(), R.color.topbar_txt_color), ContextCompat.getColor(getContext(), R.color.red));
    }

    @Override
    public void startActivity() {

    }
}
