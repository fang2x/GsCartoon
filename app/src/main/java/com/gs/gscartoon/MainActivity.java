package com.gs.gscartoon;

import android.os.Build;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;

import com.gs.gscartoon.kuaikan.model.KuaiKanModel;
import com.gs.gscartoon.kuaikan.presenter.KuaiKanPresenter;
import com.gs.gscartoon.kuaikan.view.KuaiKanFragment;
import com.gs.gscartoon.utils.ActivityUtil;
import com.gs.gscartoon.utils.LightStatusBarUtil;
import com.gs.gscartoon.utils.StatusBarUtil;
import com.gs.gscartoon.utils.ToastUtil;
import com.gs.gscartoon.utils.ToolbarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.dl_left_main)
    DrawerLayout dlLeftMain;
    @BindView(R.id.tb_main)
    Toolbar tbToolbar;

    private KuaiKanPresenter mKuaiKanPresenter;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupWindowAnimations();
        StatusBarUtil.enableTranslucentStatusBar(this);
        //LightStatusBarUtil.setLightStatusBar(this, true);
        unbinder = ButterKnife.bind(this);

        initView();
    }

    private void initView(){
        ToolbarUtil.initToolbar(this, tbToolbar);
        ToolbarUtil.actionBarDrawerToggle(this, dlLeftMain, tbToolbar);

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
        unbinder.unbind();
    }

    private void setupWindowAnimations() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition transition = TransitionInflater.from(this)
                    .inflateTransition(R.transition.activity_explode);
            getWindow().setEnterTransition(transition);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        if(item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private long mExitTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {//
                // 如果两次按键时间间隔大于2000毫秒，则不退出
                ToastUtil.showToastShort(R.string.press_again_to_exit);
                mExitTime = System.currentTimeMillis();// 更新mExitTime
            } else {
                finish();
                //System.exit(0);// 否则退出程序
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
