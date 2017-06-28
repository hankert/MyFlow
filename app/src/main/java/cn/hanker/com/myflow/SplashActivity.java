package cn.hanker.com.myflow;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import cn.hanker.com.myflow.activity.LoginActivity;

/**
 * 启动页
 */
public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.splash)
    ImageView img_splash;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            finish();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
               mHandler.sendEmptyMessage(0);

            }
        }, 3000);
    }
}
