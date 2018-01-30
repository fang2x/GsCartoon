package com.gs.gscartoon.kuaikan.presenter;


import com.gs.gscartoon.history.bean.HistoryBean;
import com.gs.gscartoon.kuaikan.KuaiKanBrowseContract;
import com.gs.gscartoon.kuaikan.bean.KuaiKanBrowseBean;
import com.gs.gscartoon.kuaikan.model.KuaiKanBrowseModel;
import com.gs.gscartoon.utils.AppConstants;
import com.gs.gscartoon.utils.ErrorUtil;
import com.gs.gscartoon.utils.LogUtil;

import java.util.Date;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

/**
 * Created by camdora on 17-11-22.
 */

public class KuaiKanBrowsePresenter implements KuaiKanBrowseContract.Presenter {
    private static final String TAG = "KuaiKanBrowsePresenter";

    private final KuaiKanBrowseModel mKuaiKanBrowseModel;
    private final KuaiKanBrowseContract.View mKuaiKanBrowseView;
    private CompositeDisposable mCompositeDisposable;

    public KuaiKanBrowsePresenter(KuaiKanBrowseModel model, KuaiKanBrowseContract.View view){
        mKuaiKanBrowseModel = model;

        mKuaiKanBrowseView = view;
        mKuaiKanBrowseView.setPresenter(this);
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {
        mKuaiKanBrowseModel.closeRealm();
        if(mCompositeDisposable != null){
            mCompositeDisposable.clear();
        }
    }

    @Override
    public void refreshData(String id) {
        mKuaiKanBrowseModel.refreshKuaiKanBrowse(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<KuaiKanBrowseBean>() {
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
                        mKuaiKanBrowseView.refreshDataFailure();
                        if(e instanceof HttpException){
                            HttpException httpException = (HttpException) e;
                            ErrorUtil.showErrorInfo(httpException.code());
                        }else {
                            //其他错误认为是访问网络出错
                            ErrorUtil.showErrorInfo(ErrorUtil.ACCESS_NETWORK_ERROR);
                        }
                    }

                    @Override
                    public void onNext(KuaiKanBrowseBean bean) {
                        LogUtil.i(TAG, "onNext ");
                        if(bean.getData() != null) {
                            mKuaiKanBrowseView.showRefreshData(bean.getData().getImages());
                            mKuaiKanBrowseView.setTitle(bean.getData().getTitle());
                            //加入历史记录中
                            mKuaiKanBrowseModel.createHistory(bean.getData());
                        }else {
                            ErrorUtil.showErrorInfo(ErrorUtil.NOT_FOUND);
                        }
                    }
                });
    }
}
