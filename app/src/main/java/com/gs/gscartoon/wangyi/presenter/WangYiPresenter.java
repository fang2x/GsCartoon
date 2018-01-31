package com.gs.gscartoon.wangyi.presenter;

import com.gs.gscartoon.utils.ErrorUtil;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.wangyi.WangYiContract;
import com.gs.gscartoon.wangyi.bean.WangYiCategoryBean;
import com.gs.gscartoon.wangyi.model.WangYiModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

/**
 * Created by camdora on 17-11-22.
 */

public class WangYiPresenter implements WangYiContract.Presenter {
    private static final String TAG = "WangYiPresenter";

    private final WangYiModel mWangYiModel;
    private final WangYiContract.View mWangYiView;
    private CompositeDisposable mCompositeDisposable;

    public WangYiPresenter(WangYiModel model, WangYiContract.View view){
        mWangYiModel = model;

        mWangYiView = view;
        mWangYiView.setPresenter(this);
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
    public void getCategory() {
        mWangYiModel.getWangYiCategory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WangYiCategoryBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.i(TAG, "getCategory onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mWangYiView.getCategoryFailure();
                        if(e instanceof HttpException){
                            HttpException httpException = (HttpException) e;
                            ErrorUtil.showErrorInfo(httpException.code());
                        }else {
                            //其他错误认为是访问网络出错
                            ErrorUtil.showErrorInfo(ErrorUtil.ACCESS_NETWORK_ERROR);
                        }
                    }

                    @Override
                    public void onNext(WangYiCategoryBean bean) {
                        LogUtil.i(TAG, "getCategory onNext");
                        mWangYiView.getCategorySuccess(bean);
                    }
                });
    }
}
