package cn.hanker.com.myflow.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.hanker.com.myflow.R;

/**
 * @auther jh
 * @des 我的页面
 * Created by J.H on 2017/3/19.
 */

public class MineFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, null);
        View view = View.inflate(mMainActivity, R.layout.fragment_wallet, null);

        setTitle(R.string.title_mine);
        setImgBackVisible(0);
        getContentLayout().addView(view);


        return rootView;

    }


}
