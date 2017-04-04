package com.hzxm.easyloan.presenter.implPresenter;

import com.hzxm.easyloan.api.ApiManager;
import com.hzxm.easyloan.model.BaseModel;
import com.hzxm.easyloan.presenter.IVerification;
import com.hzxm.easyloan.presenter.implView.IVerificationView;
import com.lmz.baselibrary.present.implPresenter.BasePresenterImpl;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * 作者：LMZ on 2016/12/27 0027 10:56
 */
public class VerificationPresenter extends BasePresenterImpl implements IVerification {
    IVerificationView mIVerificationView;

    public VerificationPresenter(IVerificationView mIVerificationView) {
        this.mIVerificationView = mIVerificationView;
    }

    /**
     * 实名认证
     *
     * @param uid
     * @param reallyname 真实姓名
     * @param id_card    证件号码
     */
    @Override
    public void verification(String uid, String reallyname, String id_card) {
        Subscription s = ApiManager.getInstance().getLoanApiService().baseinfoCard(System.currentTimeMillis() + "", "48db567a06326e6baa55d4bf1e4a83bf",
                uid, reallyname, id_card, "2")
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIVerificationView.showProgressDialog();
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
                        mIVerificationView.showError(e.getMessage());
                        mIVerificationView.hiteProgressDialog();
                    }

                    @Override
                    public void onNext(BaseModel baseModel) {
                        mIVerificationView.hiteProgressDialog();
                        int code = baseModel.getCode();
                        if (code == 0) {
                            mIVerificationView.showSuccess();
                        } else {
                            mIVerificationView.showError(baseModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }
}
