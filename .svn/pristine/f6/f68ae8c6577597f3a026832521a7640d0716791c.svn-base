package com.hzxm.easyloan.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hzxm.easyloan.R;
import com.lmz.baselibrary.ui.BaseActivity;
import com.lmz.baselibrary.util.AppActivityManager;
import com.lmz.baselibrary.util.LogUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 审核结果
 */
public class AuditResultsActivity extends BaseActivity {

    @BindView(R.id.tv_audit_result)
    TextView tvAuditResult;
    @BindView(R.id.tv_audit_result_msg)
    TextView tvAuditResultMsg;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.activity_audit_results)
    LinearLayout activityAuditResults;

    String from;

    @Override
    protected void initConvetView(Bundle saveInstanceState) {
        setContentView(R.layout.activity_audit_results);
    }

    @Override
    protected void initView(Bundle saveInstanceState) {
        SetStatusBarColor(R.color.transparent_white);
        try {
            from = getIntent().getExtras().getString("from");
        } catch (NullPointerException e) {
            LogUtil.e(e.toString());
        }
    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.btn_complete)
    public void mComplete() {
        switch (from) {
            case "increaseAmount":
                AppActivityManager.getAppManager().finishActivity(IncreaseAmountActivity.class);
                break;
            case "baseCertification":
                AppActivityManager.getAppManager().finishActivity(BaseCertificationActivity.class);
                break;
        }
        AppActivityManager.getAppManager().finishActivity(this);
    }
}
