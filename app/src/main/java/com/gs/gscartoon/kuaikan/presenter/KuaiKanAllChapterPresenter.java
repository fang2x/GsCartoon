package com.gs.gscartoon.kuaikan.presenter;


import com.gs.gscartoon.kuaikan.KuaiKanAllChapterContract;
import com.gs.gscartoon.kuaikan.bean.KuaiKanAllChapterBean;
import com.gs.gscartoon.kuaikan.model.KuaiKanAllChapterModel;
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

public class KuaiKanAllChapterPresenter implements KuaiKanAllChapterContract.Presenter {
    private static final String TAG = "KuaiKanAllChapterPresenter";

    private final KuaiKanAllChapterModel mKuaiKanAllChapterModel;
    private final KuaiKanAllChapterContract.View mKuaiKanAllChapterView;
    private CompositeDisposable mCompositeDisposable;

    public KuaiKanAllChapterPresenter(KuaiKanAllChapterModel model, KuaiKanAllChapterContract.View view){
        mKuaiKanAllChapterModel = model;

        mKuaiKanAllChapterView = view;
        mKuaiKanAllChapterView.setPresenter(this);
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
    public void refreshData(String id) {
        mKuaiKanAllChapterModel.refreshKuaiKanAllChapter(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<KuaiKanAllChapterBean>() {
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
                        mKuaiKanAllChapterView.refreshDataFailure();
                        if(e instanceof HttpException){
                            HttpException httpException = (HttpException) e;
                            ErrorUtil.showErrorInfo(httpException.code());
                        }else {
                            //其他错误认为是访问网络出错
                            ErrorUtil.showErrorInfo(ErrorUtil.ACCESS_NETWORK_ERROR);
                        }
                    }

                    @Override
                    public void onNext(KuaiKanAllChapterBean bean) {
                        LogUtil.i(TAG, "onNext ");
                        if(bean.getData() != null) {
                            mKuaiKanAllChapterView.showRefreshData(bean.getData().getComics());
                            mKuaiKanAllChapterView.setTitle(bean.getData().getTitle());
                        }else {
                            ErrorUtil.showErrorInfo(ErrorUtil.NOT_FOUND);
                        }
                    }
                });
    }
}
