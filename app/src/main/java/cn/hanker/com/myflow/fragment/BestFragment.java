package cn.hanker.com.myflow.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.Map;

import cn.hanker.com.myflow.Entity.BannerEntity;
import cn.hanker.com.myflow.NetUtils.RetrofitUtils;
import cn.hanker.com.myflow.R;
import cn.hanker.com.myflow.adapter.NetImageViewHolder;
import cn.hanker.com.myflow.api.ApiConfig;
import cn.hanker.com.myflow.api.RequestParamsUtils;
import cn.hanker.com.myflow.utils.CommonUtils;
import cn.hanker.com.myflow.utils.Logger;
import cn.hanker.com.myflow.utils.ScreenUtils;
import cn.hanker.com.myflow.utils.ToastUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @auther jh
 * @des 精选页面
 * Created by J.H on 2017/3/19.
 */

public class BestFragment extends BaseFragment {

//    @BindView(R.id.convenientBanner)
    ConvenientBanner convenientBanner;
    private Map<String, Object> banner_params = null;

    private ArrayList<String> imageUrls = null;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, null);
        View view = View.inflate(mMainActivity, R.layout.fragment_best, null);
//        ButterKnife.bind(this, view);

        setTitle(R.string.title_jingxuan);
        setImgBackVisible(0);
        getContentLayout().addView(view);

        convenientBanner = (ConvenientBanner) view.findViewById(R.id.convenientBanner);

        initData();


//        ButterKnife.bind(this, rootView);
        return rootView;

    }

    private void initData() {
        getBanner();

    }

    @Override
    public void onResume() {
        super.onResume();
        convenientBanner.startTurning(3000);
    }

    @Override
    public void onPause() {
        super.onPause();
        convenientBanner.stopTurning();
    }

    private void getBanner() {
        banner_params = RequestParamsUtils.getBannerParams(0, ScreenUtils.getScreenWidth(getActivity()), ScreenUtils.getScreenHeight(getActivity()), CommonUtils.getTime());

        Call<BannerEntity> call = RetrofitUtils.getInstance().getBanner(banner_params);

        call.enqueue(new Callback<BannerEntity>() {
            @Override
            public void onResponse(Call<BannerEntity> call, Response<BannerEntity> response) {
                Logger.d(ApiConfig.APP_TAG, response.toString());
                try {
                    BannerEntity entity = response.body();
                    imageUrls = new ArrayList<String>();
                    if (entity.getCode() == 0) {


                        for (int i = 0; i < entity.getData().getItems().size(); i++) {
                            imageUrls.add(entity.getData().getItems().get(i).getImageurl());


                        }
                        pullBanner();


                    }else{
                        ToastUtils.showLong(getActivity(), entity.getMessage());
                        imageUrls.add("http://bank.wo.cn/public/actimage/20170320095415.jpg");
                        imageUrls.add("http://bank.wo.cn/public/actimage/20170117105807.png");
                        imageUrls.add("http://bank.wo.cn/public/actimage/20170317154211.png");
                        imageUrls.add("http://bank.wo.cn/public/actimage/20170317152743.jpg");
                        pullBanner();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<BannerEntity> call, Throwable t) {
                Logger.d(ApiConfig.APP_TAG, t.toString());
            }
        });


    }

    private void pullBanner() {
        convenientBanner.setPages(new CBViewHolderCreator<NetImageViewHolder>() {
            @Override
            public NetImageViewHolder createHolder() {
                return new NetImageViewHolder();
            }
        }, imageUrls)
                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);

        convenientBanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                ToastUtils.showLong(getActivity(), "您翻到了"+position+"页");
            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });


        convenientBanner.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                ToastUtils.showLong(getActivity(), "您点击了"+position+"页");

            }
        });


    }


}
