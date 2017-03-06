package com.example.zhou.mypowerbee.app;

import com.example.zhou.mypowerbee.util.SPUtil;

/**
 * Created by zhou on 17-3-3.
 */

public class MyGlobal {
    private static MyGlobal myGlobal;
    private SPUtil spUtil;

    private MyGlobal() {
    }

    public static MyGlobal getMyGlobal() {
        return myGlobal;
    }

    public SPUtil getSPUtil(){
        return spUtil;
    }
}
