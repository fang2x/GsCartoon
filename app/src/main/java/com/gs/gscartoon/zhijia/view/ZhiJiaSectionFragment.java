package com.gs.gscartoon.zhijia.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gs.gscartoon.R;
import com.gs.gscartoon.zhijia.ZhiJiaSectionContract;
import com.gs.gscartoon.zhijia.bean.ZhiJiaDetailsBean;

import butterknife.ButterKnife;


public class ZhiJiaSectionFragment extends Fragment
        implements ZhiJiaSectionContract.View{
    private final static String TAG = "ZhiJiaSectionFragment";

    private ZhiJiaSectionContract.Presenter mPresenter;

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
    public void setPresenter(ZhiJiaSectionContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void updateDetails(ZhiJiaDetailsBean bean) {

    }

    @Override
    public void getDetailsFailure() {

    }
}
