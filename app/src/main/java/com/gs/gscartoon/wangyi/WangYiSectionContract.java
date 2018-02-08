package com.gs.gscartoon.wangyi;


import com.gs.gscartoon.BasePresenter;
import com.gs.gscartoon.BaseView;
import com.gs.gscartoon.wangyi.bean.WangYiDetailsBean;
import com.gs.gscartoon.wangyi.bean.WangYiSectionBean;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface WangYiSectionContract {

    interface View extends BaseView<Presenter> {
        void updateDetails(WangYiDetailsBean bean);
        void getDetailsFailure();

        void getSectionSuccess(WangYiSectionBean bean);
        void getSectionFailure();

        void updateOrder();
    }

    interface Presenter extends BasePresenter {
        void getDetails(WangYiDetailsBean bean);
        void getWangYiSection(String id);
    }
}
