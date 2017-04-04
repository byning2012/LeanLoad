package com.hzxm.easyloan.model.mine;

/**
 * 作者：LMZ on 2017/1/3 0003 14:40
 */
public class IdCardModel {

    /**
     * Code : 0
     * Msg : 返回成功
     * Time : 2017-01-03 14:39:03
     * ApiUrl : /Api/Baseinfo/get_idcard.html
     * Data : {"reallyname":"123","id_card":"1"}
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
         * reallyname : 123
         * id_card : 1
         */

        private String reallyname;
        private String id_card;

        public String getReallyname() {
            return reallyname;
        }

        public void setReallyname(String reallyname) {
            this.reallyname = reallyname;
        }

        public String getId_card() {
            return id_card;
        }

        public void setId_card(String id_card) {
            this.id_card = id_card;
        }
    }
}
