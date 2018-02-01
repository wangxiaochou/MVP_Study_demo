package com.example.ch_wangling.mvp_login_offline.presenter;

import com.example.ch_wangling.mvp_login_offline.model.LoginModel;
import com.example.ch_wangling.mvp_login_offline.model.LoginModelImpl;
import com.example.ch_wangling.mvp_login_offline.view.LoginView;

/**
 * Created by CH_WangLing on 2018/2/1.
 *
 * 完成presenter的实现，主要是model层和view层的交互和操作
 * presenter里面还有一个OnLoginFinishedListener，在presenter层实现，给model层回调，更改view层状态
 * 确保model层不直接操作view层
 */

public class LoginPresenterImpl implements LoginPresenter,OnLoginFinishedListener{

    private LoginView loginView;
    private LoginModel loginModel;

    //引入view层和model层
    public LoginPresenterImpl(LoginView loginView){
        this.loginView = loginView;
        this.loginModel = new LoginModelImpl();
    }

    @Override
    public void ValidateCredentials(String username ,String password){
        if(loginView != null){

        }
        //这里引入了model层的东西
        loginModel.login(username,password,this);
    }

    @Override
    public void onDestroy(){
        loginView = null;
    }

    //这里是presenter借口，引入view层的操作
    @Override
    public void onUsernameNull(){
        if (loginView != null){
            loginView.setUsernameNull();
        }
    }

    @Override
    public void onPasswordNull(){
        if (loginView != null){
            loginView.setPasswordNull();
        }
    }

    @Override
    public void onUsernameError(){
        if (loginView != null){
            loginView.setUsernameError();
        }
    }

    @Override
    public void onPasswordError(){
        if (loginView != null){
            loginView.setPasswordError();
        }
    }

    @Override
    public void onSuccess(){
        if (loginView != null){
            loginView.Login_Success();
        }
    }
}
