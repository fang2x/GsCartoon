package com.gs.gscartoon.zhijia.presenter;

import com.gs.gscartoon.zhijia.ZhiJiaSectionContract;
import com.gs.gscartoon.zhijia.bean.ZhiJiaDetailsBean;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by camdora on 17-11-22.
 */

public class ZhiJiaSectionPresenter implements ZhiJiaSectionContract.Presenter {
    private static final String TAG = "ZhiJiaSectionPresenter";

    private final ZhiJiaSectionContract.View mZhiJiaSectionView;
    private CompositeDisposable mCompositeDisposable;

    public ZhiJiaSectionPresenter(ZhiJiaSectionContract.View view){

        mZhiJiaSectionView = view;
        mZhiJiaSectionView.setPresenter(this);
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
