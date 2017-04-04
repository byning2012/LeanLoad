package com.hzxm.easyloan.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hzxm.easyloan.MyApplication;
import com.hzxm.easyloan.R;
import com.hzxm.easyloan.model.mine.AmountCreateModel;
import com.hzxm.easyloan.presenter.implPresenter.AddContactsPresenter;
import com.hzxm.easyloan.presenter.implView.IAddContactsView;
import com.hzxm.easyloan.utils.Constant;
import com.lmz.baselibrary.ui.BaseActivity;
import com.lmz.baselibrary.util.AppActivityManager;
import com.lmz.baselibrary.util.LogUtil;
import com.lmz.baselibrary.util.SharedPreferencesUtil;
import com.lmz.baselibrary.util.StringUtils;
import com.lmz.baselibrary.widget.ClearEditText;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 添加联系人
 */
public class AddContactsActivity extends BaseActivity implements IAddContactsView {

    @BindView(R.id.et_father_name)
    ClearEditText etFatherName;
    @BindView(R.id.et_father_tel)
    ClearEditText etFatherTel;
    @BindView(R.id.et_mother_name)
    ClearEditText etMotherName;
    @BindView(R.id.et_mother_tel)
    ClearEditText etMotherTel;
    @BindView(R.id.et_counselor_name)
    ClearEditText etCounselorName;
    @BindView(R.id.et_counselor_tel)
    ClearEditText etCounselorTel;
    @BindView(R.id.et_classmates_name)
    ClearEditText etClassmatesName;
    @BindView(R.id.et_classmates_tel)
    ClearEditText etClassmatesTel;
    @BindView(R.id.btn_submit)
    Button btnSubmit;
    @BindView(R.id.activity_add_contacts)
    LinearLayout activityAddContacts;
    private AmountCreateModel.DataEntity.InfoEntity.ConnectPersionEntity.FatherEntity mFatherEntity;
    private AmountCreateModel.DataEntity.InfoEntity.ConnectPersionEntity.MotherEntity mMotherEntity;
    private AmountCreateModel.DataEntity.InfoEntity.ConnectPersionEntity.StudentEntity mSudentEntity;
    private AmountCreateModel.DataEntity.InfoEntity.ConnectPersionEntity.TeacherEntity mTeacherEntity;

    private AddContactsPresenter mAddContactsPresenter;
    private int uid;

    @Override
    protected void initConvetView(Bundle saveInstanceState) {
        setContentView(R.layout.activity_add_contacts);
    }

    @Override
    protected void initView(Bundle saveInstanceState) {
        SetStatusBarColor(R.color.transparent_white);
    }

    @Override
    protected void initData() {
        try {
            mFatherEntity = getIntent().getExtras().getParcelable("father");
            mMotherEntity = getIntent().getExtras().getParcelable("mother");
            mSudentEntity = getIntent().getExtras().getParcelable("student");
            mTeacherEntity = getIntent().getExtras().getParcelable("teacher");
            etFatherName.setText(mFatherEntity.getName());
            etFatherName.setSelection(mFatherEntity.getName().length());
            etFatherTel.setText(mFatherEntity.getTel());
            etMotherName.setText(mMotherEntity.getName());
            etMotherTel.setText(mMotherEntity.getTel());
            etCounselorName.setText(mTeacherEntity.getName());
            etCounselorTel.setText(mTeacherEntity.getTel());
            etClassmatesName.setText(mSudentEntity.getName());
            etClassmatesTel.setText(mSudentEntity.getTel());
        } catch (NullPointerException e) {
            LogUtil.e("空指针");
        }
        uid = SharedPreferencesUtil.getInstance(MyApplication.getContext()).getInt(Constant.UID, -1);
        mAddContactsPresenter = new AddContactsPresenter(this);

    }

    @OnClick(R.id.btn_submit)
    public void submit() {
        String mFatherName = etFatherName.getText().toString().trim();
        String mFatherTel = etFatherTel.getText().toString().trim();
        String mMotherName = etMotherName.getText().toString().trim();
        String mMotherTel = etMotherTel.getText().toString().trim();
        String mCounselorName = etCounselorName.getText().toString().trim();
        String mCounselorTel = etCounselorTel.getText().toString().trim();
        String mClassmatesName = etClassmatesName.getText().toString().trim();
        String mClassmatesTel = etClassmatesTel.getText().toString().trim();
        if ("".equals(mFatherName)) {
            showToast("请输入父亲名字", Toast.LENGTH_SHORT);
            return;
        }
        if ("".equals(mFatherTel)) {
            showToast("请输入父亲电话", Toast.LENGTH_SHORT);
            return;
        }
        if (!StringUtils.isPhone(mFatherTel)) {
            showToast("父亲电话有误", Toast.LENGTH_SHORT);
            return;
        }
        if ("".equals(mMotherName)) {
            showToast("请输入母亲名字", Toast.LENGTH_SHORT);
            return;
        }
        if ("".equals(mMotherTel)) {
            showToast("请输入母亲电话", Toast.LENGTH_SHORT);
            return;
        }
        if (!StringUtils.isPhone(mMotherTel)) {
            showToast("母亲电话有误", Toast.LENGTH_SHORT);
            return;
        }
        if ("".equals(mCounselorName)) {
            showToast("请输入辅导员名字", Toast.LENGTH_SHORT);
            return;
        }
        if ("".equals(mCounselorTel)) {
            showToast("请输入辅导员电话", Toast.LENGTH_SHORT);
            return;
        }
        if (!StringUtils.isPhone(mCounselorTel)) {
            showToast("辅导员电话有误", Toast.LENGTH_SHORT);
            return;
        }
        if ("".equals(mClassmatesName)) {
            showToast("请输入同学名字", Toast.LENGTH_SHORT);
            return;
        }
        if ("".equals(mClassmatesTel)) {
            showToast("请输入同学电话", Toast.LENGTH_SHORT);
            return;
        }
        if (!StringUtils.isPhone(mClassmatesTel)) {
            showToast("同学电话有误", Toast.LENGTH_SHORT);
            return;
        }
        JSONObject studentJson = new JSONObject();
        JSONObject teacherJson = new JSONObject();
        JSONObject motherJson = new JSONObject();
        JSONObject fatherJson = new JSONObject();
        try {
            studentJson.put("name", mClassmatesName);
            studentJson.put("tel", mClassmatesTel);
            studentJson.put("relative", "student");
            teacherJson.put("name", mCounselorName);
            teacherJson.put("tel", mCounselorTel);
            teacherJson.put("relative", "teacher");
            motherJson.put("name", mMotherName);
            motherJson.put("tel", mMotherTel);
            motherJson.put("relative", "mother");
            fatherJson.put("name", mFatherName);
            fatherJson.put("tel", mFatherTel);
            fatherJson.put("relative", "father");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mAddContactsPresenter.addContacts(uid + "", studentJson.toString(), teacherJson.toString(), motherJson.toString(), fatherJson.toString());
    }

    @Override
    public void addSuccess() {
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
}
