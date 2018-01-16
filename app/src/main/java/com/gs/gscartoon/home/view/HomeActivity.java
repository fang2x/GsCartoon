package com.gs.gscartoon.home.view;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.gs.gscartoon.R;
import com.gs.gscartoon.kuaikan.model.KuaiKanModel;
import com.gs.gscartoon.kuaikan.presenter.KuaiKanPresenter;
import com.gs.gscartoon.kuaikan.view.KuaiKanFragment;
import com.gs.gscartoon.manman.model.ManManModel;
import com.gs.gscartoon.manman.presenter.ManManPresenter;
import com.gs.gscartoon.manman.view.ManManFragment;
import com.gs.gscartoon.utils.ActivityUtil;
import com.gs.gscartoon.utils.StatusBarUtil;
import com.gs.gscartoon.utils.ToastUtil;
import com.gs.gscartoon.utils.ToolbarUtil;
import com.gs.gscartoon.zhijia.model.ZhiJiaModel;
import com.gs.gscartoon.zhijia.presenter.ZhiJiaPresenter;
import com.gs.gscartoon.zhijia.view.ZhiJiaFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeActivity extends AppCompatActivity implements
        View.OnClickListener{
    private static final String TAG = "HomeActivity";

    @BindView(R.id.dl_left_main)
    DrawerLayout dlLeftMain;
    @BindView(R.id.tb_main)
    Toolbar tbToolbar;
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.ll_kuaikan)
    LinearLayout llKuaiKan;
    @BindView(R.id.ll_zhijia)
    LinearLayout llZhiJia;
    @BindView(R.id.ll_manman)
    LinearLayout llManMan;

    private static final int FRAGMENT_COUNT = 3;
    private static final int KUAI_KAN_FRAGMENT_INDEX = 0;//快看Fragment索引
    private static final int ZHI_JIA_FRAGMENT_INDEX = 1;//之家Fragment索引
    private static final int MAN_MAN_FRAGMENT_INDEX = 2;//漫漫Fragment索引

    private KuaiKanFragment mKuaiKanFragment;
    private KuaiKanPresenter mKuaiKanPresenter;
    private ManManFragment mManManFragment;
    private ManManPresenter mManManPresenter;
    private ZhiJiaFragment mZhiJiaFragment;
    private ZhiJiaPresenter mZhiJiaPresenter;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupWindowAnimations();
        StatusBarUtil.enableTranslucentStatusBar(this);
        //LightStatusBarUtil.setLightStatusBar(this, true);
        unbinder = ButterKnife.bind(this);

        initView();
    }

    private void initView(){
        ToolbarUtil.initToolbar(this, tbToolbar);
        ToolbarUtil.actionBarDrawerToggle(this, dlLeftMain, tbToolbar);

        llKuaiKan.setOnClickListener(this);
        llZhiJia.setOnClickListener(this);
        llManMan.setOnClickListener(this);

        setFragment(KUAI_KAN_FRAGMENT_INDEX);//默认打开快看
    }

    private void setFragment(int index){
        Fragment fragment =
                (Fragment) mFragmentStatePagerAdapter.instantiateItem(flContent, index);
        mFragmentStatePagerAdapter.setPrimaryItem(flContent, 0, fragment);
        mFragmentStatePagerAdapter.finishUpdate(flContent);
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

    FragmentStatePagerAdapter mFragmentStatePagerAdapter =
            new FragmentStatePagerAdapter(getSupportFragmentManager()) {
                @Override
                public Fragment getItem(int position) {
                    Fragment fragment = null;
                    switch (position) {
                        case KUAI_KAN_FRAGMENT_INDEX://快看
                            if(mKuaiKanFragment == null){
                                mKuaiKanFragment = KuaiKanFragment.newInstance();
                            }
                            if(mKuaiKanPresenter == null) {
                                mKuaiKanPresenter = new KuaiKanPresenter(
                                        new KuaiKanModel(getApplicationContext()), mKuaiKanFragment);
                            }
                            fragment = mKuaiKanFragment;
                            break;
                        case ZHI_JIA_FRAGMENT_INDEX://之家
                            if(mZhiJiaFragment == null){
                                mZhiJiaFragment = ZhiJiaFragment.newInstance();
                            }
                            if(mZhiJiaPresenter == null) {
                                mZhiJiaPresenter = new ZhiJiaPresenter(
                                        new ZhiJiaModel(getApplicationContext()), mZhiJiaFragment);
                            }
                            fragment = mZhiJiaFragment;
                            break;
                        case MAN_MAN_FRAGMENT_INDEX://漫漫
                            if(mManManFragment == null){
                                mManManFragment = ManManFragment.newInstance();
                            }
                            if(mManManPresenter == null) {
                                mManManPresenter = new ManManPresenter(
                                        new ManManModel(getApplicationContext()), mManManFragment);
                            }
                            fragment = mManManFragment;
                            break;
                        default:
                            break;
                    }
                    return fragment;
                }

                @Override
                public int getCount() {
                    return FRAGMENT_COUNT;
                }
            };

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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_kuaikan:
                setFragment(KUAI_KAN_FRAGMENT_INDEX);
                dlLeftMain.closeDrawers();
                break;
            case R.id.ll_zhijia:
                setFragment(ZHI_JIA_FRAGMENT_INDEX);
                dlLeftMain.closeDrawers();
                break;
            case R.id.ll_manman:
                setFragment(MAN_MAN_FRAGMENT_INDEX);
                dlLeftMain.closeDrawers();
                break;
            default:
                break;
        }
    }
}
