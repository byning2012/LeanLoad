package com.hzxm.easyloan.model.home;

/**
 * 作者：LMZ on 2017/1/16 0016 10:00
 */
public class RepaymentModel {

    /**
     * Code : 0
     * Msg : 返回成功
     * Time : 2017-01-16 09:58:35
     * ApiUrl : /Api/Billinfo/bill_message.html
     * Data : {"id":"61","overdue":"123","return_type":"2","rate_money":"0.70","borrow_money":"100.00","repay_money":"100.00","checked_money":"0.70","cash_money":"0.70","reslly_repay_money":"100.00"}
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
         * id : 61
         * overdue : 123
         * return_type : 2
         * rate_money : 0.70
         * borrow_money : 100.00
         * repay_money : 100.00
         * checked_money : 0.70
         * cash_money : 0.70
         * reslly_repay_money : 100.00
         */

        private String id;
        private String overdue;
        private String return_type;
        private String rate_money;
        private String borrow_money;
        private String repay_money;
        private String checked_money;
        private String cash_money;
        private String reslly_repay_money;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOverdue() {
            return overdue;
        }

        public void setOverdue(String overdue) {
            this.overdue = overdue;
        }

        public String getReturn_type() {
            return return_type;
        }

        public void setReturn_type(String return_type) {
            this.return_type = return_type;
        }

        public String getRate_money() {
            return rate_money;
        }

        public void setRate_money(String rate_money) {
            this.rate_money = rate_money;
        }

        public String getBorrow_money() {
            return borrow_money;
        }

        public void setBorrow_money(String borrow_money) {
            this.borrow_money = borrow_money;
        }

        public String getRepay_money() {
            return repay_money;
        }

        public void setRepay_money(String repay_money) {
            this.repay_money = repay_money;
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

        public String getReslly_repay_money() {
            return reslly_repay_money;
        }

        public void setReslly_repay_money(String reslly_repay_money) {
            this.reslly_repay_money = reslly_repay_money;
        }
    }
}
