package com.example.zhou.mypowerbee.module.user;

import android.support.v4.app.Fragment;

import java.util.Stack;

/**
 * Created by zhou on 17-2-19.
 */

public class MyFragmentManager {
    private Stack<Fragment> stack = new Stack<Fragment>();
    private Fragment curFragment = null;
    private ICallBack iCallBack = null;

    public void setFragment(Fragment fragment) {
        if (fragment != null && fragment.getActivity() == null) {
            if (curFragment != null)
                stack.push(curFragment);
            curFragment = fragment;
            changFragment(fragment);
        }
    }

    private void changFragment(Fragment fragment) {
        if (iCallBack != null && fragment != null) {
            iCallBack.callback(fragment);
        }
    }

    public void setCallBack(ICallBack iCallBack) {
        this.iCallBack = iCallBack;
    }

    public void gotoBlack() {
        if (stack == null || stack.empty()) {
            iCallBack.callback(null);
            return;
        }

        Fragment tmpKeyFragment = stack.pop();
        curFragment = tmpKeyFragment;
        if (tmpKeyFragment != null)
            changFragment(curFragment);

    }


}
