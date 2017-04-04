package com.hzxm.easyloan.model.home;

import java.util.List;

/**
 * 作者：LMZ on 2017/1/16 0016 18:13
 */
public class LoanStagingModel {

    /**
     * Code : 0
     * Msg : 返回成功
     * Time : 2017-01-16 18:10:17
     * ApiUrl : /Api/Billinfo/show_bill_list.html
     * Data : [{"repay_money":"277.20","all_salary_money":"144","number":"2"},{"repay_money":"277.20","all_salary_money":"144","number":"3"},{"repay_money":"277.20","all_salary_money":"144","number":"4"},{"repay_money":"277.20","all_salary_money":"144","number":"5"},{"repay_money":"277.20","all_salary_money":"144","number":"6"},{"repay_money":"277.20","all_salary_money":"144","number":"7"},{"repay_money":"277.20","all_salary_money":"144","number":"8"},{"repay_money":"277.20","all_salary_money":"144","number":"9"},{"repay_money":"277.20","all_salary_money":"144","number":"10"},{"repay_money":"277.20","all_salary_money":"144","number":"11"},{"repay_money":"277.20","all_salary_money":"144","number":"12"}]
     */

    private int Code;
    private String Msg;
    private String Time;
    private String ApiUrl;
    private List<DataEntity> Data;

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

    public List<DataEntity> getData() {
        return Data;
    }

    public void setData(List<DataEntity> Data) {
        this.Data = Data;
    }

    public static class DataEntity {
        /**
         * repay_money : 277.20
         * all_salary_money : 144
         * number : 2
         */

        private String repay_money;
        private String all_salary_money;
        private String number;

        public String getRepay_money() {
            return repay_money;
        }

        public void setRepay_money(String repay_money) {
            this.repay_money = repay_money;
        }

        public String getAll_salary_money() {
            return all_salary_money;
        }

        public void setAll_salary_money(String all_salary_money) {
            this.all_salary_money = all_salary_money;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }
}
