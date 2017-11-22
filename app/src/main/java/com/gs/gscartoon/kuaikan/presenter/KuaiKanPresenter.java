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

    public KuaiKanPresenter(KuaiKanModel model, KuaiKanContract.View kuaiKanView){
        mKuaiKanModel = model;

        mKuaiKanView = kuaiKanView;
        mKuaiKanView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void result(int requestCode, int resultCode) {

    }
}
