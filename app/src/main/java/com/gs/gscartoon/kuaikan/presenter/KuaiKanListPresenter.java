package com.gs.gscartoon.kuaikan.presenter;

import com.gs.gscartoon.kuaikan.KuaiKanListContract;
import com.gs.gscartoon.kuaikan.bean.KuaiKanListBean;
import com.gs.gscartoon.kuaikan.model.KuaiKanListModel;
import com.gs.gscartoon.utils.ErrorUtil;
import com.gs.gscartoon.utils.LogUtil;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;

/**
 * Created by camdora on 17-11-22.
 */

public class KuaiKanListPresenter implements KuaiKanListContract.Presenter {
    private static final String TAG = "KuaiKanListPresenter";

    private final KuaiKanListModel mKuaiKanListModel;
    private final KuaiKanListContract.View mKuaiKanListView;
    private CompositeDisposable mCompositeDisposable;

    public KuaiKanListPresenter(KuaiKanListModel model, KuaiKanListContract.View view){
        mKuaiKanListModel = model;

        mKuaiKanListView = view;
        mKuaiKanListView.setPresenter(this);
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
    public void refreshData(String timestamp) {
        mKuaiKanListModel.refreshKuaiKanList(timestamp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<KuaiKanListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.i(TAG, "onCompleted ");
                        mKuaiKanListView.hideRefreshProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mKuaiKanListView.hideRefreshProgress();
                        mKuaiKanListView.refreshDataFailure();
                        if(e instanceof HttpException){
                            HttpException httpException = (HttpException) e;
                            ErrorUtil.showErrorInfo(httpException.code());
                        }else {
                            //其他错误认为是访问网络出错
                            ErrorUtil.showErrorInfo(ErrorUtil.ACCESS_NETWORK_ERROR);
                        }
                    }

                    @Override
                    public void onNext(KuaiKanListBean bean) {
                        LogUtil.i(TAG, "onNext ");
                        if(bean.getData() != null) {
                            mKuaiKanListView.showRefreshData(bean.getData().getComics());
                        }else {
                            ErrorUtil.showErrorInfo(ErrorUtil.NOT_FOUND);
                        }
                    }
                });
    }

    @Override
    public void loadData(String id) {

    }
}
