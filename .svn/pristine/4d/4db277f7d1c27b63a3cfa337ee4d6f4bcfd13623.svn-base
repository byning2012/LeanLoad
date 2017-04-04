package com.hzxm.easyloan.ui.activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hzxm.easyloan.R;
import com.hzxm.easyloan.model.mine.BaseCertificationModel;
import com.hzxm.easyloan.model.mine.ConstanctsModel;
import com.hzxm.easyloan.presenter.implPresenter.BaseCertifyPresenter;
import com.hzxm.easyloan.presenter.implView.IBaseCertificationView;
import com.hzxm.easyloan.utils.Constant;
import com.hzxm.easyloan.utils.NeedPermissionUtils;
import com.lmz.baselibrary.listener.IPermissionResultListener;
import com.lmz.baselibrary.ui.BaseActivity;
import com.lmz.baselibrary.util.LogUtil;
import com.lmz.baselibrary.util.SharedPreferencesUtil;
import com.lmz.baselibrary.util.glide.GliderHelper;
import com.lmz.baselibrary.widget.springview.container.LoanHeader;
import com.lmz.baselibrary.widget.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * 基础认证
 */
public class BaseCertificationActivity extends BaseActivity implements IBaseCertificationView, SpringView.OnFreshListener {
    @BindView(R.id.refresh_layout)
    SpringView mRefreshLayout;
    @BindView(R.id.tv_verified)
    TextView tvVerified;
    @BindView(R.id.rl_verified)
    RelativeLayout rlVerified;
    @BindView(R.id.tv_doc_upload)
    TextView tvDocUpload;
    @BindView(R.id.rl_doc_upload)
    RelativeLayout rlDocUpload;
    @BindView(R.id.tv_verified_state)
    TextView tvVerifiedState;
    @BindView(R.id.rl_sesame_points)
    RelativeLayout rlSesamePoints;
    @BindView(R.id.tv_phone_certification)
    TextView tvPhoneCertification;
    @BindView(R.id.rl_phone_certification)
    RelativeLayout rlPhoneCertification;
    @BindView(R.id.tv_emergency_contact)
    TextView tvEmergencyContact;
    @BindView(R.id.rl_emergency_contact)
    RelativeLayout rlEmergencyContact;
    @BindView(R.id.tv_reserved_bank_card)
    TextView tvReservedBankCard;
    @BindView(R.id.rl_reserved_bank_card)
    RelativeLayout rlReservedBankCard;
    @BindView(R.id.tv_now_address)
    TextView tvNowAddress;
    @BindView(R.id.rl_now_address)
    RelativeLayout rlNowAddress;
    @BindView(R.id.activity_base_certification)
    LinearLayout activityBaseCertification;

    public String isBaseCertifiActivity = "isBaseCertifiActivity";

    //已认证
    @BindString(R.string.already_verified)
    String mAleadyVerified;
    @BindString(R.string.verification_ok)
    String mVerificationOk;
    @BindView(R.id.btn_error)
    Button btnError;
    @BindView(R.id.error_page)
    LinearLayout errorPage;
    @BindView(R.id.iv_error_logo)
    ImageView mErrorView;
    @BindView(R.id.btn_submit)
    Button btnSubmit;

    private boolean isVerified = false;
    private boolean isUpload = false;


    private BaseCertifyPresenter mBaseCertifyPresenter;
    private int uid;

    // 1：申请认证，2认证通过，3认证失败，4未实名认证），在基础认证里面，只有在3的情况下才能修改
    private String status;


    //存储用户通讯录信息
    private List<ConstanctsModel> mConstancts;

    BaseCertificationModel baseCertificationModel;

    @Override
    protected void initConvetView(Bundle saveInstanceState) {
        setContentView(R.layout.activity_base_certification);
    }

    @Override
    protected void initView(Bundle saveInstanceState) {
        SetStatusBarColor(R.color.transparent_white);
        GliderHelper.loadImage(R.drawable.net_error, mErrorView, null);
        mRefreshLayout.setHeader(new LoanHeader());
        mRefreshLayout.setGive(SpringView.Give.TOP);
        mRefreshLayout.setListener(this);
    }

    @Override
    protected void initData() {
        uid = SharedPreferencesUtil.getInstance(getApplicationContext()).getInt(Constant.UID, -1);
        mBaseCertifyPresenter = new BaseCertifyPresenter(this, uid);
        mBaseCertifyPresenter.baseInfoData(uid);
    }

    /**
     * 提交资料
     */
    @OnClick(R.id.btn_submit)
    public void submit() {
        if ("3".equals(baseCertificationModel.getData().getStatus())) {
            mBaseCertifyPresenter.submitInfo(uid, "3");
        } else if ("1".equals(baseCertificationModel.getData().getStatus())) {
            showToast("资料审核中，请勿重复提交", Toast.LENGTH_SHORT);
        } else if ("2".equals(baseCertificationModel.getData().getStatus())) {
            btnSubmit.setVisibility(View.GONE);
        }
    }

    /**
     * 加载失败 点击刷新
     */
    @OnClick(R.id.btn_error)
    public void errorRefreshLayout() {
        mBaseCertifyPresenter.baseInfoData(uid);
    }

    /**
     * 实名认证,证件上传
     */
    @OnClick({R.id.rl_verified, R.id.rl_doc_upload, R.id.rl_phone_certification, R.id.rl_reserved_bank_card
            , R.id.rl_emergency_contact, R.id.rl_now_address})
    public void verified(RelativeLayout rl) {
        if ("2".equals(status)) {
            showToast(mVerificationOk, Toast.LENGTH_SHORT);
            return;
        }
        Bundle bundle = new Bundle();
        if (baseCertificationModel == null) {
            return;
        }
        switch (rl.getId()) {
            case R.id.rl_verified:   //实名认证
                if (isVerified) {
                    bundle.putInt(isBaseCertifiActivity, 1);
                    bundle.putParcelable("shiming", baseCertificationModel.getData().getShiming());
                    startActivityForResult(VerifiedActivity.class, bundle, 101);
                } else {
                    bundle.putInt(isBaseCertifiActivity, 1);
                    startActivityForResult(VerifiedActivity.class, bundle, 101);
                }
                break;
            case R.id.rl_doc_upload:  //证件上传
                if (isUpload) {
                    bundle.putInt(isBaseCertifiActivity, 1);
                    bundle.putParcelable("zhengjian", baseCertificationModel.getData().getZhenjian());
                    startActivityForResult(DocUploadActivity.class, bundle, 102);
                } else {
                    bundle.putInt(isBaseCertifiActivity, 1);
                    startActivityForResult(DocUploadActivity.class, bundle, 102);
                }
                break;
            case R.id.rl_phone_certification://手机认证
                if (baseCertificationModel.getData().getTel_sure().getStatus() != 1) {
                    showContactsDialog();
                } else {
                    showToast("您已通过认证，无需修改", Toast.LENGTH_SHORT);
                }
                // startActivity(PhoneCertificationActivity.class);
                break;
            case R.id.rl_reserved_bank_card: //预留银行卡
                startActivity(BankCarManagerActivity.class);
                break;
            case R.id.rl_emergency_contact://紧急联系人
                if (baseCertificationModel.getData().getConnect() != null) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelableArrayList("emergency", (ArrayList<? extends Parcelable>) baseCertificationModel.getData().getConnect().getUrgent_tel());
                    bundle2.putInt("status", baseCertificationModel.getData().getConnect().getStatus());
                    startActivityForResult(EmergencyContactActivity.class, bundle2, 103);
                } else {
                    startActivityForResult(EmergencyContactActivity.class, 103);
                }
                break;
            case R.id.rl_now_address://现住地址
                Bundle bundle1 = new Bundle();
                bundle1.putInt("status", baseCertificationModel.getData().getAddress().getStatus());
                startActivityForResult(CurrentAddressActivity.class, bundle1, 104);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == 101) { //实名验证返回
            mBaseCertifyPresenter.baseInfoData(uid);
        }
        if (requestCode == 102 && resultCode == 102) { //上传证件
            mBaseCertifyPresenter.baseInfoData(uid);
        }
        if (requestCode == 103 && resultCode == 103) {//添加紧急联系人返回
            mBaseCertifyPresenter.baseInfoData(uid);
        }
        if (requestCode == 104 && resultCode == 104) {//添加地址
            mBaseCertifyPresenter.baseInfoData(uid);
        }
    }

    /**
     * 请求成功
     *
     * @param baseCertificationModel
     */
    @Override
    public void data(BaseCertificationModel baseCertificationModel) {
        this.baseCertificationModel = baseCertificationModel;
        mRefreshLayout.onFinishFreshAndLoad();
        activityBaseCertification.setVisibility(View.VISIBLE);
        errorPage.setVisibility(View.GONE);
        if (baseCertificationModel.getData().getShiming().getStatus() == 1) {
            tvVerified.setText("已认证");
            isVerified = true;
        }
        if (baseCertificationModel.getData().getZhenjian().getStatus() == 1) {
            tvDocUpload.setText("已认证");
            isUpload = true;
        }
        if (baseCertificationModel.getData().getZhima().getStatus() == 1) {
            tvVerifiedState.setText(baseCertificationModel.getData().getZhima().getCredit_score());
        }
        if (baseCertificationModel.getData().getTel_sure().getStatus() == 1) {
            tvPhoneCertification.setText("已认证");
        }
        if (baseCertificationModel.getData().getConnect().getStatus() == 1) {
            tvEmergencyContact.setText("已认证");
        }
        if (baseCertificationModel.getData().getBanck_card().getStatus() == 1) {
            tvReservedBankCard.setText("已认证");
        }
        if (baseCertificationModel.getData().getAddress().getStatus() == 1) {
            tvNowAddress.setText(baseCertificationModel.getData().getAddress().getAddress());
        }
    }

    /**
     * 提交审核信息成功
     */
    @Override
    public void submitSuccess() {
        Bundle bundle = new Bundle();
        bundle.putString("from", "baseCertification");
        startActivity(AuditResultsActivity.class);
    }


    /**
     * 询问用户是否可以访问通讯录
     */
    public void showContactsDialog() {
        final Dialog dialog = new Dialog(this, R.style.dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_contacts, null);
        view.findViewById(R.id.rl_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        view.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        //同意访问
        view.findViewById(R.id.btn_aggree).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                permissionRequest("是否允许访问通讯录信息", new String[]{Manifest.permission.READ_CONTACTS}
                        , 101, new IPermissionResultListener() {
                            @Override
                            public void onPermissionSuccess() {
                                dialog.dismiss();
                                NeedPermissionUtils utils = new NeedPermissionUtils();
                                mConstancts = utils.GetConstanctsInfo(BaseCertificationActivity.this);
                                LogUtil.e("TAG--->" + mConstancts.size());
                            }

                            @Override
                            public void onPermissionFaild() {
                                dialog.dismiss();
                            }
                        });
            }
        });
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        WindowManager.LayoutParams wl = window.getAttributes();
        window.setGravity(Gravity.CENTER);
        dialog.onWindowAttributesChanged(wl);
        dialog.show();
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
        mRefreshLayout.onFinishFreshAndLoad();
        activityBaseCertification.setVisibility(View.GONE);
        errorPage.setVisibility(View.VISIBLE);
//        showToast(error, Toast.LENGTH_SHORT);
    }

    @Override
    public void onRefresh() {
        mBaseCertifyPresenter.baseInfoData(uid);
    }

    @Override
    public void onLoadmore() {

    }

}
