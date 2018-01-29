package com.gs.gscartoon.zhijia.view;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gs.gscartoon.R;
import com.gs.gscartoon.manman.ManManContract;
import com.gs.gscartoon.utils.AppConstants;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.widget.view.refresh.JFengRefreshLayout;
import com.gs.gscartoon.widget.view.refresh.JFengRefreshListener;
import com.gs.gscartoon.zhijia.ZhiJiaContract;
import com.gs.gscartoon.zhijia.adapter.ZhiJiaListRecyclerAdapter;
import com.gs.gscartoon.zhijia.bean.ZhiJiaListBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ZhiJiaFragment extends Fragment implements ZhiJiaContract.View,
        JFengRefreshListener {
    private final static String TAG = "ZhiJiaFragment";

    @BindView(R.id.jfrl_zhi_jia_list_refresh_layout)
    JFengRefreshLayout mRefreshLayout;
    @BindView(R.id.jfrl_zhi_jia_empty_refresh_layout)
    JFengRefreshLayout mEmptyRefreshLayout;
    @BindView(R.id.rv_zhi_jia_data_list)
    RecyclerView mRecyclerView;
    @BindView(R.id.ll_empty)
    LinearLayout llEmpty;
    @BindView(R.id.tv_empty_title)
    TextView tvEmptyTitle;

    private ZhiJiaContract.Presenter mPresenter;
    private ZhiJiaListRecyclerAdapter mRecyclerAdapter;
    private boolean isLoading = false;
    private int clickPosition = 0;
    private int mPage = 1;//加载到第几页

    public ZhiJiaFragment() {

    }

    public static ZhiJiaFragment newInstance(/*int myVideo, String categories*/) {
        ZhiJiaFragment fragment = new ZhiJiaFragment();
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
        View view = inflater.inflate(R.layout.fragment_zhi_jia, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRefreshLayout.setRefreshDataView(mRecyclerView);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.startRefresh();
        mEmptyRefreshLayout.setOnRefreshListener(this);
    }

    public void initView(){
        mRecyclerAdapter = new ZhiJiaListRecyclerAdapter(this.getActivity());
        mRecyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(), 3, GridLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerAdapter.setClickListener(new ZhiJiaListRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                clickPosition = position;
                LogUtil.i(TAG,"点击item position="+position);
                ZhiJiaListBean bean = mRecyclerAdapter.getItemData(position);
                if(bean == null){
                    return;
                }
                Intent intent = new Intent(ZhiJiaFragment.this.getActivity(), ZhiJiaDetailsActivity.class);
                ImageView imageView = view.findViewById(R.id.iv_cover);
                BitmapDrawable mDrawable =  (BitmapDrawable) imageView.getDrawable();
                intent.putExtra(AppConstants.COMIC_ID, bean.getId()+"");
                intent.putExtra(AppConstants.ZHI_JIA_COVER_BITMAP, mDrawable.getBitmap());
                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),
                                imageView, getString(R.string.transition_name_zhi_jia_cover));
                startActivity(intent, options.toBundle());
            }
        });
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
    public void setPresenter(ZhiJiaContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onLoad() {
        if(!isLoading) {
            LogUtil.i(TAG,"onLoad mPage=" + mPage);
            mPresenter.loadData(mPage);
            isLoading = true;
        }else {
            LogUtil.i(TAG,"正在加载");
        }
    }

    @Override
    public void onRefresh() {
        mPage = 1;//每次刷新重置加载页数
        mPresenter.refreshData();
    }

    @Override
    public void hideRefreshProgress(){
        if(mRefreshLayout != null) {
            mRefreshLayout.setRefreshing(false);
        }
        if(mEmptyRefreshLayout != null){
            mEmptyRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void setLoading(boolean loading) {
        isLoading = loading;
    }

    @Override
    public void showRefreshData(List<ZhiJiaListBean> mData){
        mRecyclerAdapter.clear();
        mRecyclerAdapter.addItems(mData);
        mRecyclerAdapter.notifyDataSetChanged();
        if(mRecyclerAdapter.getItemCount() < 1){
            if(tvEmptyTitle != null){
                tvEmptyTitle.setText(getString(R.string.data_is_empty));
            }
            dataIsEmpty();
        }else {
            dataIsNotEmpty();
        }
    }

    @Override
    public void refreshDataFailure(){
        if(mRecyclerAdapter != null) {
            if (mRecyclerAdapter.getItemCount() < 1) {
                if(tvEmptyTitle != null) {
                    tvEmptyTitle.setText(getString(R.string.access_network_error));
                }
                dataIsEmpty();
            } else {
                dataIsNotEmpty();
            }
        }
    }

    @Override
    public void showLoadData(List<ZhiJiaListBean> mData) {
        mRecyclerAdapter.addItems(mData);
        mRecyclerAdapter.notifyDataSetChanged();
        mPage++;//加载成功，页数加1
    }

    private void dataIsEmpty(){
        if(llEmpty != null && mRefreshLayout != null
                && mEmptyRefreshLayout != null) {
            llEmpty.setVisibility(View.VISIBLE);
            mEmptyRefreshLayout.setVisibility(View.VISIBLE);
            mRefreshLayout.setVisibility(View.GONE);
        }
    }

    private void dataIsNotEmpty(){
        if(llEmpty != null && mRefreshLayout != null
                && mEmptyRefreshLayout != null) {
            llEmpty.setVisibility(View.GONE);
            mEmptyRefreshLayout.setVisibility(View.GONE);
            mRefreshLayout.setVisibility(View.VISIBLE);
        }
    }
}
