package com.gs.gscartoon.wangyi;


import com.gs.gscartoon.BasePresenter;
import com.gs.gscartoon.BaseView;
import com.gs.gscartoon.wangyi.bean.WangYiListBean.DataBean.BooksBean;

import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface WangYiListContract {

    interface View extends BaseView<Presenter> {
        void hideRefreshProgress();

        void setLoading(boolean loading);
        void setNextUrl(String nextUrl);

        void showRefreshData(List<BooksBean> mData);
        void refreshDataFailure();
        void showLoadData(List<BooksBean> mData);
    }

    interface Presenter extends BasePresenter {
        void refreshData(String url);
        void loadData(String url);
    }
}
