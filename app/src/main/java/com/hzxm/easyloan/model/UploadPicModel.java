package com.hzxm.easyloan.model;

/**
 * 作者：LMZ on 2016/12/27 0027 09:56
 * 图片上传
 */
public class UploadPicModel {

    /**
     * Code : 0
     * Msg : 登录成功
     * Time : 2016-12-27 09:58:11
     * ApiUrl : /Api/User/ulogin.html
     * Data : {"path":""}
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
         * path :
         */
        private String path;

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }
    }
}
