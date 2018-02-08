package com.gs.gscartoon.wangyi.view;

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
import com.gs.gscartoon.wangyi.WangYiSectionContract;
import com.gs.gscartoon.wangyi.adapter.WangYiSectionRecyclerAdapter;
import com.gs.gscartoon.wangyi.bean.WangYiDetailsBean;
import com.gs.gscartoon.wangyi.bean.WangYiSectionBean;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WangYiSectionFragment extends Fragment
        implements WangYiSectionContract.View, View.OnClickListener{
    private final static String TAG = "WangYiSectionFragment";

    @BindView(R.id.rv_wang_yi_section)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_count)
    TextView tvCount;
    @BindView(R.id.tv_asc)
    TextView tvAsc;
    @BindView(R.id.tv_desc)
    TextView tvDesc;

    private WangYiSectionContract.Presenter mPresenter;
    private WangYiSectionRecyclerAdapter mRecyclerAdapter;
    private int mOrder = AppConstants.DESC;//排序，默认倒序
    private String mComicId;//漫画Id
    private String mComicTitle;//漫画Title
    private String mCoverUrl;//封面url

    public WangYiSectionFragment() {

    }

    public static WangYiSectionFragment newInstance(/*int myVideo, String categories*/) {
        WangYiSectionFragment fragment = new WangYiSectionFragment();
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
        View view = inflater.inflate(R.layout.fragment_wang_yi_section, container, false);
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

        mRecyclerAdapter = new WangYiSectionRecyclerAdapter(this.getActivity());
        mRecyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(), 4, GridLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerAdapter.setClickListener(new WangYiSectionRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                LogUtil.i(TAG,"点击item position="+position);
                /*DataBean bean = mRecyclerAdapter.getItemData(position);
                if(bean == null){
                    return;
                }
                Intent intent = new Intent(WangYiSectionFragment.this.getActivity(), WangYiBrowseActivity.class);
                intent.putExtra(AppConstants.COMIC_ID, mComicId);
                intent.putExtra(AppConstants.CHAPTER_ID, bean.getChapter_id());
                intent.putExtra(AppConstants.COMIC_TITLE, mComicTitle);//为了保存在历史记录中
                intent.putExtra(AppConstants.COVER_URL, mCoverUrl);//为了保存在历史记录中
                Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        WangYiSectionFragment.this.getActivity()).toBundle();
                startActivity(intent, bundle);*/
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
    public void setPresenter(WangYiSectionContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void updateDetails(WangYiDetailsBean bean) {
        if(bean == null){
            LogUtil.e(TAG, "bean == null");
            return;
        }
        WangYiDetailsBean.DataBean dataBean = bean.getData();
        if(dataBean == null){
            return;
        }

        mComicId = dataBean.getId();
        mComicTitle = dataBean.getTitle();
        mCoverUrl = dataBean.getCover();

        mPresenter.getWangYiSection(mComicId);
    }

    @Override
    public void getDetailsFailure() {

    }

    @Override
    public void getSectionSuccess(WangYiSectionBean bean) {
        mRecyclerAdapter.clear();
        mRecyclerAdapter.addItems(bean.getData().getSections().get(0).getSections());
        mRecyclerAdapter.order();//服务器默认是按顺序返回的，所以只要第一次状态匹配，之后倒置就可以了
    }

    @Override
    public void getSectionFailure() {

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
                    mRecyclerAdapter.order();
                    updateOrder();
                }else {
                    LogUtil.i(TAG, "当前正是正序");
                }
                break;
            case R.id.tv_desc:
                if(mOrder != AppConstants.DESC){
                    mOrder = AppConstants.DESC;
                    mRecyclerAdapter.order();
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
