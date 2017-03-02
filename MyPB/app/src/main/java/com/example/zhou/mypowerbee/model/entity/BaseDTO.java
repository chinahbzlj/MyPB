package com.example.zhou.mypowerbee.model.entity;

import com.example.zhou.mypowerbee.common.Constants;

/**
 * Created by zhou on 17-2-27.
 */
abstract class BaseDTO {
    public int Code = -1;
    public String Message;
    public String Expand;

    public boolean isSuccess() {
        return Code == Constants.SUCCESS_CODE;
    }

    public String errMsg() {
        return Message;
    }
}