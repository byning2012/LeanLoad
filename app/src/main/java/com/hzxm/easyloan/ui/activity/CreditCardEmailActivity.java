package com.hzxm.easyloan.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hzxm.easyloan.R;
import com.lmz.baselibrary.ui.BaseActivity;
import com.lmz.baselibrary.widget.ClearEditText;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * 信用卡邮箱
 */
public class CreditCardEmailActivity extends BaseActivity {

    @BindView(R.id.tv_remind)
    TextView tvRemind;
    @BindView(R.id.iv_delete)
    ImageView ivDelete;
    @BindView(R.id.ll_top_remind)
    LinearLayout llTopRemind;
    @BindView(R.id.et_account)
    ClearEditText etAccount;
    @BindView(R.id.et_psw)
    ClearEditText etPsw;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.cb_choose)
    CheckBox cbChoose;
    @BindView(R.id.activity_education_info)
    LinearLayout activityEducationInfo;

    @BindString(R.string.top_remind_msg_upload)
    String mTopRemind;

    @Override
    protected void initConvetView(Bundle saveInstanceState) {
        setContentView(R.layout.activity_credit_card_email);
    }

    @Override
    protected void initView(Bundle saveInstanceState) {
        SetStatusBarColor(R.color.transparent_white);
        tvRemind.setText(mTopRemind);
    }

    @Override
    protected void initData() {

    }

    //关闭头部警告蓝
    @OnClick(R.id.iv_delete)
    public void closeTop() {
        llTopRemind.setVisibility(View.GONE);
    }

}
