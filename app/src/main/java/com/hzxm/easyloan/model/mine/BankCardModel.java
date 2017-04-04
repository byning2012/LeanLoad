package com.hzxm.easyloan.model.mine;

import java.util.List;

/**
 * 作者：LMZ on 2016/12/28 0028 13:34
 * 银行卡查询
 */
public class BankCardModel {


    /**
     * Code : 0
     * Msg : 返回成功
     * Time : 2017-01-05 10:14:11
     * ApiUrl : /Api/Baseinfo/baseinfo_bank.html
     * Data : [{"id":"13","create_time":"1483582121","bank_number":"6222021202037045875","bank_name":"中国工商银行","bank_tel":"15397139232","bank_type":"借记卡"},{"id":"14","create_time":"1483582121","bank_number":"6228480402564890018","bank_name":"中国农业银行","bank_tel":"15397139232","bank_type":"借记卡"},{"id":"15","create_time":"1483582121","bank_number":"6217000830000123038","bank_name":"中国建设银行","bank_tel":"15397139232","bank_type":"借记卡"},{"id":"16","create_time":"1483582121","bank_number":"6222600840000938602","bank_name":"交通银行","bank_tel":"15397139232","bank_type":"借记卡"}]
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
         * id : 13
         * create_time : 1483582121
         * bank_number : 6222021202037045875
         * bank_name : 中国工商银行
         * bank_tel : 15397139232
         * bank_type : 借记卡
         */

        private String id;
        private String create_time;
        private String bank_number;
        private String bank_name;
        private String bank_tel;
        private String bank_type;

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

        public String getBank_number() {
            return bank_number;
        }

        public void setBank_number(String bank_number) {
            this.bank_number = bank_number;
        }

        public String getBank_name() {
            return bank_name;
        }

        public void setBank_name(String bank_name) {
            this.bank_name = bank_name;
        }

        public String getBank_tel() {
            return bank_tel;
        }

        public void setBank_tel(String bank_tel) {
            this.bank_tel = bank_tel;
        }

        public String getBank_type() {
            return bank_type;
        }

        public void setBank_type(String bank_type) {
            this.bank_type = bank_type;
        }
    }
}
