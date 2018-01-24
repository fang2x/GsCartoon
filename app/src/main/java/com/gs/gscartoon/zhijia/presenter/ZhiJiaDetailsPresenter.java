package com.gs.gscartoon.zhijia.presenter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gs.gscartoon.utils.ErrorUtil;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.zhijia.ZhiJiaContract;
import com.gs.gscartoon.zhijia.ZhiJiaDetailsContract;
import com.gs.gscartoon.zhijia.bean.ZhiJiaDetailsBean;
import com.gs.gscartoon.zhijia.bean.ZhiJiaListBean;
import com.gs.gscartoon.zhijia.model.ZhiJiaDetailsModel;
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

public class ZhiJiaDetailsPresenter implements ZhiJiaDetailsContract.Presenter {
    private static final String TAG = "ZhiJiaDetailsPresenter";

    private final ZhiJiaDetailsModel mZhiJiaDetailsModel;
    private final ZhiJiaDetailsContract.View mZhiJiaDetailsView;
    private CompositeDisposable mCompositeDisposable;

    public ZhiJiaDetailsPresenter(ZhiJiaDetailsModel model, ZhiJiaDetailsContract.View view){
        mZhiJiaDetailsModel = model;

        mZhiJiaDetailsView = view;
        mZhiJiaDetailsView.setPresenter(this);
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
        mZhiJiaDetailsModel.getZhiJiaDetails(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZhiJiaDetailsBean>() {
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
                        mZhiJiaDetailsView.getDetailsFailure();
                        if(e instanceof HttpException){
                            HttpException httpException = (HttpException) e;
                            ErrorUtil.showErrorInfo(httpException.code());
                        }else {
                            //其他错误认为是访问网络出错
                            ErrorUtil.showErrorInfo(ErrorUtil.ACCESS_NETWORK_ERROR);
                        }
                    }

                    @Override
                    public void onNext(ZhiJiaDetailsBean bean) {
                        LogUtil.i(TAG, "getDetails onNext ");
                        if(bean != null) {
                            mZhiJiaDetailsView.updateDetails(bean);
                        }else {
                            ErrorUtil.showErrorInfo(ErrorUtil.NOT_FOUND);
                        }
                    }
                });
    }
}
