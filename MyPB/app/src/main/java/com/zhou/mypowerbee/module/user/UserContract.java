package com.zhou.mypowerbee.module.user;

import com.zhou.mypowerbee.common.BasePersenter;
import com.zhou.mypowerbee.common.BaseView;
import com.zhou.mypowerbee.model.dto.UserInfoDTO;

/**
 * Created by zhou on 17-2-26.
 */

public interface UserContract {
    interface View extends BaseView<Persenter> {
        void showMessage(String msg);

        void startActivity();

        void loginSuccess();

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
