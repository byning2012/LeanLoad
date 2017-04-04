package com.hzxm.easyloan.presenter.implPresenter;

import com.hzxm.easyloan.api.ApiManager;
import com.hzxm.easyloan.model.BaseModel;
import com.hzxm.easyloan.presenter.IResetPsw;
import com.hzxm.easyloan.presenter.implView.IResetPswView;
import com.lmz.baselibrary.present.implPresenter.BasePresenterImpl;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * 作者：LMZ on 2016/12/26 0026 12:05
 */
public class ResetPswPresenter extends BasePresenterImpl implements IResetPsw {
    private IResetPswView mIResetPswView;

    public ResetPswPresenter(IResetPswView mIResetPswView) {
        this.mIResetPswView = mIResetPswView;
    }

    /**
     * 重置密码
     *
     * @param uid        用户ID
     * @param repassword 新密码
     * @param password   旧密码
     * @param recode_id  短信返回ID
     */
    @Override
    public void setnewpass(String uid, String repassword, String password, String recode_id) {
        Subscription s = ApiManager.getInstance().getLoanApiService().setnewpass(System.currentTimeMillis() + "", "e98d83c00fcea3b60e25779e25a5167d"
                , uid, repassword, password, recode_id)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIResetPswView.showProgressDialog();
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
                        mIResetPswView.showError(e.getMessage());
                        mIResetPswView.hiteProgressDialog();
                    }

                    @Override
                    public void onNext(BaseModel baseModel) {
                        mIResetPswView.hiteProgressDialog();
                        int code = baseModel.getCode();
                        if (code == 0) {
                            mIResetPswView.showSuccess();
                        } else {
                            mIResetPswView.showError(baseModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }

}
