package com.gs.gscartoon.wangyi;


import com.gs.gscartoon.BasePresenter;
import com.gs.gscartoon.BaseView;
import com.gs.gscartoon.wangyi.bean.WangYiBrowseBean;

import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface WangYiBrowseContract {

    interface View extends BaseView<Presenter> {
        void showRefreshData(List<WangYiBrowseBean.DataBean.ImageListBean> mData);
        void refreshDataFailure();

        void setTitle(String title);
    }

    interface Presenter extends BasePresenter {
        void refreshData(String comicId, String chapterId, String comicTitle, String coverUrl);
    }
}
