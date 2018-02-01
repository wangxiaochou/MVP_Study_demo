package com.example.ch_wangling.mvp_login_offline.model;

import com.example.ch_wangling.mvp_login_offline.presenter.OnLoginFinishedListener;

/**
 * Created by CH_WangLing on 2018/1/31.
 * 模拟登陆操作的接口，实际实现的类为LoginModelImpl，处在MVP模式中的model层
 */

public interface LoginModel {

    void login(String username,String password,OnLoginFinishedListener listener);
}
