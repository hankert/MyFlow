package cn.hanker.com.myflow.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.adapter.recyclerview.wrapper.LoadMoreWrapper;

import java.util.ArrayList;
import java.util.List;

import cn.hanker.com.myflow.R;
import cn.hanker.com.myflow.baserecycleview.DividerItemDecoration;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/5/10.
 */

public class TestActivity extends Activity {

//
//    @BindView(R.id.swipelayout)
     private SwipeRefreshLayout swipeRefreshLayout;
//    @BindView(R.id.recyclerview)
   private  RecyclerView recyclerView;
    private CommonAdapter<String> mAdapter;

    private List<String> mDatas = new ArrayList<>();

    private LoadMoreWrapper mLoadMoreWrapper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        initView();
        initData();

    }

    private void initView(){
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipelayout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

    }

    private void initData(){
        mDatas.add("0");
        mDatas.add("1");
        mDatas.add("2");
        mDatas.add("3");
        mDatas.add("3");
        mDatas.add("3");
        mDatas.add("3");
        mDatas.add("3");
        mDatas.add("3");
        mDatas.add("3");

        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light, android.R.color.holo_orange_light,
                android.R.color.holo_green_light);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {

//                ToastUtils.showShort(TestActivity.this, "正在刷新");
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        mDatas.clear();
//                        for (int i = 0; i < 10; i++)
//                        {
//
//                            mDatas.add("下拉刷新后" + i);
//                        }
//                        mLoadMoreWrapper.notifyDataSetChanged();
//                        Toast.makeText(TestActivity.this, "刷新完成", 2000).show();
//                        swipeRefreshLayout.setRefreshing(false);
//                    }
//                }, 3000);






            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        mAdapter = new CommonAdapter<String>(this, R.layout.item_list, mDatas)
        {
            @Override
            protected void convert(ViewHolder holder, String s, int position)
            {
                holder.setText(R.id.id_item_list_title, s + " : " + holder.getAdapterPosition() + " , " + holder.getLayoutPosition());
            }
        };
        mLoadMoreWrapper = new LoadMoreWrapper(mAdapter);
        mLoadMoreWrapper.setLoadMoreView(R.layout.default_loading);
        mLoadMoreWrapper.setOnLoadMoreListener(new LoadMoreWrapper.OnLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                new Handler().postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        for (int i = 0; i < 10; i++)
                        {
                            mDatas.add("Add:" + i);
                        }
                        mLoadMoreWrapper.notifyDataSetChanged();

                    }
                }, 3000);
            }
        });
        recyclerView.setAdapter(mLoadMoreWrapper);
    }
}
