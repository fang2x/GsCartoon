package com.gs.gscartoon.zhijia;


import com.gs.gscartoon.BasePresenter;
import com.gs.gscartoon.BaseView;
import com.gs.gscartoon.zhijia.bean.ZhiJiaListBean;

import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface ZhiJiaContract {

    interface View extends BaseView<Presenter> {
        void hideRefreshProgress();

        void setLoading(boolean loading);

        void showRefreshData(List<ZhiJiaListBean> mData);
        void refreshDataFailure();
        void showLoadData(List<ZhiJiaListBean> mData);
    }

    interface Presenter extends BasePresenter {
        void refreshData();
        void loadData(int page);
    }
}
