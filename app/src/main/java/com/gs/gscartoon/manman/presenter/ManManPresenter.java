package com.gs.gscartoon.manman.presenter;

import com.gs.gscartoon.manman.ManManContract;
import com.gs.gscartoon.manman.model.ManManModel;

/**
 * Created by camdora on 17-11-22.
 */

public class ManManPresenter implements ManManContract.Presenter {
    private static final String TAG = "ManManPresenter";

    private final ManManModel mManManModel;
    private final ManManContract.View mManManView;

    public ManManPresenter(ManManModel model, ManManContract.View view){
        mManManModel = model;

        mManManView = view;
        mManManView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }
}
