package com.hzxm.easyloan.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hzxm.easyloan.MyApplication;
import com.hzxm.easyloan.R;
import com.hzxm.easyloan.presenter.implPresenter.SocialSecurityPresenter;
import com.hzxm.easyloan.presenter.implView.ISocialSecurityView;
import com.hzxm.easyloan.utils.Constant;
import com.lmz.baselibrary.ui.BaseActivity;
import com.lmz.baselibrary.util.AppActivityManager;
import com.lmz.baselibrary.util.SharedPreferencesUtil;
import com.lmz.baselibrary.widget.ClearEditText;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 社保
 */
public class SocialSecurityActivity extends BaseActivity implements ISocialSecurityView {


    @BindView(R.id.tv_city)
    TextView tvCity;
    @BindView(R.id.rl_social_city)
    RelativeLayout rlSocialCity;
    @BindView(R.id.et_login_name)
    ClearEditText etLoginName;
    @BindView(R.id.et_login_psw)
    ClearEditText etLoginPsw;
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.activity_social_security)
    LinearLayout activitySocialSecurity;

    private SocialSecurityPresenter mSocialSecurityPresenter;

    private String areaId = "";
    private int uid;

    @Override
    protected void initConvetView(Bundle saveInstanceState) {
        setContentView(R.layout.activity_social_security);
    }

    @Override
    protected void initView(Bundle saveInstanceState) {
        SetStatusBarColor(R.color.transparent_white);
    }

    @Override
    protected void initData() {
        uid = SharedPreferencesUtil.getInstance(MyApplication.getContext()).getInt(Constant.UID, -1);
        mSocialSecurityPresenter = new SocialSecurityPresenter(this);
    }

    /**
     * 选择城市
     */
    @OnClick(R.id.rl_social_city)
    public void socialCity() {
        startActivityForResult(SocialSecurityCityActivity.class, 101);
    }

    /**
     * 提交社保信息
     */
    @OnClick(R.id.btn_next)
    public void next() {
        //     String city = tvCity.getText().toString().trim();
        String username = etLoginName.getText().toString().trim();
        String password = etLoginPsw.getText().toString().trim();
        if (TextUtils.isEmpty(areaId)) {
            showToast("请选择社保地区", Toast.LENGTH_SHORT);
            return;
        }
        if (TextUtils.isEmpty(username)) {
            showToast("请填写社保账号", Toast.LENGTH_SHORT);
            return;
        }
        if (TextUtils.isEmpty(password)) {
            showToast("请填写社保密码", Toast.LENGTH_SHORT);
            return;
        }
        mSocialSecurityPresenter.socalSearch(uid + "", areaId, username, password);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == 101) {
            tvCity.setText(data.getStringExtra("name"));
            areaId = data.getStringExtra("area");
    }
    }

    /**
     * 获取社保成功
     */
    @Override
    public void findSuccess(String token) {
        String username = etLoginName.getText().toString().trim();
        String password = etLoginPsw.getText().toString().trim();
        mSocialSecurityPresenter.socalResult(uid + "", token, username, password);
    }

    /**
     * 查找失败
     *
     * @param error
     */
    @Override
    public void findError(String error) {
        showToast("查询中请稍后再试,请确保地区正确", Toast.LENGTH_SHORT);
    }

    @Override
    public void resultSuccess() {
        showToast("资料提交成功", Toast.LENGTH_SHORT);
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
        mSocialSecurityPresenter.unsubcrible();
    }
}
