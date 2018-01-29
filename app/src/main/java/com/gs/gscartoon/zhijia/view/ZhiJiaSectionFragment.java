package com.gs.gscartoon.zhijia.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gs.gscartoon.R;
import com.gs.gscartoon.utils.AppConstants;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.zhijia.ZhiJiaSectionContract;
import com.gs.gscartoon.zhijia.adapter.ZhiJiaSectionRecyclerAdapter;
import com.gs.gscartoon.zhijia.bean.ZhiJiaDetailsBean;
import com.gs.gscartoon.zhijia.bean.ZhiJiaDetailsBean.ChaptersBean.DataBean;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ZhiJiaSectionFragment extends Fragment
        implements ZhiJiaSectionContract.View, View.OnClickListener{
    private final static String TAG = "ZhiJiaSectionFragment";

    @BindView(R.id.rv_zhi_jia_section)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_count)
    TextView tvCount;
    @BindView(R.id.tv_asc)
    TextView tvAsc;
    @BindView(R.id.tv_desc)
    TextView tvDesc;

    private ZhiJiaSectionContract.Presenter mPresenter;
    private ZhiJiaSectionRecyclerAdapter mRecyclerAdapter;
    private int mOrder = AppConstants.DESC;//排序，默认倒序
    private int mTopicId;//漫画Id

    public ZhiJiaSectionFragment() {

    }

    public static ZhiJiaSectionFragment newInstance(/*int myVideo, String categories*/) {
        ZhiJiaSectionFragment fragment = new ZhiJiaSectionFragment();
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
        View view = inflater.inflate(R.layout.fragment_zhi_jia_section, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void initView(){
        tvAsc.setOnClickListener(this);
        tvDesc.setOnClickListener(this);

        mRecyclerAdapter = new ZhiJiaSectionRecyclerAdapter(this.getActivity());
        mRecyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(), 4, GridLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerAdapter.setClickListener(new ZhiJiaSectionRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                LogUtil.i(TAG,"点击item position="+position);
                DataBean bean = mRecyclerAdapter.getItemData(position);
                if(bean == null){
                    return;
                }
                Intent intent = new Intent(ZhiJiaSectionFragment.this.getActivity(), ZhiJiaBrowseActivity.class);
                intent.putExtra(AppConstants.TOPIC_ID, mTopicId);
                intent.putExtra(AppConstants.COMICS_ID, bean.getChapter_id());
                Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        ZhiJiaSectionFragment.this.getActivity()).toBundle();
                startActivity(intent, bundle);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        updateOrder();
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
    public void setPresenter(ZhiJiaSectionContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void updateDetails(ZhiJiaDetailsBean bean) {
        if(bean.getChapters() == null || bean.getChapters().get(0) == null){
            LogUtil.e(TAG, "bean.getChapters() == null || bean.getChapters().get(0) == null");
            return;
        }
        mRecyclerAdapter.clear();
        mRecyclerAdapter.addItems(bean.getChapters().get(0).getData());
        mRecyclerAdapter.notifyDataSetChanged();

        mTopicId = bean.getId();
    }

    @Override
    public void getDetailsFailure() {

    }

    @Override
    public void updateOrder() {
        if(tvAsc == null || tvDesc == null){
            return;
        }

        if(mOrder == AppConstants.ASC){
            tvAsc.setTextColor(getResources().getColor(R.color.ToolbarDark));
            tvDesc.setTextColor(getResources().getColor(R.color.BLACK));
        }else {
            tvDesc.setTextColor(getResources().getColor(R.color.ToolbarDark));
            tvAsc.setTextColor(getResources().getColor(R.color.BLACK));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_asc:
                if(mOrder != AppConstants.ASC){
                    mOrder = AppConstants.ASC;
                    mRecyclerAdapter.order(mOrder);
                    updateOrder();
                }else {
                    LogUtil.i(TAG, "当前正是正序");
                }
                break;
            case R.id.tv_desc:
                if(mOrder != AppConstants.DESC){
                    mOrder = AppConstants.DESC;
                    mRecyclerAdapter.order(mOrder);
                    updateOrder();
                }else {
                    LogUtil.i(TAG, "当前正是倒序");
                }
                break;
            default:
                break;
        }
    }
}
