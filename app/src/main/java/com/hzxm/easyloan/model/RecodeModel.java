package com.hzxm.easyloan.model;

/**
 * 作者：LMZ on 2016/12/26 0026 11:31
 * 短信验证
 */
public class RecodeModel {

    /**
     * Code : 0
     * Msg : OK
     * Time : 2016-12-26 14:14:49
     * ApiUrl : /Api/User/recode.html
     * Data : {}
     * data : 49
     * uid : 16
     */

    private int Code;
    private String Msg;
    private String Time;
    private String ApiUrl;
    private DataEntity Data;
    private String data;
    private String uid;

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

    public String getdata() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public static class DataEntity {
    }
}
