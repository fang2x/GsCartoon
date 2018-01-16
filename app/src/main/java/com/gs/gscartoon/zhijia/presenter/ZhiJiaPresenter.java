package com.gs.gscartoon.zhijia.presenter;

import com.gs.gscartoon.manman.ManManContract;
import com.gs.gscartoon.manman.model.ManManModel;
import com.gs.gscartoon.zhijia.ZhiJiaContract;
import com.gs.gscartoon.zhijia.model.ZhiJiaModel;

/**
 * Created by camdora on 17-11-22.
 */

public class ZhiJiaPresenter implements ZhiJiaContract.Presenter {
    private static final String TAG = "ZhiJiaPresenter";

    private final ZhiJiaModel mZhiJiaModel;
    private final ZhiJiaContract.View mZhiJiaView;

    public ZhiJiaPresenter(ZhiJiaModel model, ZhiJiaContract.View view){
        mZhiJiaModel = model;

        mZhiJiaView = view;
        mZhiJiaView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }
}
