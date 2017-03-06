package com.example.zhou.mypowerbee.common;

/**
 * Created by zhou on 17-2-24.
 */

public interface BaseView<T> {
    void setPersenter(T persenter);

    interface BaseViewDialog<T> extends BaseView<T> {
        void showDialog();

        void closeDialog();
    }
}
