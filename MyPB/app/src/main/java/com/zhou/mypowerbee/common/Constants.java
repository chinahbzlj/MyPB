package com.zhou.mypowerbee.common;

import com.zhou.mypowerbee.sdk.netlog.NetConfigFile;

/**
 * Created by zhou on 17-2-27.
 */

public class Constants {
    private static final String TEST_HOST = "http://" + NetConfigFile.SERVER_HTTP_IP + ":" + NetConfigFile.SERVER_HTTP_PORT + "/";
    public static final String BASE_URL = TEST_HOST;
    public static final String VERIFYCODE_URL = BASE_URL + "user/verifycode/";
    public static final int SUCCESS_CODE = 0;
}
