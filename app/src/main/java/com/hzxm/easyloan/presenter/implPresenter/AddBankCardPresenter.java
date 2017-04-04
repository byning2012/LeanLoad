package com.hzxm.easyloan.presenter.implPresenter;

import com.hzxm.easyloan.api.ApiManager;
import com.hzxm.easyloan.model.BaseModel;
import com.hzxm.easyloan.model.mine.AddBankModel;
import com.hzxm.easyloan.model.mine.IdCardModel;
import com.hzxm.easyloan.presenter.IAddBankCard;
import com.hzxm.easyloan.presenter.implView.IAddBankCardView;
import com.lmz.baselibrary.present.implPresenter.BasePresenterImpl;
import com.lmz.baselibrary.util.LogUtil;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * 作者：LMZ on 2017/1/3 0003 13:56
 */
public class AddBankCardPresenter extends BasePresenterImpl implements IAddBankCard {
    private IAddBankCardView mIAddBankCardView;

    public AddBankCardPresenter(IAddBankCardView mIAddBankCardView) {
        this.mIAddBankCardView = mIAddBankCardView;
    }

    /**
     * 获取身份证信息
     *
     * @param uid
     */
    @Override
    public void getIdCard(String uid) {
        Subscription s = ApiManager.getInstance().getLoanApiService().idCard(System.currentTimeMillis() + "", "4b50512c9c732419a0d992ab9cd202bc"
                , uid)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIAddBankCardView.showProgressDialog();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<IdCardModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mIAddBankCardView.showError(e.getMessage());
                        mIAddBankCardView.hiteProgressDialog();
                    }

                    @Override
                    public void onNext(IdCardModel idCardModel) {
                        mIAddBankCardView.hiteProgressDialog();
                        int code = idCardModel.getCode();
                        if (code == 0) {
                            mIAddBankCardView.getIdCard(idCardModel);
                        } else {
                            mIAddBankCardView.showError(idCardModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
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
                        mIAddBankCardView.showProgressDialog();
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
                        mIAddBankCardView.showError(e.getMessage());
                        mIAddBankCardView.hiteProgressDialog();
                    }

                    @Override
                    public void onNext(BaseModel baseModel) {
                        mIAddBankCardView.hiteProgressDialog();
                        int code = baseModel.getCode();
                        if (code == 0) {
                            mIAddBankCardView.showSuccess();
                        } else {
                            mIAddBankCardView.showError(baseModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }

    /**
     * 添加银行卡
     *
     * @param uid
     * @param reallyname
     * @param id_card
     * @param bank_number
     * @param bank_tel
     * @param check_code
     */
    @Override
    public void addBankCard(String uid, String reallyname, String id_card, String bank_number, String bank_tel, String check_code) {
        Subscription s = ApiManager.getInstance().getLoanApiService().addBankCard(System.currentTimeMillis() + "", "84eb8169cfe23c95c84968f57a1134fe",
                uid + "", reallyname, id_card, bank_number, bank_tel, check_code, "2")
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIAddBankCardView.showProgressDialog();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AddBankModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mIAddBankCardView.hiteProgressDialog();
                        mIAddBankCardView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(AddBankModel bankCardModel) {
                        mIAddBankCardView.hiteProgressDialog();
                        int code = bankCardModel.getCode();
                        LogUtil.e("code-->" + code);
                        if (code == 0) {
                            mIAddBankCardView.showAddSuccess();
                        } else {
                            mIAddBankCardView.showError(bankCardModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }
}
