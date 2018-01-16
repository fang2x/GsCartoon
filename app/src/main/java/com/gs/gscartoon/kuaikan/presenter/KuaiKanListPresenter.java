package com.gs.gscartoon.kuaikan.presenter;

import com.gs.gscartoon.kuaikan.KuaiKanListContract;
import com.gs.gscartoon.kuaikan.model.KuaiKanListModel;

/**
 * Created by camdora on 17-11-22.
 */

public class KuaiKanListPresenter implements KuaiKanListContract.Presenter {
    private static final String TAG = "KuaiKanListPresenter";

    private final KuaiKanListModel mKuaiKanListModel;
    private final KuaiKanListContract.View mKuaiKanListView;

    public KuaiKanListPresenter(KuaiKanListModel model, KuaiKanListContract.View view){
        mKuaiKanListModel = model;

        mKuaiKanListView = view;
        mKuaiKanListView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }
}
