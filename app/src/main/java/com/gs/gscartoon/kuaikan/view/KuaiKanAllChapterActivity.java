package com.gs.gscartoon.kuaikan.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gs.gscartoon.R;
import com.gs.gscartoon.kuaikan.KuaiKanAllChapterContract;
import com.gs.gscartoon.kuaikan.adapter.KuaiKanAllChapterRecyclerAdapter;
import com.gs.gscartoon.kuaikan.bean.KuaiKanAllChapterBean.DataBean;
import com.gs.gscartoon.kuaikan.bean.KuaiKanAllChapterBean.DataBean.ComicsBean;
import com.gs.gscartoon.kuaikan.model.KuaiKanAllChapterModel;
import com.gs.gscartoon.kuaikan.presenter.KuaiKanAllChapterPresenter;
import com.gs.gscartoon.utils.AppConstants;
import com.gs.gscartoon.utils.LogUtil;
import com.gs.gscartoon.utils.StatusBarUtil;
import com.gs.gscartoon.utils.StringUtil;
import com.gs.gscartoon.utils.ToolbarUtil;
import com.gs.gscartoon.widget.view.MarqueTextView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class KuaiKanAllChapterActivity extends AppCompatActivity implements KuaiKanAllChapterContract.View,
        View.OnClickListener{
    private static final String TAG = "KuaiKanAllChapterActivity";

    @BindView(R.id.tb_kuai_kan_all_chapter)
    Toolbar tbToolbar;
    @BindView(R.id.rv_kuai_kan_all_chapter)
    RecyclerView mRecyclerView;
    @BindView(R.id.iv_cover)
    ImageView ivCover;
    @BindView(R.id.mtv_title)
    MarqueTextView mtvTitle;
    @BindView(R.id.tv_label)
    TextView tvLabel;
    @BindView(R.id.tv_view_count)
    TextView tvViewCount;

    private KuaiKanAllChapterContract.Presenter mPresenter;
    private KuaiKanAllChapterRecyclerAdapter mRecyclerAdapter;
    private Unbinder unbinder;
    private String mTopicId;//漫画Id

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuai_kan_all_chapter);

        StatusBarUtil.enableTranslucentStatusBar(this);
        unbinder = ButterKnife.bind(this);
        initView();
    }

    private void initView(){
        ToolbarUtil.initToolbar(this, tbToolbar);

        mTopicId = getIntent().getStringExtra(AppConstants.TOPIC_ID);

        // Create the presenter
        new KuaiKanAllChapterPresenter(
                new KuaiKanAllChapterModel(getApplicationContext()), this);

        mRecyclerAdapter = new KuaiKanAllChapterRecyclerAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerAdapter.setClickListener(new KuaiKanAllChapterRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                LogUtil.i(TAG,"点击item position="+position);
                ComicsBean bean = mRecyclerAdapter.getItemData(position);
                if(bean == null){
                    return;
                }
                Intent intent = new Intent(KuaiKanAllChapterActivity.this, KuaiKanBrowseActivity.class);
                intent.putExtra(AppConstants.COMICS_ID, bean.getId()+"");
                intent.putExtra(AppConstants.TOPIC_ID, mTopicId);
                startActivity(intent);
            }
        });

        ivCover.setColorFilter(Color.parseColor("#44000000"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.refreshData(mTopicId);
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
    public void setPresenter(KuaiKanAllChapterContract.Presenter presenter) {
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
    public void showRefreshData(List<ComicsBean> mData) {
        mRecyclerAdapter.clear();
        mRecyclerAdapter.addItems(mData);
        mRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void refreshDataFailure() {

    }

    @Override
    public void updateInfor(DataBean bean) {
        if(ivCover == null || mtvTitle == null || tvLabel == null || tvViewCount == null){
            return;
        }

        Picasso.with(this).load(bean.getCover_image_url()).placeholder(R.drawable.ic_kuaikan_default_image)
                .error(R.drawable.ic_kuaikan_default_image)
                .into(ivCover);
        mtvTitle.setText(bean.getTitle());
        if(bean.getLabel() != null) {
            tvLabel.setText(bean.getLabel().getText());
        }
        tvViewCount.setText("总热度" + StringUtil.getPrintHugeNumber(bean.getView_count()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_toolbar_kuai_kan_browse_all:
                break;
            default:
                break;
        }
    }
}
