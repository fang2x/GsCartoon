package com.gs.gscartoon.kuaikan.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.gs.gscartoon.kuaikan.bean.KuaiKanListBean.DataBean.ComicsBean;
import com.gs.gscartoon.R;
import com.gs.gscartoon.kuaikan.KuaiKanListContract;
import com.gs.gscartoon.kuaikan.adapter.KuaiKanListRecyclerAdapter;
import com.gs.gscartoon.utils.AppConstants;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.widget.view.refresh.JFengRefreshLayout;
import com.gs.gscartoon.widget.view.refresh.JFengRefreshListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class KuaiKanListFragment extends Fragment implements
        KuaiKanListContract.View, JFengRefreshListener {
    private final static String TAG = "KuaiKanListFragment";

    @BindView(R.id.jfrl_kuai_kan_list_refresh_layout)
    JFengRefreshLayout mRefreshLayout;
    @BindView(R.id.jfrl_kuai_kan_empty_refresh_layout)
    JFengRefreshLayout mEmptyRefreshLayout;
    @BindView(R.id.rv_kuai_kan_data_list)
    RecyclerView mRecyclerView;
    @BindView(R.id.ll_empty)
    LinearLayout llEmpty;
    @BindView(R.id.tv_empty_title)
    TextView tvEmptyTitle;

    private KuaiKanListContract.Presenter mPresenter;
    private KuaiKanListRecyclerAdapter mRecyclerAdapter;
    private boolean isLoading = false;
    private int clickPosition = 0;
    private String mTimestamp;//时间戳，用于拼接链接

    public KuaiKanListFragment() {

    }

    public static KuaiKanListFragment newInstance(String timestamp) {
        KuaiKanListFragment fragment = new KuaiKanListFragment();
        Bundle args = new Bundle();
        args.putString(AppConstants.TIMESTAMP, timestamp);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTimestamp = getArguments().getString(AppConstants.TIMESTAMP);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kuai_kan_list, container, false);
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
        mRecyclerAdapter = new KuaiKanListRecyclerAdapter(this.getActivity());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerAdapter.setClickListener(new KuaiKanListRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                clickPosition = position;
                LogUtil.i(TAG,"点击item position="+position);
                ComicsBean bean = mRecyclerAdapter.getItemData(position);
                if(bean == null){
                    return;
                }
                Intent intent = new Intent(KuaiKanListFragment.this.getActivity(), KuaiKanBrowseActivity.class);
                intent.putExtra(AppConstants.ID, bean.getId()+"");
                startActivity(intent);
            }

            @Override
            public void onAllClick(int position) {
                clickPosition = position;
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
    public void setPresenter(KuaiKanListContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onLoad() {
        if(!isLoading) {
            String id = "";
            if(mRecyclerAdapter.getItemCount() > 0){
                //id = mRecyclerAdapter.getItemData(mRecyclerAdapter.getItemCount() - 1).getId();
                //mPresenter.loadPublishedHousing(id);
            }
            LogUtil.i(TAG,"onLoad id="+id);
            isLoading = true;
        }else {
            LogUtil.i(TAG,"正在加载");
        }
    }

    @Override
    public void onRefresh() {
        mPresenter.refreshData(mTimestamp);
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
    public void showRefreshData(List<ComicsBean> mData){
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
    public void showLoadData(List<ComicsBean> mData) {
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
