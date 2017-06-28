package cn.hanker.com.myflow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import cn.hanker.com.myflow.R;

/**
 * @auther jh
 * @des activity基类
 * Created by J.H on 2017/3/19.
 */

public class BaseActivity extends FragmentActivity {


    //    @BindView(R.id.img_back)
    ImageView imgBack;
    //    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.layout_title);

        imgBack = (ImageView) findViewById(R.id.img_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);

//        ButterKnife.bind(this);
    }

//    @OnClick(R.id.img_back)
//    public void back() {
//        finish();
//    }

    public void setImgBackVisible() {
        imgBack.setVisibility(View.GONE);

    }

    public void setTitle(int resourceId) {
        tvTitle.setText(resourceId);
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    @Override
    public void startActivity(Intent intent) {
        overridePendingTransition(R.anim.activity_right_in, R.anim.activity_left_out);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_left_in, R.anim.activity_right_out);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
