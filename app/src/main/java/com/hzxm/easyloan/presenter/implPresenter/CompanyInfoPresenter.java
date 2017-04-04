package com.hzxm.easyloan.presenter.implPresenter;

import com.hzxm.easyloan.api.ApiManager;
import com.hzxm.easyloan.model.BaseModel;
import com.hzxm.easyloan.model.UploadPicModel;
import com.hzxm.easyloan.presenter.ICompanyInfo;
import com.hzxm.easyloan.presenter.implView.ICompanyInfoView;
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

public class CompanyInfoPresenter extends BasePresenterImpl implements ICompanyInfo {
    private ICompanyInfoView mICompanyInfoView;

    public CompanyInfoPresenter(ICompanyInfoView mICompanyInfoView) {
        this.mICompanyInfoView = mICompanyInfoView;
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
                mICompanyInfoView.uploadPrograss(hasWrittenLen, totalLen, type);
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
                        mICompanyInfoView.showPicError(e.getMessage(), type);
                    }

                    @Override
                    public void onNext(UploadPicModel baseModel) {
                        if (baseModel.getCode() == 0) {
                            mICompanyInfoView.uploadSuccess(baseModel.getData().getPath(), type);
                        } else {
                            mICompanyInfoView.showPicError(baseModel.getMsg(), type);
                        }

                    }
                });
        addSubscription(s);
    }

    /**
     * 上传公司信息
     *
     * @param uid
     * @param company_name 公司名称
     * @param company_tel  公司座机
     * @param company_img  公司图片 JSON 形式上传
     * @param company_year 入职时间
     * @param work_year    工作年限
     * @param work_money   工资
     * @param company_work 工作职位
     */
    @Override
    public void companyInfo(String uid, String company_name, String company_tel, String company_img, String company_year, String work_year, String work_money, String company_work) {
        Subscription s = ApiManager.getInstance().getLoanApiService().companyInfo(System.currentTimeMillis() + "", "83a851a95988397e1525cc3c511d2887",
                uid, company_name, company_tel, company_img, company_year, work_year, work_money, company_work)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mICompanyInfoView.showProgressDialog();
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
                        mICompanyInfoView.hiteProgressDialog();
                        mICompanyInfoView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(BaseModel baseModel) {
                        mICompanyInfoView.hiteProgressDialog();
                        if (baseModel.getCode() == 0) {
                            mICompanyInfoView.showSuccess();
                        } else {
                            mICompanyInfoView.showError(baseModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }
}
