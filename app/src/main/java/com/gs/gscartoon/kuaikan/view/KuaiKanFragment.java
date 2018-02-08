package com.gs.gscartoon.kuaikan.view;

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

import com.gs.gscartoon.GsApplication;
import com.gs.gscartoon.R;
import com.gs.gscartoon.kuaikan.KuaiKanContract;
import com.gs.gscartoon.kuaikan.model.KuaiKanListModel;
import com.gs.gscartoon.kuaikan.presenter.KuaiKanListPresenter;
import com.gs.gscartoon.utils.TimeUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;


public class KuaiKanFragment extends Fragment implements KuaiKanContract.View{
    private final static String TAG = "KuaiKanFragment";

    @BindView(R.id.vp_viewpager)
    ViewPager vpViewPager;
    @BindView(R.id.tl_tabs)
    TabLayout tlTabLayout;

    private ViewPagerAdapter mViewPagerAdapter;
    private ArrayList<String> mWeek = null;
    private ArrayList<String> mWeekTimeStamp;//每天的时间戳，用于拼接链接
    private KuaiKanContract.Presenter mPresenter;

    public KuaiKanFragment() {

    }

    public static KuaiKanFragment newInstance(/*int myVideo, String categories*/) {
        KuaiKanFragment fragment = new KuaiKanFragment();
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
        View view = inflater.inflate(R.layout.fragment_kuai_kan, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void initView(){
        mWeek = new ArrayList<String>();
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < 7; i++) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("EE");
            mWeek.add(dateFormat.format(calendar.getTime()));
            calendar.add(Calendar.DATE, -1);
        }

        mViewPagerAdapter = new ViewPagerAdapter(this.getActivity().getSupportFragmentManager());
        vpViewPager.setAdapter(mViewPagerAdapter);
        vpViewPager.setCurrentItem(mViewPagerAdapter.getCount()-1);
        //Viewpager和Tablayout进行关联
        tlTabLayout.setupWithViewPager(vpViewPager);
        //用于多TAB，Tablayout可以滚动
        //tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //Tablayout不可以滚动
        tlTabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        int pageCount = 0;

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
            if(mWeek != null){
                pageCount = mWeek.size();
            }
        }

        @Override
        public Fragment getItem(int position) {
            mWeekTimeStamp = TimeUtil.getWeekTimeStamp();
            String timestamp;
            if(position == 6){//今天
                timestamp = 0+"";
            }else if(position == 5){//昨天
                timestamp = 1+"";
            }else {
                timestamp = mWeekTimeStamp.get(mWeekTimeStamp.size() - position - 1);
            }
            KuaiKanListFragment mFragment = KuaiKanListFragment.newInstance(timestamp);
            KuaiKanListPresenter mPresenter = new KuaiKanListPresenter(
                    new KuaiKanListModel(GsApplication.getAppContext()), mFragment);
            return mFragment;
        }

        @Override
        public int getCount() {
            return pageCount;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title = "";
            if(position == pageCount-1){
                title="今天";
            }else if(position == pageCount-2){
                title="昨天";
            }else {
                if(mWeek != null && position < mWeek.size()){
                    title=mWeek.get(pageCount-position-1);
                }
            }
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
    public void setPresenter(KuaiKanContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
