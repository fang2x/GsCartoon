package com.gs.gscartoon.zhijia;


import com.gs.gscartoon.BasePresenter;
import com.gs.gscartoon.BaseView;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface ZhiJiaContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {

    }
}
