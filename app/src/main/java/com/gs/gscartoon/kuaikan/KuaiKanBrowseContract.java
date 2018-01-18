package com.gs.gscartoon.kuaikan;


import com.gs.gscartoon.BasePresenter;
import com.gs.gscartoon.BaseView;

import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface KuaiKanBrowseContract {

    interface View extends BaseView<Presenter> {
        void showRefreshData(List<String> mData);
        void refreshDataFailure();
    }

    interface Presenter extends BasePresenter {
        void refreshData(String id);
    }
}
