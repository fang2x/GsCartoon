package com.gs.gscartoon.zhijia.presenter;

import com.google.gson.Gson;
import java.lang.reflect.Type;

import com.google.gson.reflect.TypeToken;
import com.gs.gscartoon.utils.ErrorUtil;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.zhijia.ZhiJiaContract;
import com.gs.gscartoon.zhijia.bean.ZhiJiaListBean;
import com.gs.gscartoon.zhijia.bean.ZhiJiaResult;
import com.gs.gscartoon.zhijia.model.ZhiJiaModel;

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

public class ZhiJiaPresenter implements ZhiJiaContract.Presenter {
    private static final String TAG = "ZhiJiaPresenter";

    private final ZhiJiaModel mZhiJiaModel;
    private final ZhiJiaContract.View mZhiJiaView;
    private CompositeDisposable mCompositeDisposable;

    public ZhiJiaPresenter(ZhiJiaModel model, ZhiJiaContract.View view){
        mZhiJiaModel = model;

        mZhiJiaView = view;
        mZhiJiaView.setPresenter(this);
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
    public void refreshData() {
        mZhiJiaModel.refreshZhiJiaList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.i(TAG, "refreshData onCompleted");
                        mZhiJiaView.hideRefreshProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mZhiJiaView.hideRefreshProgress();
                        mZhiJiaView.refreshDataFailure();
                        if(e instanceof HttpException){
                            HttpException httpException = (HttpException) e;
                            ErrorUtil.showErrorInfo(httpException.code());
                        }else {
                            //其他错误认为是访问网络出错
                            ErrorUtil.showErrorInfo(ErrorUtil.ACCESS_NETWORK_ERROR);
                        }
                    }

                    @Override
                    public void onNext(ResponseBody body) {
                        LogUtil.i(TAG, "refreshData onNext");
                        try {
                            Gson gson = new Gson();
                            Type type = new TypeToken<List<ZhiJiaListBean>>() {}.getType();
                            Object fromJson2 = gson.fromJson(body.string(), type);
                            List<ZhiJiaListBean> list = (List<ZhiJiaListBean>) fromJson2;

                            mZhiJiaView.showRefreshData(list);
                        }catch (Exception e){
                            mZhiJiaView.hideRefreshProgress();
                            mZhiJiaView.refreshDataFailure();
                            e.printStackTrace();
                        }
                    }
                });
    }

    @Override
    public void loadData(int page) {
        mZhiJiaModel.loadZhiJiaList(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.i(TAG, "loadData onCompleted ");
                        mZhiJiaView.setLoading(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mZhiJiaView.setLoading(false);
                        if(e instanceof HttpException){
                            HttpException httpException = (HttpException) e;
                            ErrorUtil.showErrorInfo(httpException.code());
                        }else {
                            //其他错误认为是访问网络出错
                            ErrorUtil.showErrorInfo(ErrorUtil.ACCESS_NETWORK_ERROR);
                        }
                    }

                    @Override
                    public void onNext(ResponseBody body) {
                        LogUtil.i(TAG, "loadData onNext");
                        try {
                            Gson gson = new Gson();
                            Type type = new TypeToken<List<ZhiJiaListBean>>() {}.getType();
                            Object fromJson2 = gson.fromJson(body.string(), type);
                            List<ZhiJiaListBean> list = (List<ZhiJiaListBean>) fromJson2;

                            mZhiJiaView.showLoadData(list);
                        }catch (Exception e){
                            mZhiJiaView.hideRefreshProgress();
                            mZhiJiaView.refreshDataFailure();
                            e.printStackTrace();
                        }
                    }
                });
    }
}
