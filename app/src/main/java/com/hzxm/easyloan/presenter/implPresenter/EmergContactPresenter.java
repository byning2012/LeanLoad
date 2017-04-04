package com.hzxm.easyloan.presenter.implPresenter;

import com.hzxm.easyloan.api.ApiManager;
import com.hzxm.easyloan.model.BaseModel;
import com.hzxm.easyloan.presenter.IEmergencyContact;
import com.hzxm.easyloan.presenter.implView.IEmergencyContactView;
import com.lmz.baselibrary.present.implPresenter.BasePresenterImpl;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * 作者：LMZ on 2017/1/5 0005 14:38
 */
public class EmergContactPresenter extends BasePresenterImpl implements IEmergencyContact {
    private IEmergencyContactView mIEmergencyContactView;

    public EmergContactPresenter(IEmergencyContactView mIEmergencyContactView) {
        this.mIEmergencyContactView = mIEmergencyContactView;
    }

    /**
     * 上传紧急联系人
     *
     * @param uid
     * @param urgent_tel
     */
    @Override
    public void addUrgent(String uid, String urgent_tel) {
        Subscription s = ApiManager.getInstance().getLoanApiService().addEmergency(System.currentTimeMillis() + "", "43e22a590f803f5fbdd6400001bbdb4e", uid, urgent_tel)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIEmergencyContactView.showProgressDialog();
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
                        mIEmergencyContactView.hiteProgressDialog();
                        mIEmergencyContactView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(BaseModel baseModel) {
                        mIEmergencyContactView.hiteProgressDialog();
                        if (baseModel.getCode() == 0) {
                            mIEmergencyContactView.addSuccess();
                        } else {
                            mIEmergencyContactView.showError(baseModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }
}
