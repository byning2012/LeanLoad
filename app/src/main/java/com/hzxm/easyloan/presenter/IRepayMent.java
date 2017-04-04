package com.hzxm.easyloan.presenter;

/**
 * 作者：LMZ on 2017/1/16 0016 09:59
 * 还款页面
 */
public interface IRepayMent {
    void repayment(int uid, String id);

    //还款
    void repaymentCheck(int uid, String id, String overdue);
}
