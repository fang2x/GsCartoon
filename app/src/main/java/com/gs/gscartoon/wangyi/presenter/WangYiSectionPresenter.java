package com.gs.gscartoon.wangyi.presenter;

import com.gs.gscartoon.utils.ErrorUtil;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.wangyi.WangYiSectionContract;
import com.gs.gscartoon.wangyi.bean.WangYiDetailsBean;
import com.gs.gscartoon.wangyi.bean.WangYiSectionBean;
import com.gs.gscartoon.wangyi.model.WangYiSectionModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

/**
 * Created by camdora on 17-11-22.
 */

public class WangYiSectionPresenter implements WangYiSectionContract.Presenter {
    private static final String TAG = "WangYiSectionPresenter";

    private final WangYiSectionModel mWangYiSectionModel;
    private final WangYiSectionContract.View mWangYiSectionView;
    private CompositeDisposable mCompositeDisposable;

    public WangYiSectionPresenter(WangYiSectionModel model, WangYiSectionContract.View view){
        mWangYiSectionModel = model;

        mWangYiSectionView = view;
        mWangYiSectionView.setPresenter(this);
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
        mWangYiSectionView.updateDetails(bean);
    }

    @Override
    public void getWangYiSection(String id) {
        mWangYiSectionModel.getWangYiSection(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WangYiSectionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.i(TAG, "getWangYiSection onCompleted ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mWangYiSectionView.getSectionFailure();
                        if(e instanceof HttpException){
                            HttpException httpException = (HttpException) e;
                            ErrorUtil.showErrorInfo(httpException.code());
                        }else {
                            //其他错误认为是访问网络出错
                            ErrorUtil.showErrorInfo(ErrorUtil.ACCESS_NETWORK_ERROR);
                        }
                    }

                    @Override
                    public void onNext(WangYiSectionBean bean) {
                        LogUtil.i(TAG, "getWangYiSection onNext ");
                        if(bean != null) {
                            mWangYiSectionView.getSectionSuccess(bean);
                        }else {
                            ErrorUtil.showErrorInfo(ErrorUtil.NOT_FOUND);
                        }
                    }
                });
    }
}
