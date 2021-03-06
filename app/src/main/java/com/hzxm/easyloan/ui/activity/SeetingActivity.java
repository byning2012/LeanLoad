package com.hzxm.easyloan.ui.activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hzxm.easyloan.R;
import com.hzxm.easyloan.presenter.implPresenter.SeetingPresenter;
import com.hzxm.easyloan.presenter.implView.ISeetingView;
import com.hzxm.easyloan.utils.Constant;
import com.lmz.baselibrary.listener.IPermissionResultListener;
import com.lmz.baselibrary.ui.BaseActivity;
import com.lmz.baselibrary.util.AppActivityManager;
import com.lmz.baselibrary.util.DataCleanManager;
import com.lmz.baselibrary.util.LogUtil;
import com.lmz.baselibrary.util.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 设置界面
 */
public class SeetingActivity extends BaseActivity implements ISeetingView {

    @BindView(R.id.tv_psw_modify)
    TextView tvPswModify;
    @BindView(R.id.tv_feedback)
    TextView tvFeedback;
    @BindView(R.id.tv_call_phone)
    TextView tvCallPhone;
    @BindView(R.id.rl_call_phone)
    RelativeLayout rlCallPhone;
    @BindView(R.id.tv_about_us)
    TextView tvAboutUs;
    @BindView(R.id.btn_exit_login)
    Button btnExitLogin;
    @BindView(R.id.activity_seeting)
    LinearLayout activitySeeting;
    private SeetingPresenter mSeetingPresenter;

    @Override
    protected void initConvetView(Bundle saveInstanceState) {
        setContentView(R.layout.activity_seeting);
    }

    @Override
    protected void initView(Bundle saveInstanceState) {
        SetStatusBarColor(R.color.transparent_white);
    }

    @Override
    protected void initData() {
        mSeetingPresenter = new SeetingPresenter(this);
        mSeetingPresenter.systemTelMsg();
    }

    /**
     * 密码修改
     */
    @OnClick(R.id.tv_psw_modify)
    public void modifyPsw() {
        startActivity(PswModifyActivity.class);
    }

    /**
     * 意见反馈
     */
    @OnClick(R.id.tv_feedback)
    public void feedBack() {
        startActivity(FeedbackActivity.class);
    }

    /**
     * 拨打电话
     */
    @OnClick(R.id.rl_call_phone)
    public void callPhone() {
        if (!"".equals(tvCallPhone.getText().toString().trim())) {
            showDialog();
        }

    }

    /**
     * 关于我们
     */
    @OnClick(R.id.tv_about_us)
    public void aboutUs() {
        mSeetingPresenter.systemAboutUs();
    }

    /**
     * 退出登录
     */
    @OnClick(R.id.btn_exit_login)
    public void exitLoin() {
        DataCleanManager.clearAllCache(this);
        SharedPreferencesUtil.getInstance(getApplicationContext()).removeKey(Constant.IS_LOGIN);
        SharedPreferencesUtil.getInstance(getApplicationContext()).removeKey(Constant.UID);
        SharedPreferencesUtil.getInstance(getApplicationContext()).removeKey(Constant.HASH_ID);
        startActivity(LoginActivity.class);
        AppActivityManager.getAppManager().finishAllActivity();
    }

    public void showDialog() {
        final Dialog dialog = new Dialog(this, R.style.dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = getLayoutInflater().inflate(R.layout.dialog_call_phone, null);
        Button mCallPhoneBtn = (Button) view.findViewById(R.id.btn_call_phone);
        mCallPhoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                permissionRequest("是否允许拨打电话权限", new String[]{Manifest.permission.CALL_PHONE}, 101,
                        new IPermissionResultListener() {
                            @Override
                            public void onPermissionSuccess() {
                                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + tvCallPhone.getText().toString().trim()));
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                dialog.dismiss();
                            }

                            @Override
                            public void onPermissionFaild() {
                                dialog.dismiss();
                            }
                        });
            }
        });
        RelativeLayout mDeleteRl = (RelativeLayout) view.findViewById(R.id.rl_delete);
        mDeleteRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.gravity = Gravity.CENTER;
        dialog.onWindowAttributesChanged(wl);
        dialog.show();
    }

    @Override
    public void tel(String tel) {
        tvCallPhone.setText(tel.trim());
    }

    @Override
    public void aboutUs(String msg) {
        Bundle bundle = new Bundle();
        bundle.putString("content", msg);
        startActivity(AboutUsActivity.class, bundle);
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
        LogUtil.e(error);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSeetingPresenter.unsubcrible();
    }
}
