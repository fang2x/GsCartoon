package com.gs.gscartoon.zhijia.view;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.gs.gscartoon.R;
import com.gs.gscartoon.utils.AppConstants;
import com.gs.gscartoon.utils.StatusBarUtil;
import com.gs.gscartoon.utils.TimeUtil;
import com.gs.gscartoon.utils.ToolbarUtil;
import com.gs.gscartoon.zhijia.ZhiJiaDetailsContract;
import com.gs.gscartoon.zhijia.bean.ZhiJiaDetailsBean;
import com.gs.gscartoon.zhijia.model.ZhiJiaDetailsModel;
import com.gs.gscartoon.zhijia.presenter.ZhiJiaDetailsPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ZhiJiaDetailsActivity extends AppCompatActivity
        implements ZhiJiaDetailsContract.View{
    private static final String TAG = "ZhiJiaDetailsActivity";

    @BindView(R.id.tb_zhi_jia_details)
    Toolbar tbToolbar;
    @BindView(R.id.tv_toolbar_zhi_jia_details_title)
    TextView tvTitle;
    @BindView(R.id.sdv_cover)
    SimpleDraweeView sdvCover;
    @BindView(R.id.tv_author)
    TextView tvAuthor;
    @BindView(R.id.tv_label)
    TextView tvLabel;
    @BindView(R.id.tv_view_count)
    TextView tvViewCount;
    @BindView(R.id.tv_subscribe_count)
    TextView tvSubscribeCount;
    @BindView(R.id.tv_time)
    TextView tvTime;

    private ZhiJiaDetailsContract.Presenter mPresenter;
    private Unbinder unbinder;
    private String mTopicId;//漫画Id

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhi_jia_details);

        StatusBarUtil.enableTranslucentStatusBar(this);
        unbinder = ButterKnife.bind(this);
        initView();
    }

    private void initView(){
        ToolbarUtil.initToolbar(this, tbToolbar);

        mTopicId = getIntent().getStringExtra(AppConstants.TOPIC_ID);

        // Create the presenter
        new ZhiJiaDetailsPresenter(
                new ZhiJiaDetailsModel(getApplicationContext()), this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.getDetails(mTopicId);
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
    public void setPresenter(ZhiJiaDetailsContract.Presenter presenter) {
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
    public void updateDetails(ZhiJiaDetailsBean bean) {
        if(tvTitle == null || sdvCover == null || tvAuthor == null ||
                tvLabel == null || tvViewCount == null || tvSubscribeCount == null ||
                tvTime == null){
            return;
        }

        tvTitle.setText(bean.getTitle());
        sdvCover.setImageURI(Uri.parse(bean.getCover()));
        tvViewCount.setText("人气：" + bean.getHot_num());
        tvSubscribeCount.setText("订阅：" + bean.getSubscribe_num());

        if(bean.getAuthors() != null) {
            StringBuffer str = new StringBuffer();
            str.append("作者：");
            for (ZhiJiaDetailsBean.AuthorsBean authorsBean : bean.getAuthors()){
                str.append(authorsBean.getTag_name()+" ");
            }
            tvAuthor.setText(str);
        }

        if(bean.getTypes() != null) {
            StringBuffer str = new StringBuffer();
            str.append("类型：");
            for (ZhiJiaDetailsBean.TypesBean typesBean : bean.getTypes()){
                str.append(typesBean.getTag_name()+" ");
            }
            tvLabel.setText(str);
        }

        if(bean.getStatus() != null){
            StringBuffer str = new StringBuffer();
            str.append("更新：" + TimeUtil.timestampToDate(bean.getLast_updatetime())+" ");
            for (ZhiJiaDetailsBean.StatusBean statusBean : bean.getStatus()){
                str.append(statusBean.getTag_name()+" ");
            }
            tvTime.setText(str);
        }
    }

    @Override
    public void getDetailsFailure() {

    }
}
