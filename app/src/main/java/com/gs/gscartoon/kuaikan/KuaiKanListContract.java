package com.gs.gscartoon.kuaikan;


import com.gs.gscartoon.BasePresenter;
import com.gs.gscartoon.BaseView;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface KuaiKanListContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {

    }
}
