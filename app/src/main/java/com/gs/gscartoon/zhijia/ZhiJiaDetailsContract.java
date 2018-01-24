package com.gs.gscartoon.zhijia;


import com.gs.gscartoon.BasePresenter;
import com.gs.gscartoon.BaseView;
import com.gs.gscartoon.zhijia.bean.ZhiJiaDetailsBean;
import com.gs.gscartoon.zhijia.bean.ZhiJiaListBean;

import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface ZhiJiaDetailsContract {

    interface View extends BaseView<Presenter> {
        void updateDetails(ZhiJiaDetailsBean bean);
        void getDetailsFailure();
    }

    interface Presenter extends BasePresenter {
        void getDetails(String id);
    }
}
