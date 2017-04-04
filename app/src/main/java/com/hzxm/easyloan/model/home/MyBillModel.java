package com.hzxm.easyloan.model.home;

import java.util.List;

/**
 * 作者：LMZ on 2017/1/16 0016 16:00
 */
public class MyBillModel {

    /**
     * Code : 0
     * Msg : 返回成功
     * Time : 2017-01-16 17:44:19
     * ApiUrl : /Api/Billinfo/get_bill_list.html
     * Data : [{"id":"59","create_time":"1484559543","repay_money":"3326.40","return_type":"1"}]
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
         * id : 59
         * create_time : 1484559543
         * repay_money : 3326.40
         * return_type : 1
         */

        private String id;
        private String create_time;
        private String repay_money;
        private String return_type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getRepay_money() {
            return repay_money;
        }

        public void setRepay_money(String repay_money) {
            this.repay_money = repay_money;
        }

        public String getReturn_type() {
            return return_type;
        }

        public void setReturn_type(String return_type) {
            this.return_type = return_type;
        }
    }
}
