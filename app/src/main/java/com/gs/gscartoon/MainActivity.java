package com.gs.gscartoon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gs.gscartoon.kuaikan.model.KuaiKanModel;
import com.gs.gscartoon.kuaikan.presenter.KuaiKanPresenter;
import com.gs.gscartoon.kuaikan.view.KuaiKanFragment;
import com.gs.gscartoon.utils.ActivityUtil;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private KuaiKanPresenter mKuaiKanPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        KuaiKanFragment tasksFragment = (KuaiKanFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fl_content);

        if (tasksFragment == null) {
            // Create the fragment
            tasksFragment = KuaiKanFragment.newInstance();
            ActivityUtil.addFragmentToActivity(
                    getSupportFragmentManager(), tasksFragment, R.id.fl_content);
        }

        // Create the presenter
        mKuaiKanPresenter = new KuaiKanPresenter(new KuaiKanModel(getApplicationContext()), tasksFragment);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
