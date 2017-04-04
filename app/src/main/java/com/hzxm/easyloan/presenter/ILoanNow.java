package com.hzxm.easyloan.presenter;

/**
 * 作者：LMZ on 2017/1/11 0011 14:11
 */
public interface ILoanNow {
    void borrow_money(String uid,String borrow_money,String rate_money,String checked_money,String cash_money
    ,int return_type,String normal_salary,String normal_check,String normal_crash,String depart_salary,String depart_check ,
            String depart_crash ,String depart_money,String card_number ,String repay_number,String borrow_time);
}
