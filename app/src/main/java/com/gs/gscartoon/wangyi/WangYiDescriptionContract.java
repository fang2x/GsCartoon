package com.gs.gscartoon.wangyi;


import com.gs.gscartoon.BasePresenter;
import com.gs.gscartoon.BaseView;
import com.gs.gscartoon.wangyi.bean.WangYiDetailsBean;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface WangYiDescriptionContract {

    interface View extends BaseView<Presenter> {
        void updateDetails(WangYiDetailsBean bean);
        void getDetailsFailure();
    }

    interface Presenter extends BasePresenter {
        void getDetails(WangYiDetailsBean bean);
    }
}
