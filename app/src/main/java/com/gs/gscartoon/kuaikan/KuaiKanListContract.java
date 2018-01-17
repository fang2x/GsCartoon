package com.gs.gscartoon.kuaikan;


import com.gs.gscartoon.BasePresenter;
import com.gs.gscartoon.BaseView;
import com.gs.gscartoon.kuaikan.bean.KuaiKanListBean.DataBean.ComicsBean;

import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface KuaiKanListContract {

    interface View extends BaseView<Presenter> {
        void hideRefreshProgress();

        void setLoading(boolean loading);

        void showRefreshData(List<ComicsBean> mData);
        void refreshDataFailure();
        void showLoadData(List<ComicsBean> mData);
    }

    interface Presenter extends BasePresenter {
        void refreshData(String timestamp);
        void loadData(String id);
    }
}
