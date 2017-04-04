package com.hzxm.easyloan.presenter.implPresenter;

import com.hzxm.easyloan.api.ApiManager;
import com.hzxm.easyloan.model.BaseModel;
import com.hzxm.easyloan.model.UploadPicModel;
import com.hzxm.easyloan.presenter.IDocumentUpload;
import com.hzxm.easyloan.presenter.implView.IDocUploadView;
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
 * 作者：LMZ on 2016/12/26 0026 16:42
 */
public class DocUpLoadPresenter extends BasePresenterImpl implements IDocumentUpload {
    private IDocUploadView mIDocUploadView;

    public DocUpLoadPresenter(IDocUploadView mIDocUploadView) {
        this.mIDocUploadView = mIDocUploadView;
    }

    /**
     * 图片上传
     *
     * @param uid
     * @param hashid
     */
    @Override
    public void uploadFace(File file, String uid, String hashid, final int type) {
        Map<String, RequestBody> param = new HashMap<>();
        UploadFileRequestBody fileRequestBody = new UploadFileRequestBody(file, new ProgressListener() {
            @Override
            public void onProgress(long hasWrittenLen, long totalLen, boolean hasFinish) {
                mIDocUploadView.uploadPrograss(hasWrittenLen, totalLen, type);
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
                        mIDocUploadView.showPicError(e.getMessage(), type);
                    }

                    @Override
                    public void onNext(UploadPicModel baseModel) {
                        if (baseModel.getCode() == 0) {
                            mIDocUploadView.uploadSuccess(baseModel.getData().getPath(), type);
                        } else {
                            mIDocUploadView.showPicError(baseModel.getMsg(), type);
                        }

                    }
                });
        addSubscription(s);
    }

    /**
     * 身份证证件上传（只保存图片地址）
     *
     * @param uid
     * @param cardImgFace 正面
     * @param cardImgBack 反面
     * @param cardImgAll  手持身份证照
     */
    @Override
    public void baseinfoImg(String uid, String cardImgFace, String cardImgBack, String cardImgAll) {
        Subscription s = ApiManager.getInstance().getLoanApiService().baseinfoImg(System.currentTimeMillis() + "",
                "541cfdca81ace564166da2ed3e26194c"
                , uid, cardImgFace, cardImgBack, cardImgAll, "2")
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIDocUploadView.showProgressDialog();
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
                        mIDocUploadView.showError(e.getMessage());
                        mIDocUploadView.hiteProgressDialog();
                    }

                    @Override
                    public void onNext(BaseModel baseModel) {
                        mIDocUploadView.hiteProgressDialog();
                        int code = baseModel.getCode();
                        if (code == 0) {
                            mIDocUploadView.showSuccess();
                        } else {
                            mIDocUploadView.showError(baseModel.getMsg());
                        }

                    }
                });
        addSubscription(s);
    }
}
