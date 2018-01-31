package com.gs.gscartoon.wangyi;


import com.gs.gscartoon.BasePresenter;
import com.gs.gscartoon.BaseView;
import com.gs.gscartoon.wangyi.bean.WangYiCategoryBean;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface WangYiContract {

    interface View extends BaseView<Presenter> {
        void getCategorySuccess(WangYiCategoryBean bean);
        void getCategoryFailure();
    }

    interface Presenter extends BasePresenter {
        void getCategory();
    }
}
