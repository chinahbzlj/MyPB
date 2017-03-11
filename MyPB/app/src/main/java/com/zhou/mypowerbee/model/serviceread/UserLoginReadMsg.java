package com.zhou.mypowerbee.model.serviceread;

/**
 * Created by zhou on 17-3-7.
 */

public class UserLoginReadMsg extends ServiceReadBase {
    public String name;
    public String userId;
    public String token;
    public String nick;
    public String ipAddress;
    public String password;
    public int port;

    public UserLoginReadMsg(String userid, String token) {
        this.userId = userid;
        this.token = token;
    }

    public UserLoginReadMsg(String userid, String token, String name) {
        this.userId = userid;
        this.token = token;
        this.name = name;
    }
}
