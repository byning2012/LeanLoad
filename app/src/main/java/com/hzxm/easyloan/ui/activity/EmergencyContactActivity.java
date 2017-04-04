package com.hzxm.easyloan.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hzxm.easyloan.MyApplication;
import com.hzxm.easyloan.R;
import com.hzxm.easyloan.model.mine.BaseCertificationModel;
import com.hzxm.easyloan.presenter.implPresenter.EmergContactPresenter;
import com.hzxm.easyloan.presenter.implView.IEmergencyContactView;
import com.hzxm.easyloan.utils.Constant;
import com.lmz.baselibrary.ui.BaseActivity;
import com.lmz.baselibrary.util.AppActivityManager;
import com.lmz.baselibrary.util.LogUtil;
import com.lmz.baselibrary.util.SharedPreferencesUtil;
import com.lmz.baselibrary.widget.ClearEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 紧急联系人
 */
public class EmergencyContactActivity extends BaseActivity implements IEmergencyContactView {

    @BindView(R.id.et_relationship)
    ClearEditText etRelationship;
    @BindView(R.id.et_name)
    ClearEditText etName;
    @BindView(R.id.et_tel_num)
    ClearEditText etTelNum;
    @BindView(R.id.et_relationship2)
    ClearEditText etRelationship2;
    @BindView(R.id.et_name2)
    ClearEditText etName2;
    @BindView(R.id.et_tel_num2)
    ClearEditText etTelNum2;
    @BindView(R.id.activity_emergency_contact)
    LinearLayout activityEmergencyContact;
    @BindView(R.id.btn_submit)
    Button btnSubmit;

    private int uid;

    //    private BaseCertificationModel.DataEntity.ConnectEntity.UrgentTelEntity mConnectEntity;
//    private BaseCertificationModel.DataEntity.ConnectEntity.UrgentTelEntity mConnectEntity2;
    private List<BaseCertificationModel.DataEntity.ConnectEntity.UrgentTelEntity> mConnectEntity;
    private int status;

    private EmergContactPresenter mEmergContactPresenter;


    @Override
    protected void initConvetView(Bundle saveInstanceState) {
        setContentView(R.layout.activity_emergency_contact);
    }

    @Override
    protected void initView(Bundle saveInstanceState) {
        SetStatusBarColor(R.color.transparent_white);
    }

    @Override
    protected void initData() {
        try {
            // mConnectEntity = getIntent().getExtras().getParcelable("emergency");
            //    mConnectEntity2 = getIntent().getExtras().getParcelable("emergency2");
            mConnectEntity = getIntent().getExtras().getParcelableArrayList("emergency");
            status = getIntent().getExtras().getInt("status");
            etRelationship.setText(mConnectEntity.get(0).getRelative());
            etName.setText(mConnectEntity.get(0).getName());
            etTelNum.setText(mConnectEntity.get(0).getTel());

            etRelationship2.setText(mConnectEntity.get(1).getRelative());
            etName2.setText(mConnectEntity.get(1).getName());
            etTelNum2.setText(mConnectEntity.get(1).getTel());

            if (status == 1) {
                etRelationship.setFocusable(false);
                etRelationship.setClearIconVisible(false);
                etName.setFocusable(false);
                etName.setClearIconVisible(false);
                etTelNum.setFocusable(false);
                etTelNum.setClearIconVisible(false);
                etRelationship2.setFocusable(false);
                etRelationship2.setClearIconVisible(false);
                etName2.setFocusable(false);
                etName2.setClearIconVisible(false);
                etTelNum2.setFocusable(false);
                etTelNum2.setClearIconVisible(false);
                btnSubmit.setVisibility(View.GONE);
            } else {
                etRelationship.setSelection(mConnectEntity.get(0).getRelative().length());
            }

        } catch (NullPointerException e) {
            LogUtil.e("空指针了");
        }
        uid = SharedPreferencesUtil.getInstance(MyApplication.getContext()).getInt(Constant.UID, -1);
        mEmergContactPresenter = new EmergContactPresenter(this);
    }

    @OnClick(R.id.btn_submit)
    public void submit() {
        String relative = etRelationship.getText().toString().trim();
        String name = etName.getText().toString().trim();
        String tel = etTelNum.getText().toString().trim();
        String relative2 = etRelationship2.getText().toString().trim();
        String name2 = etName2.getText().toString().trim();
        String tel2 = etTelNum2.getText().toString().trim();
        if ("".equals(relative) || "".equals(name) || "".equals(tel) ||
                "".equals(relative2) || "".equals(name2) || "".equals(tel2)) {
            showToast("信息填写不全", Toast.LENGTH_SHORT);
            return;
        } else if (relative.equals(relative2)) {
            showToast("联系人关系不可相同", Toast.LENGTH_SHORT);
            return;
        } else if (tel.equals(tel2)) {
            showToast("联系人电话不可相同", Toast.LENGTH_SHORT);
            return;
        } else {
            List<JSONObject> urgent = new ArrayList<>();
            JSONObject jsonObject = new JSONObject();
            JSONObject jsonObject2 = new JSONObject();
            try {
                jsonObject.put("relative", relative);
                jsonObject.put("name", name);
                jsonObject.put("tel", tel);
                jsonObject2.put("relative", relative2);
                jsonObject2.put("name", name2);
                jsonObject2.put("tel", tel2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            urgent.add(jsonObject);
            urgent.add(jsonObject2);
            mEmergContactPresenter.addUrgent(uid + "", urgent.toString());
        }

    }


    @Override
    public void addSuccess() {
        setResult(103);
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
        LogUtil.e(error);
        showToast(error, Toast.LENGTH_SHORT);
    }

}
