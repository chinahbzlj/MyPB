package com.zhou.mypowerbee.model.dto;

import com.zhou.mypowerbee.common.Constants;

/**
 * Created by zhou on 17-2-27.
 */
public abstract class BaseDTO {
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
