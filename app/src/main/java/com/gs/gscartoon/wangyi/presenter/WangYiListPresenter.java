package com.gs.gscartoon.wangyi.presenter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gs.gscartoon.utils.ErrorUtil;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.wangyi.WangYiListContract;
import com.gs.gscartoon.wangyi.bean.WangYiListBean;
import com.gs.gscartoon.wangyi.model.WangYiListModel;
import com.gs.gscartoon.zhijia.ZhiJiaContract;
import com.gs.gscartoon.zhijia.bean.ZhiJiaListBean;
import com.gs.gscartoon.zhijia.model.ZhiJiaModel;

import java.lang.reflect.Type;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

/**
 * Created by camdora on 17-11-22.
 */

public class WangYiListPresenter implements WangYiListContract.Presenter {
    private static final String TAG = "WangYiListPresenter";

    private final WangYiListModel mWangYiListModel;
    private final WangYiListContract.View mWangYiListView;
    private CompositeDisposable mCompositeDisposable;

    public WangYiListPresenter(WangYiListModel model, WangYiListContract.View view){
        mWangYiListModel = model;

        mWangYiListView = view;
        mWangYiListView.setPresenter(this);
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
    public void refreshData(String url) {
        LogUtil.e(TAG, "4444 url= "+url);
        mWangYiListModel.refreshWangYiList(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WangYiListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.i(TAG, "refreshData onCompleted");
                        mWangYiListView.hideRefreshProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mWangYiListView.hideRefreshProgress();
                        mWangYiListView.refreshDataFailure();
                        if(e instanceof HttpException){
                            HttpException httpException = (HttpException) e;
                            ErrorUtil.showErrorInfo(httpException.code());
                        }else {
                            //其他错误认为是访问网络出错
                            ErrorUtil.showErrorInfo(ErrorUtil.ACCESS_NETWORK_ERROR);
                        }
                    }

                    @Override
                    public void onNext(WangYiListBean bean) {
                        LogUtil.i(TAG, "refreshData onNext");
                        if(bean == null || bean.getData() == null){
                            mWangYiListView.hideRefreshProgress();
                            mWangYiListView.refreshDataFailure();
                            return;
                        }
                        LogUtil.i(TAG, "刷新数据:"+bean.getData().getBooks().size());
                        mWangYiListView.showRefreshData(bean.getData().getBooks());
                        mWangYiListView.setNextUrl(bean.getData().getNext());
                    }
                });
    }

    @Override
    public void loadData(String url) {
        mWangYiListModel.loadWangYiList(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WangYiListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.i(TAG, "loadData onCompleted ");
                        mWangYiListView.setLoading(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mWangYiListView.setLoading(false);
                        if(e instanceof HttpException){
                            HttpException httpException = (HttpException) e;
                            ErrorUtil.showErrorInfo(httpException.code());
                        }else {
                            //其他错误认为是访问网络出错
                            ErrorUtil.showErrorInfo(ErrorUtil.ACCESS_NETWORK_ERROR);
                        }
                    }

                    @Override
                    public void onNext(WangYiListBean bean) {
                        LogUtil.i(TAG, "loadData onNext");
                        if(bean == null || bean.getData() == null){
                            mWangYiListView.setLoading(false);
                            return;
                        }
                        mWangYiListView.showLoadData(bean.getData().getBooks());
                        mWangYiListView.setNextUrl(bean.getData().getNext());
                    }
                });
    }
}
