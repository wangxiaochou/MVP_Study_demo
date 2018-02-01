package com.example.ch_wangling.mvp_login_offline.model;

import android.os.Handler;
import android.text.TextUtils;

import com.example.ch_wangling.mvp_login_offline.presenter.OnLoginFinishedListener;

/**
 * Created by CH_WangLing on 2018/1/31.
 */

public class LoginModelImpl implements LoginModel{

    @Override
    public void login(final String username,final String password,final OnLoginFinishedListener listener){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(username)){
                    listener.onUsernameNull();
                    error = true;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordNull();
                    error = true;
                }
                if (!username.equals("小草莓")){
                    listener.onUsernameError();
                    error = true;
                }
                if (!password.equals("0319")){
                    listener.onPasswordError();
                    error = true;
                }
                if (!error){
                    listener.onSuccess();
                }
            }
        },0);
    }
}
