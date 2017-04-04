package com.hzxm.easyloan.model.home;

/**
 * 作者：LMZ on 2017/1/11 0011 09:26
 * 申请借款
 */
public class LoanNowModel {

    /**
     * Code : 0
     * Msg : 申请成功
     * Time : 2017-01-11 09:23:57
     * ApiUrl : /Api/Billinfo/borrow_money.html
     * Data : {"uid":16,"salary":"0.1","borrow_money":"1000","checked_money":100,"cash_money":100,"rate_money":700,"all_salary_money":900,"repay_money":1900,"create_time":1484097837,"date_salary":"0.1","crash_salary":"0.1","check_salary":"0.1","repay_number":"1","borrow_time":"7","return_type":2}
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
         * uid : 16
         * salary : 0.1
         * borrow_money : 1000
         * checked_money : 100
         * cash_money : 100
         * rate_money : 700
         * all_salary_money : 900
         * repay_money : 1900
         * create_time : 1484097837
         * date_salary : 0.1
         * crash_salary : 0.1
         * check_salary : 0.1
         * repay_number : 1
         * borrow_time : 7
         * return_type : 2
         */

        private int uid;
        private String salary;
        private String borrow_money;
        private int checked_money;
        private int cash_money;
        private int rate_money;
        private int all_salary_money;
        private int repay_money;
        private int create_time;
        private String date_salary;
        private String crash_salary;
        private String check_salary;
        private String repay_number;
        private String borrow_time;
        private int return_type;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getBorrow_money() {
            return borrow_money;
        }

        public void setBorrow_money(String borrow_money) {
            this.borrow_money = borrow_money;
        }

        public int getChecked_money() {
            return checked_money;
        }

        public void setChecked_money(int checked_money) {
            this.checked_money = checked_money;
        }

        public int getCash_money() {
            return cash_money;
        }

        public void setCash_money(int cash_money) {
            this.cash_money = cash_money;
        }

        public int getRate_money() {
            return rate_money;
        }

        public void setRate_money(int rate_money) {
            this.rate_money = rate_money;
        }

        public int getAll_salary_money() {
            return all_salary_money;
        }

        public void setAll_salary_money(int all_salary_money) {
            this.all_salary_money = all_salary_money;
        }

        public int getRepay_money() {
            return repay_money;
        }

        public void setRepay_money(int repay_money) {
            this.repay_money = repay_money;
        }

        public int getCreate_time() {
            return create_time;
        }

        public void setCreate_time(int create_time) {
            this.create_time = create_time;
        }

        public String getDate_salary() {
            return date_salary;
        }

        public void setDate_salary(String date_salary) {
            this.date_salary = date_salary;
        }

        public String getCrash_salary() {
            return crash_salary;
        }

        public void setCrash_salary(String crash_salary) {
            this.crash_salary = crash_salary;
        }

        public String getCheck_salary() {
            return check_salary;
        }

        public void setCheck_salary(String check_salary) {
            this.check_salary = check_salary;
        }

        public String getRepay_number() {
            return repay_number;
        }

        public void setRepay_number(String repay_number) {
            this.repay_number = repay_number;
        }

        public String getBorrow_time() {
            return borrow_time;
        }

        public void setBorrow_time(String borrow_time) {
            this.borrow_time = borrow_time;
        }

        public int getReturn_type() {
            return return_type;
        }

        public void setReturn_type(int return_type) {
            this.return_type = return_type;
        }
    }
}
