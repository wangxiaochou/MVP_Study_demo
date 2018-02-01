package com.example.ch_wangling.mvp_login_offline.view;

/**
 * Created by CH_WangLing on 2018/1/31.
 *
 * 登录view的接口，实现的类在登录的activity
 */

public interface LoginView {

    void setUsernameNull();

    void setPasswordNull();

    void setUsernameError();

    void setPasswordError();

    void Login_Success();
}
