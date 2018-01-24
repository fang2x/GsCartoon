package com.gs.gscartoon.zhijia.presenter;

import com.gs.gscartoon.zhijia.ZhiJiaDescriptionContract;
import com.gs.gscartoon.zhijia.bean.ZhiJiaDetailsBean;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by camdora on 17-11-22.
 */

public class ZhiJiaDescriptionPresenter implements ZhiJiaDescriptionContract.Presenter {
    private static final String TAG = "ZhiJiaDescriptionPresenter";

    private final ZhiJiaDescriptionContract.View mZhiJiaDescriptionView;
    private CompositeDisposable mCompositeDisposable;

    public ZhiJiaDescriptionPresenter(ZhiJiaDescriptionContract.View view){

        mZhiJiaDescriptionView = view;
        mZhiJiaDescriptionView.setPresenter(this);
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
    public void getDetails(ZhiJiaDetailsBean bean) {

    }
}
