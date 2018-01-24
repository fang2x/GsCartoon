package com.gs.gscartoon.zhijia;


import com.gs.gscartoon.BasePresenter;
import com.gs.gscartoon.BaseView;
import com.gs.gscartoon.zhijia.bean.ZhiJiaDetailsBean;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface ZhiJiaSectionContract {

    interface View extends BaseView<Presenter> {
        void updateDetails(ZhiJiaDetailsBean bean);
        void getDetailsFailure();
    }

    interface Presenter extends BasePresenter {
        void getDetails(ZhiJiaDetailsBean bean);
    }
}
