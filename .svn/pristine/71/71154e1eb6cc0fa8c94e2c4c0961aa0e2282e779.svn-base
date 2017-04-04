package com.hzxm.easyloan.ui.activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hzxm.easyloan.R;
import com.hzxm.easyloan.model.RecodeModel;
import com.hzxm.easyloan.presenter.implPresenter.FindPswPresenter;
import com.hzxm.easyloan.presenter.implView.IFindPswView;
import com.hzxm.easyloan.utils.Constant;
import com.lmz.baselibrary.ui.BaseActivity;
import com.lmz.baselibrary.util.StringUtils;
import com.lmz.baselibrary.widget.ClearEditText;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * 找回密码
 */
public class FindPswActivity extends BaseActivity implements IFindPswView {


    @BindView(R.id.et_num)
    ClearEditText etNum;
    @BindView(R.id.tv_verification_code)
    TextView tvVerificationCode;
    @BindView(R.id.et_verification_code)
    ClearEditText etVerificationCode;
    @BindView(R.id.btn_verification)
    Button btnVerification;
    @BindView(R.id.activity_find_psw)
    LinearLayout activityFindPsw;

    @BindColor(R.color.home_blue)
    int mBlueColor;

    private String from = "";

    //计时器
    private TimeCount timeCount;


    private FindPswPresenter mFindPswPresenter;

    protected static String RECODE_ID = "RECODE_ID";

    @Override
    protected void initConvetView(Bundle saveInstanceState) {
        setContentView(R.layout.activity_find_psw);
    }

    @Override
    protected void initView(Bundle saveInstanceState) {
    }

    @Override
    protected void initData() {
        mFindPswPresenter = new FindPswPresenter(this);
    }

    /**
     * 发送验证码
     */
    @OnClick(R.id.tv_verification_code)
    public void sendCode() {
        String phoneNum = etNum.getText().toString().trim();
        if (isPhone(phoneNum)) {
            mFindPswPresenter.sendcode(phoneNum, "2");
        }

    }

    private boolean isPhone(String phoneNum) {
        if (TextUtils.isEmpty(phoneNum)) {
            showToast("手机号码不能为空", Toast.LENGTH_SHORT);
            return false;
        }
        if (!StringUtils.isPhone(phoneNum)) {
            showToast("手机号码错误", Toast.LENGTH_SHORT);
            return false;
        }
        return true;
    }

    /**
     * 跳转到重置密码
     */
    @OnClick(R.id.btn_verification)
    public void verification() {
        String phoneNum = etNum.getText().toString().trim();
        String code = etVerificationCode.getText().toString().trim();
        if (isPhone(phoneNum)) {
            if (!"".equals(code)) {
                mFindPswPresenter.recode(code, phoneNum);
            } else {
                showToast("验证码不能为空", Toast.LENGTH_SHORT);
            }
        }
    }


    @Override
    public void showSuccess() {
        timeCount = new TimeCount(60000, 1000);//构造CountDownTimer对象
        timeCount.start();
    }

    /**
     * 验证短信成功 返回短信码  跳转到重置密码
     *
     * @param recodeModel
     */
    @Override
    public void getRecodeId(RecodeModel recodeModel) {
        Bundle bundle = new Bundle();
        bundle.putString(RECODE_ID, recodeModel.getdata());
        bundle.putString(Constant.UID, recodeModel.getUid());
        startActivity(ResetPswActivity.class, bundle);
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


    /**
     * 计时器
     * millisInFuture  总时长
     * countDownInterval 计时间隔
     */
    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            tvVerificationCode.setClickable(false);
            tvVerificationCode.setText(millisUntilFinished / 1000 + "秒");
        }

        @Override
        public void onFinish() {
            tvVerificationCode.setTextColor(mBlueColor);
            tvVerificationCode.setText("重新验证");
            tvVerificationCode.setClickable(true);
        }
    }

    @Override
    protected void onDestroy() {
        mFindPswPresenter.unsubcrible();
        super.onDestroy();
    }
}
