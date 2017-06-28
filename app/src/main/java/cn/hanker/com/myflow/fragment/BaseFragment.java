package cn.hanker.com.myflow.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.hanker.com.myflow.R;
import cn.hanker.com.myflow.activity.MainActivity;

import static cn.hanker.com.myflow.R.id.img_back;

/**
 * @auther jh
 * @des fragment基类
 * Created by J.H on 2017/3/19.
 */

public class BaseFragment extends Fragment {

    @BindView(img_back)
    ImageView imgBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.layout_content)
    FrameLayout layoutContent;
    public MainActivity mMainActivity;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mMainActivity = (MainActivity) getActivity();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        getActivity().overridePendingTransition(R.anim.activity_right_in, R.anim.activity_left_out);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(mMainActivity, R.layout.fragment_base, null);
        ButterKnife.bind(this, view);

        return view;
    }


    @OnClick(img_back)
    public void back() {
        getActivity().finish();
    }

    /**
     * 设置左边的返回键是否显示
     * @param type  0 隐藏 1 显示
     */
    public void setImgBackVisible(int type) {
        if(type == 1){
            imgBack.setVisibility(View.VISIBLE);
        }else{
            imgBack.setVisibility(View.GONE);
        }

    }

    /**
     * 设置标题
     * @param resourceId
     */
    public void setTitle(int resourceId) {
        tvTitle.setText(resourceId);
    }

    /**
     * 设置标题
     * @param resourceId
     */
    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    public FrameLayout getContentLayout(){

        return layoutContent;

    }

}
