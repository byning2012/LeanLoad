package com.hzxm.easyloan.presenter.implPresenter;

import com.hzxm.easyloan.api.ApiManager;
import com.hzxm.easyloan.model.BaseModel;
import com.hzxm.easyloan.model.UploadPicModel;
import com.hzxm.easyloan.presenter.IUnitInfo;
import com.hzxm.easyloan.presenter.implView.IUnitInfoView;
import com.lmz.baselibrary.listener.ProgressListener;
import com.lmz.baselibrary.present.implPresenter.BasePresenterImpl;
import com.lmz.baselibrary.util.LogUtil;
import com.lmz.baselibrary.util.UploadFileRequestBody;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.RequestBody;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by walter on 16/12/28.
 */

public class UnitInfoPresenter extends BasePresenterImpl implements IUnitInfo {
    private IUnitInfoView mIUnitInfoView;

    public UnitInfoPresenter(IUnitInfoView mIUnitInfoView) {
        this.mIUnitInfoView = mIUnitInfoView;
    }

    /**
     * 上传图片
     *
     * @param file
     * @param uid
     * @param hashid
     */
    @Override
    public void uploadFace(File file, String uid, String hashid, final int type) {
        Map<String, RequestBody> param = new HashMap<>();
        LogUtil.e("onProgress--6666-->" + type);
        UploadFileRequestBody fileRequestBody = new UploadFileRequestBody(file, new ProgressListener() {
            @Override
            public void onProgress(long hasWrittenLen, long totalLen, boolean hasFinish) {
                LogUtil.e("onProgress---Presenter-->" + type);
                mIUnitInfoView.uploadPrograss(hasWrittenLen, totalLen, type);
            }
        });
        LogUtil.e("filename-->" + file.getName());
        param.put("picture\";filename=\"" + file.getName(), fileRequestBody);
        Subscription s = ApiManager.getInstance().getLoanApiService().uploadPic(System.currentTimeMillis() + "",
                "0a51a705ca8ec26d83af2f1b239aae67", uid, hashid, "picture", param)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<UploadPicModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mIUnitInfoView.showPicError(e.getMessage(), type);
                    }

                    @Override
                    public void onNext(UploadPicModel baseModel) {
                        if (baseModel.getCode() == 0) {
                            mIUnitInfoView.uploadSuccess(baseModel.getData().getPath(), type);
                        } else {
                            mIUnitInfoView.showPicError(baseModel.getMsg(), type);
                        }

                    }
                });
        addSubscription(s);
    }

    /**
     * 上传公司信息
     */
    @Override
    public void unitInfo(String uid, String unit_name, String unit_tel, String unit_work, String unit_work_year,
                         String uint_work_time, String unit_money, String unit_img) {
        Subscription s = ApiManager.getInstance().getLoanApiService().unitInfo(System.currentTimeMillis() + "", "c60199ec9394599177d472eef5450e50",
                uid, unit_name, unit_tel, unit_work, unit_work_year, uint_work_time, unit_money, unit_img)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIUnitInfoView.showProgressDialog();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mIUnitInfoView.hiteProgressDialog();
                        mIUnitInfoView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(BaseModel baseModel) {
                        mIUnitInfoView.hiteProgressDialog();
                        if (baseModel.getCode() == 0) {
                            mIUnitInfoView.showSuccess();
                        } else {
                            mIUnitInfoView.showError(baseModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }
}
