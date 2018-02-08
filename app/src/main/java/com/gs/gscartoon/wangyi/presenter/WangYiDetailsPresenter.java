package com.gs.gscartoon.wangyi.presenter;

import com.gs.gscartoon.utils.ErrorUtil;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.wangyi.WangYiDetailsContract;
import com.gs.gscartoon.wangyi.bean.WangYiDetailsBean;
import com.gs.gscartoon.wangyi.model.WangYiDetailsModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

/**
 * Created by camdora on 17-11-22.
 */

public class WangYiDetailsPresenter implements WangYiDetailsContract.Presenter {
    private static final String TAG = "WangYiDetailsPresenter";

    private final WangYiDetailsModel mWangYiDetailsModel;
    private final WangYiDetailsContract.View mWangYiDetailsView;
    private CompositeDisposable mCompositeDisposable;

    public WangYiDetailsPresenter(WangYiDetailsModel model, WangYiDetailsContract.View view){
        mWangYiDetailsModel = model;

        mWangYiDetailsView = view;
        mWangYiDetailsView.setPresenter(this);
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
    public void getDetails(String id) {
        mWangYiDetailsModel.getWangYiDetails(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WangYiDetailsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.i(TAG, "getDetails onCompleted ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mWangYiDetailsView.getDetailsFailure();
                        if(e instanceof HttpException){
                            HttpException httpException = (HttpException) e;
                            ErrorUtil.showErrorInfo(httpException.code());
                        }else {
                            //其他错误认为是访问网络出错
                            ErrorUtil.showErrorInfo(ErrorUtil.ACCESS_NETWORK_ERROR);
                        }
                    }

                    @Override
                    public void onNext(WangYiDetailsBean bean) {
                        LogUtil.i(TAG, "getDetails onNext ");
                        if(bean != null) {
                            mWangYiDetailsView.updateDetails(bean);
                        }else {
                            ErrorUtil.showErrorInfo(ErrorUtil.NOT_FOUND);
                        }
                    }
                });
    }
}
