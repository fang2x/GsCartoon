package com.gs.gscartoon.wangyi.presenter;


import com.gs.gscartoon.utils.ErrorUtil;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.wangyi.WangYiBrowseContract;
import com.gs.gscartoon.wangyi.bean.WangYiBrowseBean;
import com.gs.gscartoon.wangyi.model.WangYiBrowseModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

/**
 * Created by camdora on 17-11-22.
 */

public class WangYiBrowsePresenter implements WangYiBrowseContract.Presenter {
    private static final String TAG = "WangYiBrowsePresenter";

    private final WangYiBrowseModel mWangYiBrowseModel;
    private final WangYiBrowseContract.View mWangYiBrowseView;
    private CompositeDisposable mCompositeDisposable;

    public WangYiBrowsePresenter(WangYiBrowseModel model, WangYiBrowseContract.View view){
        mWangYiBrowseModel = model;

        mWangYiBrowseView = view;
        mWangYiBrowseView.setPresenter(this);
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {
        mWangYiBrowseModel.closeRealm();
        if(mCompositeDisposable != null){
            mCompositeDisposable.clear();
        }
    }

    @Override
    public void refreshData(String comicId, String chapterId, final String comicTitle, final String coverUrl) {
        String url = "https://h5.manhua.163.com/api/comic/" + comicId + "/chapter/" + chapterId;
        mWangYiBrowseModel.refreshWangYiBrowse(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WangYiBrowseBean>() {
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
                        mWangYiBrowseView.refreshDataFailure();
                        if(e instanceof HttpException){
                            HttpException httpException = (HttpException) e;
                            ErrorUtil.showErrorInfo(httpException.code());
                        }else {
                            //其他错误认为是访问网络出错
                            ErrorUtil.showErrorInfo(ErrorUtil.ACCESS_NETWORK_ERROR);
                        }
                    }

                    @Override
                    public void onNext(WangYiBrowseBean bean) {
                        LogUtil.i(TAG, "onNext ");
                        if(bean != null) {
                            WangYiBrowseBean.DataBean mDataBean = bean.getData();
                            if(mDataBean == null){
                                return;
                            }
                            mWangYiBrowseView.showRefreshData(mDataBean.getImageList());
                            mWangYiBrowseView.setTitle(mDataBean.getTitle());
                            //加入历史记录中
                            mWangYiBrowseModel.createHistory(bean, comicTitle, coverUrl);
                        }else {
                            ErrorUtil.showErrorInfo(ErrorUtil.NOT_FOUND);
                        }
                    }
                });
    }
}
