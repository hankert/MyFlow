package cn.hanker.com.myflow.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.hanker.com.myflow.R;
import cn.hanker.com.myflow.fragment.BaseFragment;
import cn.hanker.com.myflow.fragment.BestFragment;
import cn.hanker.com.myflow.fragment.FindFragment;
import cn.hanker.com.myflow.fragment.MineFragment;
import cn.hanker.com.myflow.fragment.MoreFragment;
import cn.hanker.com.myflow.fragment.WalletFragment;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/3/15.
 */

public class MainActivity extends BaseActivity {


    @BindView(R.id.vp_content)
    ViewPager vpContent;
    @BindView(R.id.rg_group)
    RadioGroup rgGroup;
    @BindView(R.id.rb_wallet)
    RadioButton rbWallet;
    @BindView(R.id.rb_find)
    RadioButton rbFind;
    @BindView(R.id.rb_jingxuan)
    RadioButton rbJingxuan;
    @BindView(R.id.rb_mine)
    RadioButton rbMine;
    @BindView(R.id.rb_more)
    RadioButton rbMore;

    private BaseFragment walletFragment;
    private BaseFragment findFragment;
    private BaseFragment bestFragment;
    private BaseFragment mineFragment;
    private BaseFragment moreFragment;

    private List<Fragment> mPagerList = new ArrayList<Fragment>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();
    }

    private void initData() {


        walletFragment = new WalletFragment();
        findFragment = new FindFragment();
        bestFragment = new BestFragment();
        mineFragment = new MineFragment();
        moreFragment = new MoreFragment();

        mPagerList.add(walletFragment);
        mPagerList.add(findFragment);
        mPagerList.add(bestFragment);
        mPagerList.add(mineFragment);
        mPagerList.add(moreFragment);


        vpContent.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        setWalletSelect();

        rgGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_wallet:
                        setWalletSelect();
                        break;
                    case R.id.rb_find:
                        setFindSelect();
                        break;
                    case R.id.rb_jingxuan:
                        setBestSelect();
                        break;
                    case R.id.rb_mine:
                        setMineSelect();
                        break;
                    case R.id.rb_more:
                        setMoreSelect();
                        break;


                }

            }

        });

        vpContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        setWalletSelect();
                        break;
                    case 1:
                        setFindSelect();
                        break;
                    case 2:
                        setBestSelect();
                        break;
                    case 3:
                        setMineSelect();
                        break;
                    case 4:
                        setMoreSelect();
                        break;

                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void setMoreSelect() {
        vpContent.setCurrentItem(4);
        rbWallet.setSelected(false);
        rbFind.setSelected(false);
        rbJingxuan.setSelected(false);
        rbMine.setSelected(false);
        rbMore.setSelected(true);

    }

    private void setWalletSelect() {
        vpContent.setCurrentItem(0);
        rbWallet.setSelected(true);
        rbFind.setSelected(false);
        rbJingxuan.setSelected(false);
        rbMine.setSelected(false);
        rbMore.setSelected(false);

    }

    private void setFindSelect() {
        vpContent.setCurrentItem(1);
        rbWallet.setSelected(false);
        rbFind.setSelected(true);
        rbJingxuan.setSelected(false);
        rbMine.setSelected(false);
        rbMore.setSelected(false);

    }

    private void setBestSelect() {
        vpContent.setCurrentItem(2);
        rbWallet.setSelected(false);
        rbFind.setSelected(false);
        rbJingxuan.setSelected(true);
        rbMine.setSelected(false);
        rbMore.setSelected(false);

    }

    private void setMineSelect() {
        vpContent.setCurrentItem(3);
        rbWallet.setSelected(false);
        rbFind.setSelected(false);
        rbJingxuan.setSelected(false);
        rbMine.setSelected(true);
        rbMore.setSelected(false);

    }


    class MyPagerAdapter extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mPagerList.get(position);
        }

        @Override
        public int getCount() {
            return mPagerList.size();
        }
    }


}
