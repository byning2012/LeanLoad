package com.hzxm.easyloan.presenter.implView;

import com.lmz.baselibrary.present.implView.IBasePresenter;

/**
 * 作者：LMZ on 2017/2/10 0010 10:10
 */
public interface ISocialSecurityView extends IBasePresenter {
    void findSuccess(String token);

    void findError(String error);

    void resultSuccess();

}
