package com.hzxm.easyloan.presenter.implView;

import com.hzxm.easyloan.model.mine.AmountCreateModel;
import com.lmz.baselibrary.present.implView.IBasePresenter;

/**
 * 作者：LMZ on 2016/12/29 0029 17:56
 */
public interface IAmountCreateView extends IBasePresenter {
    void getData(AmountCreateModel amountCreateModel);

    void submitSuccess();

    void submitFaild(String msg);

}
