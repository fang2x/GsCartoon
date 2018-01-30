package com.gs.gscartoon.history;


import com.gs.gscartoon.BasePresenter;
import com.gs.gscartoon.BaseView;
import com.gs.gscartoon.history.bean.HistoryBean;

import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface HistoryContract {

    interface View extends BaseView<Presenter> {
        void showRefreshData(List<HistoryBean> mData);
        void refreshDataFailure();

        void removeRecycleData();
    }

    interface Presenter extends BasePresenter {
        void refreshData();

        void deleteData(String id);
    }
}
