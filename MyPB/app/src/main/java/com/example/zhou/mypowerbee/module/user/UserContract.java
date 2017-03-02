package com.example.zhou.mypowerbee.module.user;

import com.example.zhou.mypowerbee.common.BasePersenter;
import com.example.zhou.mypowerbee.common.BaseView;
import com.example.zhou.mypowerbee.model.entity.UserInfoDTO;

/**
 * Created by zhou on 17-2-26.
 */

public interface UserContract {
    interface View extends BaseView<Persenter> {
        void showMessage(String msg);

        void startActivity();

    }

    interface SignView extends View {
        void setVerficationCode(byte[] verficationCode);

        void setVerficationCode(String verficationCode);

        void setVid(String vid);

    }

    interface Persenter extends BasePersenter {
        void replaceView(View view);

        void login(String loginAccountText, String loginPassText);

        void signUp();

        void getVerficationCode(String vid);

        void getVid(String account);

        void register(UserInfoDTO.UserDTO userDTO, String vid, String verificationCode);

    }
}
