package com.gs.gscartoon.kuaikan.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


import com.gs.gscartoon.R;
import com.gs.gscartoon.kuaikan.KuaiKanBrowseContract;
import com.gs.gscartoon.kuaikan.adapter.KuaiKanBrowseRecyclerAdapter;
import com.gs.gscartoon.kuaikan.model.KuaiKanBrowseModel;
import com.gs.gscartoon.kuaikan.presenter.KuaiKanBrowsePresenter;
import com.gs.gscartoon.utils.AppConstants;
import com.gs.gscartoon.utils.StatusBarUtil;
import com.gs.gscartoon.utils.ToolbarUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class KuaiKanBrowseActivity extends AppCompatActivity implements KuaiKanBrowseContract.View{
    private static final String TAG = "KuaiKanBrowseActivity";

    @BindView(R.id.tb_kuai_kan_browse)
    Toolbar tbToolbar;
    @BindView(R.id.rv_kuai_kan_browse)
    RecyclerView mRecyclerView;

    private KuaiKanBrowseContract.Presenter mPresenter;
    private KuaiKanBrowseRecyclerAdapter mRecyclerAdapter;
    private Unbinder unbinder;
    private String mId;//漫画Id

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuai_kan_browse);

        StatusBarUtil.enableTranslucentStatusBar(this);
        unbinder = ButterKnife.bind(this);
        initView();
    }

    private void initView(){
        ToolbarUtil.initToolbar(this, tbToolbar);

        mId = getIntent().getStringExtra(AppConstants.ID);

        // Create the presenter
        new KuaiKanBrowsePresenter(
                new KuaiKanBrowseModel(getApplicationContext()), this);

        mRecyclerAdapter = new KuaiKanBrowseRecyclerAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.refreshData(mId);
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
    public void setPresenter(KuaiKanBrowseContract.Presenter presenter) {
        mPresenter = presenter;
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

    @Override
    public void showRefreshData(List<String> mData) {
        mRecyclerAdapter.clear();
        mRecyclerAdapter.addItems(mData);
        mRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void refreshDataFailure() {

    }
}
