package com.gs.gscartoon.history.presenter;


import com.gs.gscartoon.R;
import com.gs.gscartoon.history.HistoryContract;
import com.gs.gscartoon.history.model.HistoryModel;
import com.gs.gscartoon.utils.ToastUtil;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by camdora on 17-11-22.
 */

public class HistoryPresenter implements HistoryContract.Presenter {
    private static final String TAG = "HistoryPresenter";

    private final HistoryModel mHistoryModel;
    private final HistoryContract.View mHistoryView;
    private CompositeDisposable mCompositeDisposable;

    public HistoryPresenter(HistoryModel model, HistoryContract.View view){
        mHistoryModel = model;

        mHistoryView = view;
        mHistoryView.setPresenter(this);
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {
        mHistoryModel.closeRealm();
        if(mCompositeDisposable != null){
            mCompositeDisposable.clear();
        }
    }

    @Override
    public void refreshData() {
        mHistoryView.showRefreshData(mHistoryModel.refreshHistory());
    }

    @Override
    public void deleteData(String id) {
        if(mHistoryModel.deleteHistory(id)){
            mHistoryView.removeRecycleData();
            ToastUtil.showToastShort(R.string.successfully_deleted);
        }else {
            ToastUtil.showToastShort(R.string.failed_to_delete);
        }
    }
}
