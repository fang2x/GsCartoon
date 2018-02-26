package com.gs.gscartoon.zhijia.presenter;


import com.gs.gscartoon.utils.ErrorUtil;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.zhijia.ZhiJiaBrowseContract;
import com.gs.gscartoon.zhijia.bean.ZhiJiaBrowseBean;
import com.gs.gscartoon.zhijia.model.ZhiJiaBrowseModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

/**
 * Created by camdora on 17-11-22.
 */

public class ZhiJiaBrowsePresenter implements ZhiJiaBrowseContract.Presenter {
    private static final String TAG = "ZhiJiaBrowsePresenter";

    private final ZhiJiaBrowseModel mZhiJiaBrowseModel;
    private final ZhiJiaBrowseContract.View mZhiJiaBrowseView;
    private CompositeDisposable mCompositeDisposable;

    public ZhiJiaBrowsePresenter(ZhiJiaBrowseModel model, ZhiJiaBrowseContract.View view){
        mZhiJiaBrowseModel = model;

        mZhiJiaBrowseView = view;
        mZhiJiaBrowseView.setPresenter(this);
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {
        mZhiJiaBrowseModel.closeRealm();
        if(mCompositeDisposable != null){
            mCompositeDisposable.clear();
        }
    }

    @Override
    public void refreshData(String comicId, String chapterId, final String comicTitle, final String coverUrl) {
        mZhiJiaBrowseModel.refreshZhiJiaBrowse(comicId, chapterId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhiJiaBrowseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.i(TAG, "onCompleted ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mZhiJiaBrowseView.refreshDataFailure();
                        if(e instanceof HttpException){
                            HttpException httpException = (HttpException) e;
                            ErrorUtil.showErrorInfo(httpException.code());
                        }else {
                            //其他错误认为是访问网络出错
                            ErrorUtil.showErrorInfo(ErrorUtil.ACCESS_NETWORK_ERROR);
                        }
                    }

                    @Override
                    public void onNext(ZhiJiaBrowseBean bean) {
                        LogUtil.i(TAG, "onNext ");
                        if(bean != null) {
                            mZhiJiaBrowseView.showRefreshData(bean.getPage_url());
                            mZhiJiaBrowseView.setTitle(bean.getTitle());
                            //加入历史记录中
                            mZhiJiaBrowseModel.createHistory(bean, comicTitle, coverUrl);
                        }else {
                            ErrorUtil.showErrorInfo(ErrorUtil.NOT_FOUND);
                        }
                    }
                });
    }
}
