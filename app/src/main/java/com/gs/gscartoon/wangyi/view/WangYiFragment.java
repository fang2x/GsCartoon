package com.gs.gscartoon.wangyi.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gs.gscartoon.R;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.wangyi.WangYiContract;
import com.gs.gscartoon.wangyi.bean.WangYiCategoryBean;
import com.gs.gscartoon.wangyi.bean.WangYiCategoryBean.DataBean.CategoryBean;
import com.gs.gscartoon.wangyi.model.WangYiListModel;
import com.gs.gscartoon.wangyi.presenter.WangYiListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WangYiFragment extends Fragment implements WangYiContract.View{
    private final static String TAG = "WangYiFragment";

    @BindView(R.id.vp_wang_yi_viewpager)
    ViewPager vpViewPager;
    @BindView(R.id.tl_wang_yi_tabs)
    TabLayout tlTabLayout;

    private List<CategoryBean> mCategoryList = new ArrayList<>();
    private ViewPagerAdapter mViewPagerAdapter;
    private WangYiContract.Presenter mPresenter;

    public WangYiFragment() {

    }

    public static WangYiFragment newInstance(/*int myVideo, String categories*/) {
        WangYiFragment fragment = new WangYiFragment();
        /*Bundle args = new Bundle();
        args.putInt(MyVideoActivity.MY_VIDEO, myVideo);
        args.putString(AppConstants.CATEGORIES, categories);
        fragment.setArguments(args);*/
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //mMyVideo = getArguments().getInt(MyVideoActivity.MY_VIDEO,MyVideoActivity.ALL);
            //mCategories = getArguments().getString(AppConstants.CATEGORIES);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wang_yi, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.getCategory();
    }

    public void initView(){
        mViewPagerAdapter = new ViewPagerAdapter(this.getActivity().getSupportFragmentManager());
        vpViewPager.setAdapter(mViewPagerAdapter);
        tlTabLayout.setupWithViewPager(vpViewPager);//Viewpager和Tablayout进行关联
        tlTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);//用于多TAB，Tablayout可以滚动
    }

    @Override
    public void getCategorySuccess(WangYiCategoryBean bean) {
        if(bean == null || bean.getData() == null ||
                mViewPagerAdapter == null){
            LogUtil.e(TAG, "数据为空");
            return;
        }
        mCategoryList.clear();
        mCategoryList = bean.getData().getCategory();
        LogUtil.e(TAG,"mCategoryList "+bean.getData().getCategory().size());
        mViewPagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void getCategoryFailure() {

    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            WangYiListFragment mFragment = WangYiListFragment.newInstance(mCategoryList.get(position).getUrl());
            WangYiListPresenter mPresenter = new WangYiListPresenter(
                    new WangYiListModel(WangYiFragment.this.getActivity()), mFragment);
            return mFragment;
        }

        @Override
        public int getCount() {
            return mCategoryList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title = mCategoryList.get(position).getText();
            return title;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //如果注释这行，那么不管怎么切换，page都不会被销毁
            //super.destroyItem(container, position, object);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView(){
        super.onDestroy();
        mPresenter.destroy();
    }

    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE);
        }
    }

    @Override
    public void setPresenter(WangYiContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
