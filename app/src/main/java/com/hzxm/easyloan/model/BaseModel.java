package com.hzxm.easyloan.model;

/**
 * 作者：LMZ on 2016/12/24 0024 14:46
 */
public class BaseModel {

    /**
     * Code : 100034
     * Msg : 密码错误
     * Time : 2017-01-07 10:43:46
     * ApiUrl : /Api/User/ulogin.html
     * Data : {}
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
    }
}
