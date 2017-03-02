package com.example.zhou.mypowerbee.sdk.response;


import com.example.zhou.mypowerbee.sdk.define.ErrorCode;
import com.example.zhou.mypowerbee.sdk.protocl.IServiceResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONException;

/**
 * Created by zhou on 2015-09-08.
 */
public class BaseResponse implements IServiceResponse {
    public int errCode;
    public Object expand;
    public Object message;

    public void paseData(Object data) throws JSONException {
    }

    @Override
    public boolean isError() {
        return errCode != ErrorCode.SUCCESS;
    }

    @Override
    public int errMsgRes() {
        return 0;
    }

    @Override
    public String errMsg() {
        if (message instanceof String) {
            return message.toString();
        }
        return "";
    }

    @Override
    public void initData(String jsonStr) {
        jsonStr.replace("\\", "");
        try {
            JsonObject jsonObject = new JsonParser().parse(jsonStr).getAsJsonObject();
            errCode = jsonObject.get("Code").getAsInt();
            message = jsonObject.get("Message").getAsString();
//            JSONObject jsonObject = new JSONObject(jsonStr);
//            errCode = jsonObject.optInt("Code");
//            expand = jsonObject.opt("Expand");
//            message = jsonObject.opt("Message");
            if (errCode == 0) {
                expand = jsonObject.get("Expand").getAsString();
//                Object o = jsonObject.opt("Data");
                Object o = jsonObject.get("Data").getAsJsonObject();
                if (o != null)
                    paseData(o);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
