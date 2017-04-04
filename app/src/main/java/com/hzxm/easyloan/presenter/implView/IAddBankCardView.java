package com.hzxm.easyloan.presenter.implView;

import com.hzxm.easyloan.model.mine.IdCardModel;
import com.lmz.baselibrary.present.implView.IBasePresenter;

/**
 * 作者：LMZ on 2017/1/3 0003 13:54
 */
public interface IAddBankCardView extends IBasePresenter {
    void getIdCard(IdCardModel idCardModel);

    void showSuccess();

    void showAddSuccess();
}
