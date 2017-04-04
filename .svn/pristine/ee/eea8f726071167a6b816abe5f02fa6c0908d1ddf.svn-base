package com.hzxm.easyloan.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hzxm.easyloan.MainActivity;
import com.hzxm.easyloan.R;
import com.lmz.baselibrary.ui.BaseActivity;
import com.lmz.baselibrary.util.AppActivityManager;
import com.lmz.baselibrary.widget.TitleLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 还款申请结果
 */
public class RepaymentApplicationActivity extends BaseActivity {

    @BindView(R.id.title)
    TitleLayout title;
    @BindView(R.id.iv_result)
    ImageView ivResult;
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.activity_loan_application)
    LinearLayout activityLoanApplication;

    @Override
    protected void initConvetView(Bundle saveInstanceState) {
        setContentView(R.layout.activity_repayment_application);
    }

    @Override
    protected void initView(Bundle saveInstanceState) {

    }

    @Override
    protected void initData() {
        title.setOnBackButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RepaymentApplicationActivity.this, MainActivity.class);
                intent.putExtra("ok", true);
                startActivity(intent);
                AppActivityManager.getAppManager().finishActivity(RepaymentActivity.class);
                AppActivityManager.getAppManager().finishActivity(RepaymentApplicationActivity.this);
            }
        });
    }

    @OnClick(R.id.btn_next)
    public void completeBtn() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("ok", true);
        startActivity(intent);
        AppActivityManager.getAppManager().finishActivity(RepaymentActivity.class);
        AppActivityManager.getAppManager().finishActivity(this);
    }
}
