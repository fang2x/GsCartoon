package com.gs.gscartoon.wangyi.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.gs.gscartoon.R;
import com.gs.gscartoon.utils.AppConstants;
import com.gs.gscartoon.utils.StatusBarUtil;
import com.gs.gscartoon.utils.ToolbarUtil;
import com.gs.gscartoon.wangyi.WangYiBrowseContract;
import com.gs.gscartoon.wangyi.adapter.WangYiBrowseRecyclerAdapter;
import com.gs.gscartoon.wangyi.bean.WangYiBrowseBean;
import com.gs.gscartoon.wangyi.model.WangYiBrowseModel;
import com.gs.gscartoon.wangyi.presenter.WangYiBrowsePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class WangYiBrowseActivity extends AppCompatActivity implements WangYiBrowseContract.View,
        View.OnClickListener{
    private static final String TAG = "WangYiBrowseActivity";

    @BindView(R.id.tb_wang_yi_browse)
    Toolbar tbToolbar;
    @BindView(R.id.rv_wang_yi_browse)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_toolbar_wang_yi_browse_title)
    TextView tvTitle;

    private WangYiBrowseContract.Presenter mPresenter;
    private WangYiBrowseRecyclerAdapter mRecyclerAdapter;
    private Unbinder unbinder;
    private String mChapterId;//某一话漫画Id
    private String mComicId;//漫画Id
    private String mComicTitle;//漫画Title
    private String mCoverUrl;//封面url

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wang_yi_browse);

        setupWindowAnimations();
        StatusBarUtil.enableTranslucentStatusBar(this);
        unbinder = ButterKnife.bind(this);
        initView();
    }

    private void initView(){
        ToolbarUtil.initToolbar(this, tbToolbar);

        mChapterId = getIntent().getStringExtra(AppConstants.CHAPTER_ID);
        mComicId = getIntent().getStringExtra(AppConstants.COMIC_ID);
        mComicTitle = getIntent().getStringExtra(AppConstants.COMIC_TITLE);
        mCoverUrl = getIntent().getStringExtra(AppConstants.COVER_URL);

        // Create the presenter
        new WangYiBrowsePresenter(
                new WangYiBrowseModel(getApplicationContext()), this);

        mRecyclerAdapter = new WangYiBrowseRecyclerAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);//must store the new intent unless getIntent() will return the old one
        mChapterId = getIntent().getStringExtra(AppConstants.CHAPTER_ID);
        mComicId = getIntent().getStringExtra(AppConstants.COMIC_ID);
        mComicTitle = getIntent().getStringExtra(AppConstants.COMIC_TITLE);
        mCoverUrl = getIntent().getStringExtra(AppConstants.COVER_URL);
    }

    private void setupWindowAnimations() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition transition = TransitionInflater.from(this)
                    .inflateTransition(R.transition.activity_slide_right);
            getWindow().setEnterTransition(transition);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.refreshData(mComicId, mChapterId, mComicTitle, mCoverUrl);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        mPresenter.destroy();
    }

    @Override
    public void setPresenter(WangYiBrowseContract.Presenter presenter) {
        mPresenter = presenter;
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

    @Override
    public void showRefreshData(List<WangYiBrowseBean.DataBean.ImageListBean> mData) {
        mRecyclerAdapter.clear();
        mRecyclerAdapter.addItems(mData);
        mRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void refreshDataFailure() {

    }

    @Override
    public void setTitle(String title) {
        if(tvTitle != null){
            tvTitle.setText(title);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_toolbar_wang_yi_browse_title:

                break;
            default:
                break;
        }
    }
}
