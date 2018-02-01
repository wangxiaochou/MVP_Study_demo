package com.example.ch_wangling.mvp_login_offline.presenter;

/**
 * Created by CH_WangLing on 2018/2/1.
 *
 * 登录的presenter接口，实现的具体类为LoginPresenterImpl，完成登录的验证，以及销毁当前的view
 *
 * 这里面只有两个方法，在view层调用
 */

public interface LoginPresenter {

    void ValidateCredentials(String username,String password);

    void onDestroy();
}
