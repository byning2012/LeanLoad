package com.hzxm.easyloan.model.mine;

/**
 * 作者：LMZ on 2017/2/10 0010 10:16
 */
public class SocialSecurityModel {

    /**
     * Code : 0
     * Msg : 成功
     * Time : 2017-02-10 10:14:04
     * ApiUrl : /Api/Metioninfo/socal_search.html
     * Data : {"state":"1","data":"799ca08e58cb494882d5f7e2dec45515","msg":"请求成功，已有结果"}
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
         * state : 1
         * data : 799ca08e58cb494882d5f7e2dec45515
         * msg : 请求成功，已有结果
         */

        private String state;
        private String data;
        private String msg;

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
