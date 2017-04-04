package com.hzxm.easyloan.model.home;

/**
 * 作者：LMZ on 2017/1/17 0017 10:47
 * 正常借款
 */
public class LoanDetailModel {

    /**
     * Code : 0
     * Msg : 额度不够
     * Time : 2017-01-17 10:37:01
     * ApiUrl : /Api/Billinfo/bill_normal.html
     * Data : {"repay_all_money":277.2,"repay_money":"277.20","borrow_money":"133.33","rate_money":"48.00","checked_money":"48.00","cash_money":"48.00","overdue_money":"0.000"}
     */

    private int Code;
    private String Msg;
    private String Time;
    private String ApiUrl;
    private DataEntity Data;

    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getApiUrl() {
        return ApiUrl;
    }

    public void setApiUrl(String ApiUrl) {
        this.ApiUrl = ApiUrl;
    }

    public DataEntity getData() {
        return Data;
    }

    public void setData(DataEntity Data) {
        this.Data = Data;
    }

    public static class DataEntity {
        /**
         * repay_all_money : 277.2
         * repay_money : 277.20
         * borrow_money : 133.33
         * rate_money : 48.00
         * checked_money : 48.00
         * cash_money : 48.00
         * overdue_money : 0.000
         */

        private double repay_all_money;
        private String repay_money;
        private String borrow_money;
        private String rate_money;
        private String checked_money;
        private String cash_money;
        private String overdue_money;

        public double getRepay_all_money() {
            return repay_all_money;
        }

        public void setRepay_all_money(double repay_all_money) {
            this.repay_all_money = repay_all_money;
        }

        public String getRepay_money() {
            return repay_money;
        }

        public void setRepay_money(String repay_money) {
            this.repay_money = repay_money;
        }

        public String getBorrow_money() {
            return borrow_money;
        }

        public void setBorrow_money(String borrow_money) {
            this.borrow_money = borrow_money;
        }

        public String getRate_money() {
            return rate_money;
        }

        public void setRate_money(String rate_money) {
            this.rate_money = rate_money;
        }

        public String getChecked_money() {
            return checked_money;
        }

        public void setChecked_money(String checked_money) {
            this.checked_money = checked_money;
        }

        public String getCash_money() {
            return cash_money;
        }

        public void setCash_money(String cash_money) {
            this.cash_money = cash_money;
        }

        public String getOverdue_money() {
            return overdue_money;
        }

        public void setOverdue_money(String overdue_money) {
            this.overdue_money = overdue_money;
        }
    }
}
