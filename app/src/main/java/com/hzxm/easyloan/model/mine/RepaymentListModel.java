package com.hzxm.easyloan.model.mine;

import java.util.List;

/**
 * 作者：LMZ on 2017/1/17 0017 14:50
 */
public class RepaymentListModel {

    /**
     * Code : 0
     * Msg : 成功
     * Time : 2017-01-17 14:35:52
     * ApiUrl : /Api/Billinfo/repay_list.html
     * Data : [{"repay_money":277.2,"return_type":"1","return_time":"1484559582"}]
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
         * repay_money : 277.2
         * return_type : 1
         * return_time : 1484559582
         */

        private double repay_money;
        private String return_type;
        private String return_time;

        public double getRepay_money() {
            return repay_money;
        }

        public void setRepay_money(double repay_money) {
            this.repay_money = repay_money;
        }

        public String getReturn_type() {
            return return_type;
        }

        public void setReturn_type(String return_type) {
            this.return_type = return_type;
        }

        public String getReturn_time() {
            return return_time;
        }

        public void setReturn_time(String return_time) {
            this.return_time = return_time;
        }
    }
}
