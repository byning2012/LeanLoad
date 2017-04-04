package com.hzxm.easyloan.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.LinearLayout;

import com.hzxm.easyloan.R;
import com.lmz.baselibrary.ui.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 认证中心
 */
public class CertificationCenterActivity extends BaseActivity {


    @BindView(R.id.cv_base_certification)
    CardView cvBaseCertification;
    @BindView(R.id.cv_promotion_certification)
    CardView cvPromotionCertification;
    @BindView(R.id.activity_certification_center)
    LinearLayout activityCertificationCenter;

    @Override
    protected void initConvetView(Bundle saveInstanceState) {
        setContentView(R.layout.activity_certification_center);
    }

    @Override
    protected void initView(Bundle saveInstanceState) {
        SetStatusBarColor(R.color.transparent_white);
    }

    @Override
    protected void initData() {

    }

    /**
     * 基础额度认证
     */
    @OnClick(R.id.cv_base_certification)
    public void baseCertification() {
        startActivity(BaseCertificationActivity.class);
    }

    /**
     * 提额认证
     */
    @OnClick(R.id.cv_promotion_certification)
    public void promotionCertification() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("From_Certification", true);
        startActivity(IncreaseAmountActivity.class, bundle);
    }
}
