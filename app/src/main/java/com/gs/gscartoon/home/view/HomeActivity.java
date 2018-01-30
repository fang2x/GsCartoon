package com.gs.gscartoon.home.view;

import android.animation.Animator;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gs.gscartoon.R;
import com.gs.gscartoon.history.view.HistoryActivity;
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
    @BindView(R.id.rl_kuaikan)
    RelativeLayout rlKuaiKan;
    @BindView(R.id.rl_zhijia)
    RelativeLayout rlZhiJia;
    @BindView(R.id.rl_manman)
    RelativeLayout rlManMan;
    @BindView(R.id.sdv_launcher)
    SimpleDraweeView sdvLauncher;
    @BindView(R.id.tv_history)
    TextView tvHistory;
    @BindView(R.id.tv_favorite)
    TextView tvFavorite;
    @BindView(R.id.tv_about)
    TextView tvAbout;

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

        rlKuaiKan.setOnClickListener(this);
        rlZhiJia.setOnClickListener(this);
        rlManMan.setOnClickListener(this);
        tvHistory.setOnClickListener(this);
        tvFavorite.setOnClickListener(this);
        tvAbout.setOnClickListener(this);
        sdvLauncher.setOnClickListener(this);

        sdvLauncher.setImageURI(Uri.parse("res://"+
                this.getPackageName()+"/" + R.drawable.ic_launcher));

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
            finishAfterTransition();
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
        Intent intent;
        ActivityOptionsCompat options;
        switch (v.getId()){
            case R.id.rl_kuaikan:
                setFragment(KUAI_KAN_FRAGMENT_INDEX);
                dlLeftMain.closeDrawers();
                animateRevealColorFromCoordinates(flContent, 0, (int)rlKuaiKan.getY()+rlKuaiKan.getHeight()/2);
                break;
            case R.id.rl_zhijia:
                setFragment(ZHI_JIA_FRAGMENT_INDEX);
                dlLeftMain.closeDrawers();
                animateRevealColorFromCoordinates(flContent, 0, (int)rlZhiJia.getY()+rlZhiJia.getHeight()/2);
                break;
            case R.id.rl_manman:
                setFragment(MAN_MAN_FRAGMENT_INDEX);
                dlLeftMain.closeDrawers();
                animateRevealColorFromCoordinates(flContent, 0, (int)rlManMan.getY()+rlManMan.getHeight()/2);
                break;
            case R.id.tv_history:
                intent = new Intent(HomeActivity.this, HistoryActivity.class);
                options = ActivityOptionsCompat.makeSceneTransitionAnimation(HomeActivity.this,
                                tvHistory, getString(R.string.transition_name_history_title));
                startActivity(intent, options.toBundle());
                break;
            case R.id.tv_favorite:
                break;
            case R.id.tv_about:
                break;
            case R.id.sdv_launcher:
                break;
            default:
                break;
        }
    }

    private Animator animateRevealColorFromCoordinates(ViewGroup viewRoot, int x, int y) {
        float finalRadius = (float) Math.hypot(viewRoot.getWidth(), viewRoot.getHeight());

        Animator anim = ViewAnimationUtils.createCircularReveal(viewRoot, x, y, 0, finalRadius);
        anim.setDuration(600);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.start();
        return anim;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        //super.onSaveInstanceState(outState);//这里不保存数据,避免activity异常退出,在进入该activity时出现fragment重叠问题
    }
}
