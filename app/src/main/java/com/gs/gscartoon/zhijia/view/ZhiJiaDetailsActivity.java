package com.gs.gscartoon.zhijia.view;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gs.gscartoon.R;
import com.gs.gscartoon.utils.AppConstants;
import com.gs.gscartoon.utils.OkHttpUtil;
import com.gs.gscartoon.utils.PicassoRoundTransform;
import com.gs.gscartoon.utils.StatusBarUtil;
import com.gs.gscartoon.utils.TimeUtil;
import com.gs.gscartoon.utils.ToolbarUtil;
import com.gs.gscartoon.zhijia.ZhiJiaDescriptionContract;
import com.gs.gscartoon.zhijia.ZhiJiaDetailsContract;
import com.gs.gscartoon.zhijia.ZhiJiaSectionContract;
import com.gs.gscartoon.zhijia.bean.ZhiJiaDetailsBean;
import com.gs.gscartoon.zhijia.model.ZhiJiaDetailsModel;
import com.gs.gscartoon.zhijia.presenter.ZhiJiaDescriptionPresenter;
import com.gs.gscartoon.zhijia.presenter.ZhiJiaDetailsPresenter;
import com.gs.gscartoon.zhijia.presenter.ZhiJiaSectionPresenter;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.OkHttpClient;

public class ZhiJiaDetailsActivity extends AppCompatActivity
        implements ZhiJiaDetailsContract.View{
    private static final String TAG = "ZhiJiaDetailsActivity";

    @BindView(R.id.tb_zhi_jia_details)
    Toolbar tbToolbar;
    @BindView(R.id.tv_toolbar_zhi_jia_details_title)
    TextView tvTitle;
    @BindView(R.id.iv_cover)
    ImageView ivCover;
    @BindView(R.id.tv_author)
    TextView tvAuthor;
    @BindView(R.id.tv_label)
    TextView tvLabel;
    @BindView(R.id.tv_view_count)
    TextView tvViewCount;
    @BindView(R.id.tv_subscribe_count)
    TextView tvSubscribeCount;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.vp_viewpager)
    ViewPager vpViewPager;
    @BindView(R.id.tl_tabs)
    TabLayout tlTabLayout;

    private static final int FRAGMENT_COUNT = 2;

    private ZhiJiaDetailsContract.Presenter mPresenter;

    private ZhiJiaDescriptionContract.Presenter mDescriptionPresenter;
    private ZhiJiaDescriptionFragment mDescriptionFragment;
    private ZhiJiaSectionContract.Presenter mSectionPresenter;
    private ZhiJiaSectionFragment mSectionFragment;

    private ViewPagerAdapter mViewPagerAdapter;
    private Unbinder unbinder;
    private String mTopicId;//漫画Id
    private Picasso mPicasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhi_jia_details);

        StatusBarUtil.enableTranslucentStatusBar(this);
        unbinder = ButterKnife.bind(this);
        initView();

        mPresenter.getDetails(mTopicId);
    }

    private void initView(){
        ToolbarUtil.initToolbar(this, tbToolbar);

        mTopicId = getIntent().getStringExtra(AppConstants.TOPIC_ID);

        // Create the presenter
        new ZhiJiaDetailsPresenter(
                new ZhiJiaDetailsModel(getApplicationContext()), this);

        mViewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        vpViewPager.setAdapter(mViewPagerAdapter);
        vpViewPager.setCurrentItem(mViewPagerAdapter.getCount()-1);
        tlTabLayout.setupWithViewPager(vpViewPager);
        tlTabLayout.setTabMode(TabLayout.MODE_FIXED);//Tablayout不可以滚动

        OkHttpClient okHttpClient = OkHttpUtil.getHeaderOkHttpClientBuilder().build();
        mPicasso = new Picasso.Builder(this)
                .downloader(new OkHttp3Downloader(okHttpClient))
                .build();
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0://房源图片
                    if(mDescriptionFragment == null){
                        mDescriptionFragment = ZhiJiaDescriptionFragment.newInstance();
                    }
                    if(mDescriptionPresenter == null){
                        mDescriptionPresenter = new ZhiJiaDescriptionPresenter(
                                mDescriptionFragment);
                    }
                    fragment = mDescriptionFragment;
                    break;
                case 1://房源信息
                    if(mSectionFragment == null){
                        mSectionFragment = ZhiJiaSectionFragment.newInstance();
                    }
                    if(mSectionPresenter == null){
                        mSectionPresenter = new ZhiJiaSectionPresenter(
                                mSectionFragment);
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

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
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
    public void setPresenter(ZhiJiaDetailsContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        if(item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void updateDetails(ZhiJiaDetailsBean bean) {
        if(tvTitle == null || ivCover == null || tvAuthor == null ||
                tvLabel == null || tvViewCount == null || tvSubscribeCount == null ||
                tvTime == null){
            return;
        }

        tvTitle.setText(bean.getTitle());
        //sdvCover.setImageURI(Uri.parse(bean.getCover()));
        mPicasso.load(bean.getCover()).placeholder(R.drawable.ic_kuaikan_default_image_vertical)
                .error(R.drawable.ic_kuaikan_default_image_vertical)
                .into(ivCover);

        tvViewCount.setText("人气：" + bean.getHot_num());
        tvSubscribeCount.setText("订阅：" + bean.getSubscribe_num());

        if(bean.getAuthors() != null) {
            StringBuffer str = new StringBuffer();
            str.append("作者：");
            for (ZhiJiaDetailsBean.AuthorsBean authorsBean : bean.getAuthors()){
                str.append(authorsBean.getTag_name()+" ");
            }
            tvAuthor.setText(str);
        }

        if(bean.getTypes() != null) {
            StringBuffer str = new StringBuffer();
            str.append("类型：");
            for (ZhiJiaDetailsBean.TypesBean typesBean : bean.getTypes()){
                str.append(typesBean.getTag_name()+" ");
            }
            tvLabel.setText(str);
        }

        if(bean.getStatus() != null){
            StringBuffer str = new StringBuffer();
            str.append("更新：" + TimeUtil.timestampToDate(bean.getLast_updatetime())+" ");
            for (ZhiJiaDetailsBean.StatusBean statusBean : bean.getStatus()){
                str.append(statusBean.getTag_name()+" ");
            }
            tvTime.setText(str);
        }

        mDescriptionPresenter.getDetails(bean);
        mSectionPresenter.getDetails(bean);
    }

    @Override
    public void getDetailsFailure() {

    }
}
