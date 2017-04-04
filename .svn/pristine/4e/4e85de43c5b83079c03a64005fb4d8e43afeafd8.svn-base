package com.hzxm.easyloan.ui.activity;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hzxm.easyloan.R;
import com.hzxm.easyloan.model.mine.AmountCreateModel;
import com.hzxm.easyloan.presenter.implPresenter.RelatedOtherPresenter;
import com.hzxm.easyloan.presenter.implView.IRelatedOtherDataView;
import com.hzxm.easyloan.utils.Constant;
import com.lmz.baselibrary.listener.IPermissionResultListener;
import com.lmz.baselibrary.ui.BaseActivity;
import com.lmz.baselibrary.util.AppActivityManager;
import com.lmz.baselibrary.util.LogUtil;
import com.lmz.baselibrary.util.SharedPreferencesUtil;
import com.lmz.baselibrary.util.glide.GliderHelper;
import com.lmz.baselibrary.widget.ClearEditText;
import com.lmz.baselibrary.widget.TitleLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.model.PhotoInfo;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import top.zibin.luban.Luban;

/**
 * 相关资料 以及 其他资料
 */
public class RelatedOtherDataActivity extends BaseActivity implements
        IPermissionResultListener,
        GalleryFinal.OnHanlderResultCallback,
        IRelatedOtherDataView {

    @BindView(R.id.title)
    TitleLayout title;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.iv_updata1)
    ImageView ivUpdata1;
    @BindView(R.id.iv_compilete1)
    ImageView ivCompilete1;
    @BindView(R.id.tv_compilete1)
    TextView tvCompilete1;
    @BindView(R.id.tv_uploading1)
    TextView tvUploading1;
    @BindView(R.id.pb_uploading1)
    ProgressBar pbUploading1;
    @BindView(R.id.rl_updata1)
    RelativeLayout rlUpdata1;
    @BindView(R.id.tv_one)
    TextView tvOne;
    @BindView(R.id.iv_updata2)
    ImageView ivUpdata2;
    @BindView(R.id.iv_compilete2)
    ImageView ivCompilete2;
    @BindView(R.id.tv_compilete2)
    TextView tvCompilete2;
    @BindView(R.id.tv_uploading2)
    TextView tvUploading2;
    @BindView(R.id.pb_uploading2)
    ProgressBar pbUploading2;
    @BindView(R.id.rl_updata2)
    RelativeLayout rlUpdata2;
    @BindView(R.id.tv_two)
    TextView tvTwo;
    @BindView(R.id.iv_updata3)
    ImageView ivUpdata3;
    @BindView(R.id.iv_compilete3)
    ImageView ivCompilete3;
    @BindView(R.id.tv_compilete3)
    TextView tvCompilete3;
    @BindView(R.id.tv_uploading3)
    TextView tvUploading3;
    @BindView(R.id.pb_uploading3)
    ProgressBar pbUploading3;
    @BindView(R.id.rl_updata3)
    RelativeLayout rlUpdata3;
    @BindView(R.id.tv_three)
    TextView tvThree;
    @BindView(R.id.btn_complete)
    Button btnComplete;
    @BindView(R.id.activity_related_other_data)
    LinearLayout activityRelatedOtherData;
    @BindView(R.id.et_doc_name)
    ClearEditText etDocName;
    //头部提示栏
    @BindView(R.id.tv_remind)
    TextView tvRemind;
    @BindView(R.id.iv_delete)
    ImageView ivDelete;
    @BindView(R.id.ll_top_remind)
    LinearLayout llTopRemind;

    //设置头部警告栏
    @BindString(R.string.top_remind)
    String mTopRemind;

    //选择上传图片的顺序 左面第一个为1
    private int type = 1;
    private int finalType = 1;
    private String mOnePath, mTwoPath, mThreePath;

    private int uid;
    private String hashid;
    private DocumentPopupWindow popupWindow;

    private RelatedOtherPresenter mRelatedOtherPresenter;
    private AmountCreateModel.DataEntity.InfoEntity.InterfixEntity mInfoEntity;
    private List<AmountCreateModel.DataEntity.InfoEntity.InterfixEntity.InterfixImgEntity> mImgs;
    private AmountCreateModel.DataEntity.OtherMenuEntity OtherMenuEntity;
    private List<AmountCreateModel.DataEntity.OtherMenuEntity.OtherImage> mOtherImgs;


    private boolean isBaseEntity = true;

    private int menu_type;

    @Override
    protected void initConvetView(Bundle saveInstanceState) {
        setContentView(R.layout.activity_related_other_data);
    }

    @Override
    protected void initView(Bundle saveInstanceState) {
        SetStatusBarColor(R.color.transparent_white);
        uid = SharedPreferencesUtil.getInstance(getApplicationContext()).getInt(Constant.UID, -1);
        hashid = SharedPreferencesUtil.getInstance(getApplicationContext()).getString(Constant.HASH_ID, "");
        tvRemind.setText(mTopRemind);
        try {
            isBaseEntity = getIntent().getExtras().getBoolean("type");
            if (isBaseEntity) { //相关证件
                mInfoEntity = getIntent().getExtras().getParcelable("interfix");
                mImgs = getIntent().getExtras().getParcelableArrayList("img");
                title.setTitle("相关资料");
                etDocName.setText(mInfoEntity.getInterfix_name());
                etDocName.setSelection(mInfoEntity.getInterfix_name().length());
                mOnePath = mImgs.get(0).getImage();
                mTwoPath = mImgs.get(1).getImage();
                mThreePath = mImgs.get(2).getImage();
                GliderHelper.loadImage(mOnePath, ivUpdata1, null);
                GliderHelper.loadImage(mTwoPath, ivUpdata2, null);
                GliderHelper.loadImage(mThreePath, ivUpdata3, null);
            } else {//其他资料
                Bundle bundle = getIntent().getExtras();
                OtherMenuEntity = bundle.getParcelable("other");
                menu_type = getIntent().getExtras().getInt("menu_type");  //用户的类型
                mOtherImgs = getIntent().getExtras().getParcelableArrayList("img");
                title.setTitle(OtherMenuEntity.getName());
                if (mOtherImgs != null) {
                    etDocName.setText(OtherMenuEntity.getName());
                    etDocName.setFocusable(false);
                    etDocName.setClearIconVisible(false);
                    mOnePath = mOtherImgs.get(0).getImage();
                    mTwoPath = mOtherImgs.get(1).getImage();
                    mThreePath = mOtherImgs.get(2).getImage();
                    GliderHelper.loadImage(mOnePath, ivUpdata1, null);
                    GliderHelper.loadImage(mTwoPath, ivUpdata2, null);
                    GliderHelper.loadImage(mThreePath, ivUpdata3, null);
                }

            }
        } catch (NullPointerException e) {
            LogUtil.e("空指针");
        }


    }

    @Override
    protected void initData() {
        mRelatedOtherPresenter = new RelatedOtherPresenter(this);
    }

    /**
     * 关闭头部警告栏
     */
    @OnClick(R.id.iv_delete)
    public void closeTop() {
        llTopRemind.setVisibility(View.GONE);
    }

    /**
     * 点击完成按钮
     */
    @OnClick(R.id.btn_complete)
    public void completeBtn() {
        if ("".equals(mOnePath)) {
            showToast("请上传第一张图片", Toast.LENGTH_SHORT);
            return;
        }
        if ("".equals(mTwoPath)) {
            showToast("请上传第二张图片", Toast.LENGTH_SHORT);
            return;
        }
        if ("".equals(mThreePath)) {
            showToast("请上传第三张图片", Toast.LENGTH_SHORT);
            return;
        }
        String mDocName = etDocName.getText().toString().trim();
        if ("".equals(mDocName)) {
            showToast("请输入证件名称", Toast.LENGTH_SHORT);
            return;
        }
        List<JSONObject> mPics = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        JSONObject jsonObject3 = new JSONObject();
        try {
            jsonObject.put("name", "第一张");
            jsonObject.put("image", mOnePath);
            jsonObject2.put("name", "第二张");
            jsonObject2.put("image", mTwoPath);
            jsonObject3.put("name", "第三张");
            jsonObject3.put("image", mThreePath);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mPics.add(jsonObject);
        mPics.add(jsonObject2);
        if (!"".equals(mThreePath)) {
            mPics.add(jsonObject3);
        }
        if (isBaseEntity) { //相关证件
            mRelatedOtherPresenter.addInterfix(uid + "", mDocName, mPics.toString());
        } else {
            //其他资料
            if (OtherMenuEntity == null) {
                showToast("提交用户资料失败", Toast.LENGTH_SHORT);
                return;
            }
            mRelatedOtherPresenter.addOtherInfo(uid + "", mDocName, mPics.toString(), (menu_type + 1) + "", OtherMenuEntity.getId() + "");
        }

    }

    /**
     * 上传第一张图片
     */
    @OnClick({R.id.rl_updata1, R.id.rl_updata2, R.id.rl_updata3})
    public void upLoadPic1(RelativeLayout rl) {
        hideKeyboard(rl.getWindowToken());
        switch (rl.getId()) {
            case R.id.rl_updata1:
                type = 1;
                permissionRequest("是否允许凡易贷打开相机",
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                        101, RelatedOtherDataActivity.this);
                break;
            case R.id.rl_updata2:
                type = 2;
                permissionRequest("是否允许凡易贷打开相机",
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                        102, RelatedOtherDataActivity.this);
                break;
            case R.id.rl_updata3:
                type = 3;
                permissionRequest("是否允许凡易贷打开相机",
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                        103, RelatedOtherDataActivity.this);
                break;
        }
    }


    @Override
    public void onPermissionSuccess() {
        popupWindow = new DocumentPopupWindow(RelatedOtherDataActivity.this, rlUpdata1);
    }

    @Override
    public void onPermissionFaild() {

    }

    /**
     * 打开相机成功
     *
     * @param reqeustCode
     * @param resultList
     */
    @Override
    public void onHanlderSuccess(int reqeustCode, List<PhotoInfo> resultList) {
        String filePath = resultList.get(0).getPhotoPath();
        if ("".equals(filePath)) {
            showToast("SD卡错误", Toast.LENGTH_SHORT);
            return;
        }
        finalType = type;
        switch (type) {
            case 1:
                GliderHelper.loadImage(filePath, ivUpdata1, null);
                break;
            case 2:
                GliderHelper.loadImage(filePath, ivUpdata2, null);
                break;
            case 3:
                GliderHelper.loadImage(filePath, ivUpdata3, null);
                break;
        }
        File file = new File(filePath);
        /**
         * 压缩图片
         */
        Luban.get(RelatedOtherDataActivity.this)
                .load(file)
                .putGear(Luban.THIRD_GEAR)
                .asObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        LogUtil.e("压缩图片错误--》" + throwable.toString());
                    }
                })
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends File>>() {
                    @Override
                    public Observable<? extends File> call(Throwable throwable) {
                        return Observable.empty();
                    }
                })
                .subscribe(new Action1<File>() {
                    @Override
                    public void call(File file) {
                        redictionStatus();//更改状态
                        mRelatedOtherPresenter.uploadFace(file, uid + "", hashid, finalType);
                    }
                });
    }

    @Override
    public void onHanlderFailure(int requestCode, String errorMsg) {

    }

    /**
     * 当用户点击再次上传时  将pv和tv状态还原
     */
    public void redictionStatus() {
        switch (finalType) {
            case 1:
                ivCompilete1.setImageResource(R.drawable.updata_complete);
                ivCompilete1.setVisibility(View.GONE);
                tvCompilete1.setVisibility(View.GONE);
                pbUploading1.setVisibility(View.VISIBLE);
                tvUploading1.setVisibility(View.VISIBLE);
                break;
            case 2:
                ivCompilete2.setImageResource(R.drawable.updata_complete);
                ivCompilete2.setVisibility(View.GONE);
                tvCompilete2.setVisibility(View.GONE);
                pbUploading2.setVisibility(View.VISIBLE);
                tvUploading2.setVisibility(View.VISIBLE);
                break;
            case 3:
                ivCompilete3.setImageResource(R.drawable.updata_complete);
                ivCompilete3.setVisibility(View.GONE);
                tvCompilete3.setVisibility(View.GONE);
                pbUploading3.setVisibility(View.VISIBLE);
                tvUploading3.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void uploadSuccess(String path, int mtype) {
        switch (mtype) {
            case 1:
                mOnePath = path;
                ivCompilete1.setVisibility(View.VISIBLE);
                tvCompilete1.setVisibility(View.VISIBLE);
                tvCompilete1.setText(getString(R.string.upload_complete));
                pbUploading1.setVisibility(View.GONE);
                tvUploading1.setVisibility(View.GONE);
                break;
            case 2:
                mTwoPath = path;
                ivCompilete2.setVisibility(View.VISIBLE);
                tvCompilete2.setVisibility(View.VISIBLE);
                tvCompilete2.setText(getString(R.string.upload_complete));
                pbUploading2.setVisibility(View.GONE);
                tvUploading2.setVisibility(View.GONE);
                break;
            case 3:
                mThreePath = path;
                ivCompilete3.setVisibility(View.VISIBLE);
                tvCompilete3.setVisibility(View.VISIBLE);
                tvCompilete3.setText(getString(R.string.upload_complete));
                pbUploading3.setVisibility(View.GONE);
                tvUploading3.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void uploadPrograss(long hasWrittenLen, long totalLen, final int mtype) {
        LogUtil.e("hasWrittenLen-->" + hasWrittenLen);
        final int prograss;
        final int totle;
        if (totalLen / 10000 > 100) {
            prograss = (int) (hasWrittenLen / 10000);
            totle = (int) (totalLen / 10000);
        } else if (totalLen / 1000 > 100) {
            prograss = (int) (hasWrittenLen / 1000);
            totle = (int) (totalLen / 1000);
        } else {
            prograss = (int) (hasWrittenLen / 100);
            totle = (int) (totalLen / 100);
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                switch (mtype) {
                    case 1:
                        pbUploading1.setMax(totle);
                        pbUploading1.setProgress(prograss);
                        break;
                    case 2:
                        pbUploading2.setMax(totle);
                        pbUploading2.setProgress(prograss);
                        break;
                    case 3:
                        pbUploading3.setMax(totle);
                        pbUploading3.setProgress(prograss);
                        break;
                }
            }
        });
    }

    @Override
    public void showPicError(String msg, int mtype) {
        switch (mtype) {
            case 1:
                ivCompilete1.setImageResource(R.drawable.upload_faild);
                ivCompilete1.setVisibility(View.VISIBLE);
                tvCompilete1.setVisibility(View.VISIBLE);
                tvCompilete1.setText(getString(R.string.upload_faild));
                pbUploading1.setVisibility(View.GONE);
                tvUploading1.setVisibility(View.GONE);
                break;
            case 2:
                ivCompilete2.setImageResource(R.drawable.upload_faild);
                ivCompilete2.setVisibility(View.VISIBLE);
                tvCompilete2.setVisibility(View.VISIBLE);
                tvCompilete2.setText(getString(R.string.upload_faild));
                pbUploading2.setVisibility(View.GONE);
                tvUploading2.setVisibility(View.GONE);
                break;
            case 3:
                ivCompilete3.setImageResource(R.drawable.upload_faild);
                ivCompilete3.setVisibility(View.VISIBLE);
                tvCompilete3.setVisibility(View.VISIBLE);
                tvCompilete3.setText(getString(R.string.upload_faild));
                pbUploading3.setVisibility(View.GONE);
                tvUploading3.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void showSuccess() {
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
        LogUtil.e(error);
    }


    /**
     * 选择上传身份证
     */
    public class DocumentPopupWindow extends PopupWindow {
        public DocumentPopupWindow(Context mContext, View parent) {
            View view = View.inflate(RelatedOtherDataActivity.this, R.layout.pop_camera_select, null);
            view.findViewById(R.id.tv_photo).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GalleryFinal.openGallerySingle(Constant.REQUEST_CODE_GALLERY, RelatedOtherDataActivity.this);
                    popupWindow.dismiss();
                }
            });
            view.findViewById(R.id.tv_camera).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GalleryFinal.openCamera(Constant.REQUEST_CODE_CAMERA, RelatedOtherDataActivity.this);
                    popupWindow.dismiss();
                }
            });
            view.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindow.dismiss();
                }
            });
            view.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_in_a));
            setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
            setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
            setFocusable(true);
            showAsDropDown(view);
            setOutsideTouchable(true);
            setBackgroundDrawable(getResources().getDrawable(R.color.pop_bg));
            setContentView(view);
            showAtLocation(parent, Gravity.BOTTOM, 0, 0);
            update();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRelatedOtherPresenter.unsubcrible();
    }
}
