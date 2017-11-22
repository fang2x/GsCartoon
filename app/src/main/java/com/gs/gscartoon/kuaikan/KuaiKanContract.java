package com.gs.gscartoon.kuaikan;


import com.gs.gscartoon.BasePresenter;
import com.gs.gscartoon.BaseView;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface KuaiKanContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        boolean isActive();
    }

    interface Presenter extends BasePresenter {

        void result(int requestCode, int resultCode);
    }
}
