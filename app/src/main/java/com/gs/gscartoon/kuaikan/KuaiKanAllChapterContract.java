package com.gs.gscartoon.kuaikan;


import com.gs.gscartoon.BasePresenter;
import com.gs.gscartoon.BaseView;
import com.gs.gscartoon.kuaikan.bean.KuaiKanAllChapterBean.DataBean;
import com.gs.gscartoon.kuaikan.bean.KuaiKanAllChapterBean.DataBean.ComicsBean;

import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface KuaiKanAllChapterContract {

    interface View extends BaseView<Presenter> {
        void showRefreshData(List<ComicsBean> mData);
        void refreshDataFailure();

        void updateInfor(DataBean bean);
    }

    interface Presenter extends BasePresenter {
        void refreshData(String id);
    }
}
