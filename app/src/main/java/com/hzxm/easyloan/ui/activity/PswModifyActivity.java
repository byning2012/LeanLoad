package com.hzxm.easyloan.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hzxm.easyloan.MyApplication;
import com.hzxm.easyloan.R;
import com.hzxm.easyloan.presenter.implPresenter.ModifyPswPresenter;
import com.hzxm.easyloan.presenter.implView.IPswModifyView;
import com.hzxm.easyloan.utils.Constant;
import com.lmz.baselibrary.ui.BaseActivity;
import com.lmz.baselibrary.util.AppActivityManager;
import com.lmz.baselibrary.util.SharedPreferencesUtil;
import com.lmz.baselibrary.widget.ClearEditText;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 密码修改
 */
public class PswModifyActivity extends BaseActivity implements IPswModifyView {

    @BindView(R.id.et_old_psw)
    ClearEditText etOldPsw;
    @BindView(R.id.et_new_psw)
    ClearEditText etNewPsw;
    @BindView(R.id.et_sure_psw)
    ClearEditText etSurePsw;
    @BindView(R.id.btn_complete)
    Button btnVerification;
    @BindView(R.id.tv_forget_psw)
    TextView tvForgetPsw;
    @BindView(R.id.activity_psw_modify)
    LinearLayout activityPswModify;
    private ModifyPswPresenter mModifyPswPresenter;
    private int uid;
    private String hashid;

    @Override
    protected void initConvetView(Bundle saveInstanceState) {
        setContentView(R.layout.activity_psw_modify);
    }

    @Override
    protected void initView(Bundle saveInstanceState) {
        SetStatusBarColor(R.color.transparent_white);
    }

    @Override
    protected void initData() {
        mModifyPswPresenter = new ModifyPswPresenter(this);
        uid = SharedPreferencesUtil.getInstance(MyApplication.getContext()).getInt(Constant.UID, -1);
        hashid = SharedPreferencesUtil.getInstance(MyApplication.getContext()).getString(Constant.HASH_ID, "");
    }

    /**
     * 完成
     */
    @OnClick(R.id.btn_complete)
    public void complete() {
        String oldPsw = etOldPsw.getText().toString().trim();
        String newPsw = etNewPsw.getText().toString().trim();
        String surePsw = etSurePsw.getText().toString().trim();
        if (TextUtils.isEmpty(oldPsw)) {
            showToast("原密码不能为空", Toast.LENGTH_SHORT);
            return;
        }
        if (TextUtils.isEmpty(newPsw)) {
            showToast("新密码不能为空", Toast.LENGTH_SHORT);
            return;
        }
        if (TextUtils.isEmpty(surePsw)) {
            showToast("确认密码不能为空", Toast.LENGTH_SHORT);
            return;
        }
        if (newPsw.length() < 8) {
            showToast("密码长度需大于8位", Toast.LENGTH_SHORT);
            return;
        }
        if (surePsw.length() < 8) {
            showToast("密码长度需大于8位", Toast.LENGTH_SHORT);
            return;
        }

        if (!newPsw.equals(surePsw)) {
            showToast("两次输入的密码不相同", Toast.LENGTH_SHORT);
            return;
        }
        mModifyPswPresenter.updataPsw(uid + "", hashid, oldPsw, newPsw, surePsw);
    }

    /**
     * 忘记密码
     */
    @OnClick(R.id.tv_forget_psw)
    public void forgetPsw() {
        startActivity(FindPswActivity.class);
    }

    /**
     * 修改成功
     */
    @Override
    public void modifySuccess() {
        AppActivityManager.getAppManager().finishActivity(this);
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
        showToast(error, Toast.LENGTH_SHORT);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mModifyPswPresenter.unsubcrible();
    }
}
