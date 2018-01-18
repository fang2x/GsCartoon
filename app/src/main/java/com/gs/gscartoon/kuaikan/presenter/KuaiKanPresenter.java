package com.gs.gscartoon.kuaikan.presenter;


import com.gs.gscartoon.kuaikan.KuaiKanContract;
import com.gs.gscartoon.kuaikan.model.KuaiKanModel;

/**
 * Created by camdora on 17-11-22.
 */

public class KuaiKanPresenter implements KuaiKanContract.Presenter {
    private static final String TAG = "KuaiKanPresenter";

    private final KuaiKanModel mKuaiKanModel;
    private final KuaiKanContract.View mKuaiKanView;

    public KuaiKanPresenter(KuaiKanModel model, KuaiKanContract.View view){
        mKuaiKanModel = model;

        mKuaiKanView = view;
        mKuaiKanView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void result(int requestCode, int resultCode) {

    }
}
