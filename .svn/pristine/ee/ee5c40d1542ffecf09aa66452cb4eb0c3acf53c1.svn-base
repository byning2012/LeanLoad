package com.hzxm.easyloan.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.hzxm.easyloan.MyApplication;
import com.hzxm.easyloan.R;
import com.hzxm.easyloan.adapter.mine.SocialCityAdapter;
import com.hzxm.easyloan.model.mine.SocialCityModel;
import com.hzxm.easyloan.presenter.implPresenter.SocialCityPresenter;
import com.hzxm.easyloan.presenter.implView.ISocialCityView;
import com.hzxm.easyloan.utils.Constant;
import com.hzxm.easyloan.widget.HorizontalDecoration;
import com.lmz.baselibrary.ui.BaseActivity;
import com.lmz.baselibrary.util.AppActivityManager;
import com.lmz.baselibrary.util.SharedPreferencesUtil;
import com.lmz.baselibrary.util.glide.GliderHelper;

import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;
import ca.barrenechea.widget.recyclerview.decoration.StickyHeaderDecoration;

/**
 * 社保地区选择
 */
public class SocialSecurityCityActivity extends BaseActivity implements ISocialCityView {

    @BindView(R.id.rv_social_city)
    RecyclerView rvSocialCity;
    @BindView(R.id.activity_social_security_city)
    LinearLayout activitySocialSecurityCity;

    @BindView(R.id.iv_error_logo)
    ImageView ivErrorLogo;
    @BindView(R.id.btn_error)
    Button btnError;
    @BindView(R.id.error_page)
    LinearLayout errorPage;

    private SocialCityPresenter mSocialCityPresenter;
    private SocialCityAdapter mSocialCityAdapter;
    private int uid;
    private View EmptyView;

    @BindString(R.string.no_find_area)
    String noAreaMsg;

    @Override
    protected void initConvetView(Bundle saveInstanceState) {
        setContentView(R.layout.activity_social_security_city);
    }

    @Override
    protected void initView(Bundle saveInstanceState) {
        SetStatusBarColor(R.color.transparent_white);
        rvSocialCity.setLayoutManager(new LinearLayoutManager(this));
        rvSocialCity.addItemDecoration(new HorizontalDecoration(this, LinearLayoutManager.VERTICAL));
        EmptyView = getLayoutInflater().inflate(R.layout.empty_repayment_list, (ViewGroup) rvSocialCity.getParent(), false);
        ((TextView) EmptyView.findViewById(R.id.tv_msg)).setText(noAreaMsg);

        GliderHelper.loadImage(R.drawable.net_error, ivErrorLogo, null);
    }

    @Override
    protected void initData() {
        uid = SharedPreferencesUtil.getInstance(MyApplication.getContext()).getInt(Constant.UID, -1);
        mSocialCityPresenter = new SocialCityPresenter(this, this);
        mSocialCityAdapter = mSocialCityPresenter.getAdapter();
        mSocialCityPresenter.socalArea(uid);
        StickyHeaderDecoration decor = new StickyHeaderDecoration(mSocialCityAdapter);
        rvSocialCity.setAdapter(mSocialCityAdapter);
        rvSocialCity.addItemDecoration(decor, 1);
        rvSocialCity.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                List<SocialCityModel.DataEntityX.DataEntity> data = baseQuickAdapter.getData();
                Intent intent = new Intent();
                intent.putExtra("name", data.get(i).getAreaName());
                intent.putExtra("area", data.get(i).getAreaCode());
                setResult(101, intent);
                AppActivityManager.getAppManager().finishActivity(SocialSecurityCityActivity.this);
            }
        });
    }

    @OnClick(R.id.btn_error)
    public void errorBtn() {
        mSocialCityPresenter.socalArea(uid);
    }


    @Override
    public void showProgressDialog() {
        createLoadingDialog();
    }

    @Override
    public void hiteProgressDialog() {
        cancleDialog();
    }

    @Override
    public void showError(String error) {
        rvSocialCity.setVisibility(View.GONE);
        errorPage.setVisibility(View.VISIBLE);
    }

    @Override
    public void emptyView() {
        mSocialCityAdapter.setEmptyView(EmptyView);
    }

    @Override
    public void success() {
        rvSocialCity.setVisibility(View.VISIBLE);
        errorPage.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSocialCityPresenter.unsubcrible();
    }
}
