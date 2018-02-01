package com.example.ch_wangling.mvp_login_offline.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ch_wangling.mvp_login_offline.MainActivity;
import com.example.ch_wangling.mvp_login_offline.R;
import com.example.ch_wangling.mvp_login_offline.presenter.LoginPresenter;
import com.example.ch_wangling.mvp_login_offline.presenter.LoginPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by CH_WangLing on 2018/1/31.
 *
 * activity一般做加载UI视图，设置监听，持有相应presenter的引用
 */

public class LoginActivity extends AppCompatActivity implements LoginView,View.OnClickListener{

    @BindView(R.id.et_username)
    EditText ett_username;
    @BindView(R.id.et_password)
    EditText ett_password;
    @BindView(R.id.btn_login)
    Button button_login;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //引入butterknife
        ButterKnife.bind(this);

        button_login.setOnClickListener(this);

        //这里引入了presenter，LoginPresenterImpl才是实现所有逻辑的地方
        presenter = new LoginPresenterImpl(this);
    }

    //从presenter引入销毁机制
    @Override
    protected void onDestroy(){
        presenter.onDestroy();
        super.onDestroy();
    }

    //这里继承的是LoginView里面的方法，主要处理一些界面显示的，与逻辑无关
    @Override
    public void setUsernameNull(){
        ett_username.setError("输入用户名为空");
    }

    @Override
    public void setPasswordNull(){
        ett_password.setError("输入密码为空");
    }

    @Override
    public void setUsernameError(){
        ett_username.setError("输入用户名有错误");
    }

    @Override
    public void setPasswordError(){
        ett_password.setError("输入密码错误");
    }

    //这里还是依然继承的LoginView里面的方法，还是做UI上面界面跳转，弹出toast的操作
    @Override
    public void Login_Success(){
        startActivity(new Intent(this, MainActivity.class));
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    //这里button的点击事件引入了presenter里面的方法，来获取输入的数据
    @Override
    public void onClick(View v){
        presenter.ValidateCredentials(ett_username.getText().toString(),ett_password.getText().toString());
    }
}
