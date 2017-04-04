package com.hzxm.easyloan.presenter.implPresenter;

import com.hzxm.easyloan.api.ApiManager;
import com.hzxm.easyloan.model.BaseModel;
import com.hzxm.easyloan.presenter.IPswModify;
import com.hzxm.easyloan.presenter.implView.IPswModifyView;
import com.lmz.baselibrary.present.implPresenter.BasePresenterImpl;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * 作者：LMZ on 2017/1/9 0009 16:50
 */
public class ModifyPswPresenter extends BasePresenterImpl implements IPswModify {
    private IPswModifyView mIPswModifyView;

    public ModifyPswPresenter(IPswModifyView mIPswModifyView) {
        this.mIPswModifyView = mIPswModifyView;
    }

    /**
     * 重置密码
     *
     * @param uid
     * @param hashid
     * @param oldPsw
     * @param newPsw
     * @param repeatPsw
     */
    @Override
    public void updataPsw(String uid, String hashid, String oldPsw, String newPsw, String repeatPsw) {
        Subscription s = ApiManager.getInstance().getLoanApiService().updataPsw(System.currentTimeMillis() + "", "d889fb1feccacc88634963c636d402e6"
                , uid, hashid, oldPsw, newPsw, repeatPsw)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIPswModifyView.showProgressDialog();



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
                        mIPswModifyView.showError(e.getMessage());
                        mIPswModifyView.hiteProgressDialog();
                    }

                    @Override
                    public void onNext(BaseModel baseModel) {
                        mIPswModifyView.hiteProgressDialog();
                        if (baseModel.getCode() == 0) {
                            mIPswModifyView.modifySuccess();
                        } else {
                            mIPswModifyView.showError(baseModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }
}
