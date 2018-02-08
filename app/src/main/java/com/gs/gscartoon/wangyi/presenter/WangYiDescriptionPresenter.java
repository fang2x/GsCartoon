package com.gs.gscartoon.wangyi.presenter;

import com.gs.gscartoon.wangyi.WangYiDescriptionContract;
import com.gs.gscartoon.wangyi.bean.WangYiDetailsBean;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by camdora on 17-11-22.
 */

public class WangYiDescriptionPresenter implements WangYiDescriptionContract.Presenter {
    private static final String TAG = "WangYiDescriptionPresenter";

    private final WangYiDescriptionContract.View mWangYiDescriptionView;
    private CompositeDisposable mCompositeDisposable;

    public WangYiDescriptionPresenter(WangYiDescriptionContract.View view){

        mWangYiDescriptionView = view;
        mWangYiDescriptionView.setPresenter(this);
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {
        if(mCompositeDisposable != null){
            mCompositeDisposable.clear();
        }
    }

    @Override
    public void getDetails(WangYiDetailsBean bean) {
        mWangYiDescriptionView.updateDetails(bean);
    }
}
