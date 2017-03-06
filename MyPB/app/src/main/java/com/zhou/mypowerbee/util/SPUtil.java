package com.zhou.mypowerbee.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by zhou on 17-3-3.
 */

public class SPUtil {
    //用户uuid
    private static final String UUID = "uuid";
    private static final String TOKEN = "token";
    private static SPUtil spUtil;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private SPUtil() {
    }

    private static void initSyncClient() {
        if (spUtil == null)
            spUtil = new SPUtil();
    }

    public static SPUtil getSpUtil() {
        if (spUtil == null)
            initSyncClient();
        return spUtil;
    }

    public void init(String spName, Context context) {
        sharedPreferences = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.apply();
    }

    /**
     * 设置用户uuid
     *
     * @param uuid
     */
    public void putUUID(String uuid) {
        putString(UUID, uuid);
    }

    public String getUuid() {
        return getString(UUID, null);
    }

    public String getToken() {
        return getString(TOKEN, null);
    }

    /**
     * 保存token
     *
     * @param token
     */
    public void putToken(String token) {
        putString(TOKEN, token);
    }

    /**
     * 存储字符串
     *
     * @param key
     * @param value
     */
    public void putString(String key, String value) {
        editor.putString(key, value);
        editor.apply();
    }

    public void putInt(String key, int value) {
        editor.putInt(key, value);
    }

    public String getString(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    public int getInt(String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }
}
