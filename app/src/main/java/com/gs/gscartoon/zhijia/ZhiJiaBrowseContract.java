package com.gs.gscartoon.zhijia;


import com.gs.gscartoon.BasePresenter;
import com.gs.gscartoon.BaseView;

import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface ZhiJiaBrowseContract {

    interface View extends BaseView<Presenter> {
        void showRefreshData(List<String> mData);
        void refreshDataFailure();

        void setTitle(String title);
    }

    interface Presenter extends BasePresenter {
        void refreshData(String comicId, String chapterId, String comicTitle, String coverUrl);
    }
}
