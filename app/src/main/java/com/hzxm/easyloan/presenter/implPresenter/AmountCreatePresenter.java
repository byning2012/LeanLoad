package com.hzxm.easyloan.presenter.implPresenter;

import com.hzxm.easyloan.adapter.mine.AmountBaseAdapter;
import com.hzxm.easyloan.adapter.mine.AmountCreateAdapter;
import com.hzxm.easyloan.api.ApiManager;
import com.hzxm.easyloan.model.BaseModel;
import com.hzxm.easyloan.model.mine.AmountCreateModel;
import com.hzxm.easyloan.presenter.IAmountCreate;
import com.hzxm.easyloan.presenter.implView.IAmountCreateView;
import com.lmz.baselibrary.present.implPresenter.BasePresenterImpl;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * 作者：LMZ on 2016/12/29 0029 17:59
 * 提额认证
 */
public class AmountCreatePresenter extends BasePresenterImpl implements IAmountCreate {
    private IAmountCreateView mIAmountCreateView;
    //基本信息适配器
    private AmountBaseAdapter mAmountBaseAdapter;
    private List<AmountCreateModel.DataEntity.BaseMenuEntity> baseMenuList = new ArrayList<>();
    //其他信息适配器
    private AmountCreateAdapter mAmountCreateAdapter;
    private List<AmountCreateModel.DataEntity.OtherMenuEntity> otherMenuList = new ArrayList<>();


    public AmountCreatePresenter(IAmountCreateView mIAmountCreateView) {
        this.mIAmountCreateView = mIAmountCreateView;
        mAmountBaseAdapter = new AmountBaseAdapter(baseMenuList);
        mAmountCreateAdapter = new AmountCreateAdapter(otherMenuList);
    }


    /**
     * 根据用户类型获取列表
     *
     * @param type
     * @param uid
     */
    @Override
    public void amoutCreateInfo(String type, String uid) {
        Subscription s = ApiManager.getInstance().getLoanApiService().createAmount(System.currentTimeMillis() + "", "f9231f65b29599467d18e5ae1f433da9", uid, type)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIAmountCreateView.showProgressDialog();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AmountCreateModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mIAmountCreateView.showError(e.getMessage());
                        mIAmountCreateView.hiteProgressDialog();
                    }

                    @Override
                    public void onNext(AmountCreateModel amountCreateModel) {
                        mIAmountCreateView.hiteProgressDialog();
                        int code = amountCreateModel.getCode();
                        if (code == 0) {
                            baseMenuList = amountCreateModel.getData().getBase_menu();
                            otherMenuList = amountCreateModel.getData().getOther_menu();
                            mAmountBaseAdapter.setNewData(baseMenuList);
                            mAmountCreateAdapter.setNewData(otherMenuList);
                            mIAmountCreateView.getData(amountCreateModel);
                        } else {
                            mIAmountCreateView.showError(amountCreateModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }

    @Override
    public AmountBaseAdapter getBaseAdapter() {
        return mAmountBaseAdapter;
    }

    @Override
    public AmountCreateAdapter getOtherAdapter() {
        return mAmountCreateAdapter;
    }

    @Override
    public void metioninfoSubmit(String uid, String type) {
        Subscription s = ApiManager.getInstance().getLoanApiService().metionSubmit(System.currentTimeMillis() + "", "f9231f65b29599467d18e5ae1f433da9", uid, type)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIAmountCreateView.showProgressDialog();
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
                        mIAmountCreateView.submitFaild(e.getMessage());
                        mIAmountCreateView.hiteProgressDialog();
                    }

                    @Override
                    public void onNext(BaseModel baseModel) {
                        mIAmountCreateView.hiteProgressDialog();
                        if (baseModel.getCode() == 0) {
                            mIAmountCreateView.submitSuccess();
                        } else {
                            mIAmountCreateView.submitFaild(baseModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }



}
