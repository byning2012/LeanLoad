package com.hzxm.easyloan.presenter.implPresenter;

import com.hzxm.easyloan.api.ApiManager;
import com.hzxm.easyloan.model.BaseModel;
import com.hzxm.easyloan.presenter.IAddContacts;
import com.hzxm.easyloan.presenter.implView.IAddContactsView;
import com.lmz.baselibrary.present.implPresenter.BasePresenterImpl;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * 作者：LMZ on 2017/1/7 0007 17:23
 * 提额栏目添加联系人
 */
public class AddContactsPresenter extends BasePresenterImpl implements IAddContacts {
    private IAddContactsView mIAddContactsView;

    public AddContactsPresenter(IAddContactsView mIAddContactsView) {
        this.mIAddContactsView = mIAddContactsView;
    }

    /**
     * 添加联系人
     *
     * @param uid
     * @param student
     * @param teacher
     * @param mother
     * @param father
     */
    @Override
    public void addContacts(String uid, String student, String teacher, String mother, String father) {
        Subscription s = ApiManager.getInstance().getLoanApiService().addContacts(System.currentTimeMillis() + "", "169beb2a4be3ff235b00bc7cbfdd30f5",
                uid, student, teacher, mother, father)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        mIAddContactsView.showProgressDialog();
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
                        mIAddContactsView.hiteProgressDialog();
                        mIAddContactsView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(BaseModel baseModel) {
                        mIAddContactsView.hiteProgressDialog();
                        if (baseModel.getCode() == 0) {
                            mIAddContactsView.addSuccess();
                        } else {
                            mIAddContactsView.showError(baseModel.getMsg());
                        }
                    }
                });
        addSubscription(s);
    }
}
