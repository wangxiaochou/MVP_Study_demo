package com.example.ch_wangling.mvp_login_offline.presenter;

/**
 * Created by CH_WangLing on 2018/1/31.
 *
 * 登录的监听事件，具体在LoginPresenterImpl里面实现
 */

public interface OnLoginFinishedListener {

    void onUsernameError();

    void onPasswordError();

    void onUsernameNull();

    void onPasswordNull();

    void onSuccess();
}
