package com.hzxm.easyloan.presenter.implView;

import com.lmz.baselibrary.present.implView.IBasePresenter;

/**
 * Created by walter on 16/12/28.
 */

public interface ICompanyInfoView extends IBasePresenter {
    void uploadSuccess(String path, int mtype);

    void uploadPrograss(long hasWrittenLen, long totalLen, int mtype);

    void showPicError(String msg, int mtype);

    void showSuccess();

}
