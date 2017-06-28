package cn.hanker.com.myflow.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.hanker.com.myflow.Entity.UserEntity;
import cn.hanker.com.myflow.NetUtils.RetrofitUtils;
import cn.hanker.com.myflow.R;
import cn.hanker.com.myflow.api.ApiConfig;
import cn.hanker.com.myflow.api.RequestParamsUtils;
import cn.hanker.com.myflow.api.SPKeyWord;
import cn.hanker.com.myflow.utils.Logger;
import cn.hanker.com.myflow.utils.SPUtils;
import cn.hanker.com.myflow.utils.ToastUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @auther jh
 * @des 登录页面
 * Created by J.H on 2017/3/16.
 */

public class LoginActivity extends Activity {

    @BindView(R.id.btn_login)
    Button btn_login;
    @BindView(R.id.et_password)
    EditText et_password;
    @BindView(R.id.et_username)
    EditText et_username;

    private Map<String, String> map_login = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(LoginActivity.this);

    }

    @OnClick(R.id.btn_login)
    public void login(){
//        Toast.makeText(this, "ceshi", Toast.LENGTH_LONG).show();
        String username = et_username.getText().toString().trim();
        String password = et_password.getText().toString().trim();

        ToastUtils.showShort(this, "test");
        map_login = RequestParamsUtils.getLoginRequestParams(username, password);
//        map_login = new LoginRequest(username, password).genParametersMap();

        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
//        realLogin();

    }

    private void realLogin()
    {
       Call<UserEntity> call = RetrofitUtils.getInstance().getLogin(map_login);

       call.enqueue(new Callback<UserEntity>() {
           @Override
           public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
               Logger.d(ApiConfig.APP_TAG, response.toString());
               UserEntity userEntity = response.body();
               if(userEntity.getCode()!=0){
                   ToastUtils.showLong(LoginActivity.this, userEntity.getMessage());
                   startActivity(new Intent(LoginActivity.this, MainActivity.class));
               }
               Logger.d(ApiConfig.APP_TAG, userEntity.toString());
               if(userEntity.getCode() == 0){
                   startActivity(new Intent(LoginActivity.this, MainActivity.class));
                   saveUserInfo(userEntity);
                   finish();

               }

           }

           @Override
           public void onFailure(Call<UserEntity> call, Throwable t) {
               Logger.d(ApiConfig.APP_TAG, t.toString());

           }
       });


    }

    private void saveUserInfo(UserEntity entity) {

        SPUtils.put(this, SPKeyWord.APP_TOKEN, entity.getData().getToken());


    }

}
