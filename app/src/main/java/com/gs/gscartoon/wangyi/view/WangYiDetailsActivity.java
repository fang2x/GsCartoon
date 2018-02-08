package com.gs.gscartoon.wangyi.view;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gs.gscartoon.GsApplication;
import com.gs.gscartoon.R;
import com.gs.gscartoon.utils.AppConstants;
import com.gs.gscartoon.utils.StatusBarUtil;
import com.gs.gscartoon.utils.StringUtil;
import com.gs.gscartoon.utils.TimeUtil;
import com.gs.gscartoon.utils.ToolbarUtil;
import com.gs.gscartoon.wangyi.WangYiDescriptionContract;
import com.gs.gscartoon.wangyi.WangYiDetailsContract;
import com.gs.gscartoon.wangyi.WangYiSectionContract;
import com.gs.gscartoon.wangyi.bean.WangYiDetailsBean;
import com.gs.gscartoon.wangyi.model.WangYiDetailsModel;
import com.gs.gscartoon.wangyi.model.WangYiSectionModel;
import com.gs.gscartoon.wangyi.presenter.WangYiDescriptionPresenter;
import com.gs.gscartoon.wangyi.presenter.WangYiDetailsPresenter;
import com.gs.gscartoon.wangyi.presenter.WangYiSectionPresenter;
import com.gs.gscartoon.widget.view.MarqueTextView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class WangYiDetailsActivity extends AppCompatActivity
        implements WangYiDetailsContract.View{
    private static final String TAG = "WangYiDetailsActivity";

    @BindView(R.id.tb_kuai_kan_all_chapter)
    Toolbar tbToolbar;
    @BindView(R.id.iv_cover)
    ImageView ivCover;
    @BindView(R.id.mtv_title)
    MarqueTextView mtvTitle;
    @BindView(R.id.tv_label)
    TextView tvLabel;
    @BindView(R.id.tv_view_count)
    TextView tvViewCount;
    @BindView(R.id.vp_wang_yi_details_viewpager)
    ViewPager vpViewPager;
    @BindView(R.id.tl_wang_yi_details_tabs)
    TabLayout tlTabLayout;

    private static final int FRAGMENT_COUNT = 2;

    private WangYiDetailsContract.Presenter mPresenter;

    private WangYiDescriptionContract.Presenter mDescriptionPresenter;
    private WangYiDescriptionFragment mDescriptionFragment;
    private WangYiSectionContract.Presenter mSectionPresenter;
    private WangYiSectionFragment mSectionFragment;

    private ViewPagerAdapter mViewPagerAdapter;
    private Unbinder unbinder;
    private String mComicId;//漫画Id

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wang_yi_details);

        //setupWindowAnimations();
        StatusBarUtil.enableTranslucentStatusBar(this);
        unbinder = ButterKnife.bind(this);
        initView();
    }

    private void initView(){
        ToolbarUtil.initToolbar(this, tbToolbar);

        mComicId = getIntent().getStringExtra(AppConstants.COMIC_ID);

        // Create the presenter
        new WangYiDetailsPresenter(
                new WangYiDetailsModel(getApplicationContext()), this);

        mViewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        vpViewPager.setAdapter(mViewPagerAdapter);
        vpViewPager.setCurrentItem(mViewPagerAdapter.getCount()-1);
        tlTabLayout.setupWithViewPager(vpViewPager);
        tlTabLayout.setTabMode(TabLayout.MODE_FIXED);//Tablayout不可以滚动
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0://详情
                    if(mDescriptionFragment == null){
                        mDescriptionFragment = WangYiDescriptionFragment.newInstance();
                    }
                    if(mDescriptionPresenter == null){
                        mDescriptionPresenter = new WangYiDescriptionPresenter(
                                mDescriptionFragment);
                    }
                    fragment = mDescriptionFragment;
                    break;
                case 1://目录
                    if(mSectionFragment == null){
                        mSectionFragment = WangYiSectionFragment.newInstance();
                    }
                    if(mSectionPresenter == null){
                        mSectionPresenter = new WangYiSectionPresenter(
                                new WangYiSectionModel(GsApplication.getAppContext()), mSectionFragment);
                    }
                    fragment = mSectionFragment;
                    break;
                default:
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return FRAGMENT_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String stringPageTitle = null;
            switch (position) {
                case 0://详情
                    stringPageTitle = "详情";
                    break;
                case 1://目录
                    stringPageTitle = "目录";
                    break;
                default:
                    break;
            }
            return stringPageTitle;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //如果注释这行，那么不管怎么切换，page都不会被销毁
            //super.destroyItem(container, position, object);
        }
    }

    private void setupWindowAnimations() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition transition = TransitionInflater.from(this)
                    .inflateTransition(R.transition.activity_explode);
            getWindow().setEnterTransition(transition);

            transition = TransitionInflater.from(this)
                    .inflateTransition(R.transition.activity_slide_left);
            getWindow().setExitTransition(transition);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getDetails(mComicId);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        mPresenter.destroy();
    }

    @Override
    public void setPresenter(WangYiDetailsContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        if(item.getItemId() == android.R.id.home) {
            finishAfterTransition();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void updateDetails(WangYiDetailsBean bean) {
        if(bean == null || ivCover == null || mtvTitle == null ||
                tvLabel == null || tvViewCount == null){
            return;
        }
        WangYiDetailsBean.DataBean dataBean = bean.getData();
        if(dataBean == null){
            return;
        }

        Picasso.with(this).load(dataBean.getRecCover()).placeholder(R.drawable.ic_wangyi_default_image)
                .error(R.drawable.ic_wangyi_default_image)
                .into(ivCover);
        mtvTitle.setText(dataBean.getTitle());
        tvLabel.setText(dataBean.getKeyWords());
        tvViewCount.setText("总热度" + StringUtil.getPrintHugeNumber(dataBean.getHit()));

        mDescriptionPresenter.getDetails(bean);
        mSectionPresenter.getDetails(bean);
    }

    @Override
    public void getDetailsFailure() {

    }
}
