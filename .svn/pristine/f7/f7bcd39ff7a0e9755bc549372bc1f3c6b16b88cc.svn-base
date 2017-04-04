package com.hzxm.easyloan.presenter.implPresenter;

import com.hzxm.easyloan.api.ApiManager;
import com.hzxm.easyloan.model.BaseModel;
import com.hzxm.easyloan.model.RecodeModel;
import com.hzxm.easyloan.presenter.IFindPsw;
import com.hzxm.easyloan.presenter.implView.IFindPswView;
import com.lmz.baselibrary.present.implPresenter.BasePresenterImpl;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * 作者：LMZ on 2016/12/26 0026 10:39
 */
public class FindPswPresenter extends BasePresenterImpl implements IFindPsw {
    private IFindPswView mIFindPswView;

    public FindPswPresenter(IFindPswView mIFindPswView) {
        this.mIFindPswView = mIFindPswView;
    }

    /**
     * 发送验证码
     *
     * @param mobile
     * @param checktype
     */
    @Override
    public void sendcode(String mobile, String checktype) {
        Subscription s = ApiManager.getInstance().getLoanApiService().getVerication(System.currentTimeMillis() + "", "c5ea4773f8c6122731ef99bcf1b960a8"
                , mobile, checktype)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIFindPswView.showProgressDialog();
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
                        mIFindPswView.showError(e.getMessage());
                        mIFindPswView.hiteProgressDialog();
                    }

                    @Override
                    public void onNext(BaseModel baseModel) {
                        mIFindPswView.hiteProgressDialog();
                        int code = baseModel.getCode();
                        if (code == 0) {
                            mIFindPswView.showSuccess();
                        } else {
                            mIFindPswView.showError(baseModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }

    /**
     * 短信验证
     *
     * @param checkcode 验证码
     * @param mobile    手机号
     */
    @Override
    public void recode(String checkcode, String mobile) {
        Subscription s = ApiManager.getInstance().getLoanApiService().recode(System.currentTimeMillis() + "",
                "ff4644f8f58cd8099f71507e5555c40c", checkcode, mobile)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIFindPswView.showProgressDialog();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RecodeModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mIFindPswView.showError(e.getMessage());
                        mIFindPswView.hiteProgressDialog();
                    }

                    @Override
                    public void onNext(RecodeModel recodeModel) {
                        mIFindPswView.hiteProgressDialog();
                        int code = recodeModel.getCode();
                        if (code == 0) {
                            mIFindPswView.getRecodeId(recodeModel);
                        } else {
                            mIFindPswView.showError(recodeModel.getMsg());
                        }
                    }
                });
    }
}
