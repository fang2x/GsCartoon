package com.gs.gscartoon.wangyi.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gs.gscartoon.R;
import com.gs.gscartoon.wangyi.WangYiDescriptionContract;
import com.gs.gscartoon.wangyi.bean.WangYiDetailsBean;

import butterknife.BindView;
import butterknife.ButterKnife;


public class WangYiDescriptionFragment extends Fragment
        implements WangYiDescriptionContract.View{
    private final static String TAG = "WangYiDescriptionFragment";

    @BindView(R.id.tv_description)
    TextView tvDescription;

    private WangYiDescriptionContract.Presenter mPresenter;

    public WangYiDescriptionFragment() {

    }

    public static WangYiDescriptionFragment newInstance(/*int myVideo, String categories*/) {
        WangYiDescriptionFragment fragment = new WangYiDescriptionFragment();
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
        View view = inflater.inflate(R.layout.fragment_wang_yi_description, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void initView(){

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
    public void setPresenter(WangYiDescriptionContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void updateDetails(WangYiDetailsBean bean) {
        if(tvDescription == null || bean == null){
            return;
        }
        WangYiDetailsBean.DataBean dataBean = bean.getData();
        tvDescription.setText(dataBean.getIntroduction());
    }

    @Override
    public void getDetailsFailure() {

    }
}
