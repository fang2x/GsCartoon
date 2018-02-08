package com.gs.gscartoon.wangyi.view;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gs.gscartoon.R;
import com.gs.gscartoon.utils.AppConstants;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.utils.ToastUtil;
import com.gs.gscartoon.wangyi.WangYiListContract;
import com.gs.gscartoon.wangyi.adapter.WangYiListRecyclerAdapter;
import com.gs.gscartoon.widget.view.refresh.JFengRefreshLayout;
import com.gs.gscartoon.widget.view.refresh.JFengRefreshListener;
import com.gs.gscartoon.wangyi.bean.WangYiListBean.DataBean.BooksBean;
import com.gs.gscartoon.zhijia.view.ZhiJiaDetailsActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WangYiListFragment extends Fragment implements WangYiListContract.View,
        JFengRefreshListener {
    private final static String TAG = "WangYiListFragment";

    @BindView(R.id.jfrl_wang_yi_list_refresh_layout)
    JFengRefreshLayout mRefreshLayout;
    @BindView(R.id.jfrl_wang_yi_empty_refresh_layout)
    JFengRefreshLayout mEmptyRefreshLayout;
    @BindView(R.id.rv_wang_yi_data_list)
    RecyclerView mRecyclerView;
    @BindView(R.id.ll_empty)
    LinearLayout llEmpty;
    @BindView(R.id.tv_empty_title)
    TextView tvEmptyTitle;
    @BindView(R.id.iv_empty_image)
    ImageView ivEmptyImage;

    private WangYiListContract.Presenter mPresenter;
    private WangYiListRecyclerAdapter mRecyclerAdapter;
    private boolean isLoading = false;
    private int clickPosition = 0;
    private String mUrl;//访问各个category的url
    private String mNextUrl;//加载下一页的url，服务器会返回

    public WangYiListFragment() {

    }

    public static WangYiListFragment newInstance(String url) {
        WangYiListFragment fragment = new WangYiListFragment();
        Bundle args = new Bundle();
        args.putString(AppConstants.URL, url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mUrl = getArguments().getString(AppConstants.URL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wang_yi_list, container, false);
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
        mRecyclerAdapter = new WangYiListRecyclerAdapter(this.getActivity());
        mRecyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(), 3, GridLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerAdapter.setClickListener(new WangYiListRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                clickPosition = position;
                LogUtil.i(TAG,"点击item position="+position);
                BooksBean bean = mRecyclerAdapter.getItemData(position);
                if(bean == null){
                    return;
                }
                Intent intent = new Intent(WangYiListFragment.this.getActivity(), WangYiDetailsActivity.class);
                intent.putExtra(AppConstants.COMIC_ID, bean.getId()+"");
                startActivity(intent);
            }
        });

        tvEmptyTitle.setVisibility(View.GONE);
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
    public void setPresenter(WangYiListContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onLoad() {
        if(!isLoading) {
            LogUtil.i(TAG,"onLoad nextUrl=" + mNextUrl);
            if(TextUtils.isEmpty(mNextUrl)){
                ToastUtil.showToastShort("已经翻完了");
            }else {
                mPresenter.loadData(mNextUrl);
                isLoading = true;
            }
        }else {
            LogUtil.i(TAG,"正在加载");
        }
    }

    @Override
    public void onRefresh() {
        mPresenter.refreshData(mUrl);
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
    public void setNextUrl(String nextUrl) {
        mNextUrl = nextUrl;
    }

    @Override
    public void showRefreshData(List<BooksBean> mData){
        mRecyclerAdapter.clear();
        mRecyclerAdapter.addItems(mData);
        mRecyclerAdapter.notifyDataSetChanged();
        if(mRecyclerAdapter.getItemCount() < 1){
            if(ivEmptyImage != null){
                ivEmptyImage.setImageResource(R.drawable.ic_recommend_empty_icon);
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
                if(ivEmptyImage != null) {
                    ivEmptyImage.setImageResource(R.drawable.ic_load_failure);
                }
                dataIsEmpty();
            } else {
                dataIsNotEmpty();
            }
        }
    }

    @Override
    public void showLoadData(List<BooksBean> mData) {
        mRecyclerAdapter.addItems(mData);
        mRecyclerAdapter.notifyDataSetChanged();
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
