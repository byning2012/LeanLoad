package com.hzxm.easyloan.model.mine;


import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

import java.util.List;

/**
 * 作者：LMZ on 2017/1/23 0023 14:38
 */
public class SocialCityModel {

    /**
     * Code : 0
     * Msg : 获取地址成功
     * Time : 2017-01-23 14:30:44
     * ApiUrl : /Api/Metioninfo/socal_area.html
     * Data : {"state":"1","data":[{"areaCode":"1100","areaName":"北京市","status":"1"},{"areaCode":"3100","areaName":"上海市","status":"1"},{"areaCode":"4403","areaName":"深圳市","status":"1"},{"areaCode":"3701","areaName":"济南市","status":"1"},{"areaCode":"5000","areaName":"重庆市","status":"1"},{"areaCode":"4201","areaName":"武汉市","status":"1"},{"areaCode":"2201","areaName":"长春市","status":"1"},{"areaCode":"3501","areaName":"福州市","status":"1"},{"areaCode":"3205","areaName":"苏州市","status":"1"},{"areaCode":"3401","areaName":"合肥市","status":"1"},{"areaCode":"3302","areaName":"宁波市","status":"1"},{"areaCode":"6101","areaName":"西安市","status":"1"},{"areaCode":"3201","areaName":"南京市","status":"1"},{"areaCode":"3601","areaName":"南昌市","status":"1"},{"areaCode":"3502","areaName":"厦门市","status":"1"},{"areaCode":"1200","areaName":"天津市","status":"1"},{"areaCode":"5101","areaName":"成都市","status":"1"},{"areaCode":"1303","areaName":"秦皇岛市","status":"1"},{"areaCode":"3702","areaName":"青岛市","status":"1"},{"areaCode":"4406","areaName":"佛山市","status":"1"}],"msg":"请求成功"}
     */

    private int Code;
    private String Msg;
    private String Time;
    private String ApiUrl;
    private DataEntityX Data;

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

    public DataEntityX getData() {
        return Data;
    }

    public void setData(DataEntityX Data) {
        this.Data = Data;
    }

    public static class DataEntityX {
        /**
         * state : 1
         * data : [{"areaCode":"1100","areaName":"北京市","status":"1"},{"areaCode":"3100","areaName":"上海市","status":"1"},{"areaCode":"4403","areaName":"深圳市","status":"1"},{"areaCode":"3701","areaName":"济南市","status":"1"},{"areaCode":"5000","areaName":"重庆市","status":"1"},{"areaCode":"4201","areaName":"武汉市","status":"1"},{"areaCode":"2201","areaName":"长春市","status":"1"},{"areaCode":"3501","areaName":"福州市","status":"1"},{"areaCode":"3205","areaName":"苏州市","status":"1"},{"areaCode":"3401","areaName":"合肥市","status":"1"},{"areaCode":"3302","areaName":"宁波市","status":"1"},{"areaCode":"6101","areaName":"西安市","status":"1"},{"areaCode":"3201","areaName":"南京市","status":"1"},{"areaCode":"3601","areaName":"南昌市","status":"1"},{"areaCode":"3502","areaName":"厦门市","status":"1"},{"areaCode":"1200","areaName":"天津市","status":"1"},{"areaCode":"5101","areaName":"成都市","status":"1"},{"areaCode":"1303","areaName":"秦皇岛市","status":"1"},{"areaCode":"3702","areaName":"青岛市","status":"1"},{"areaCode":"4406","areaName":"佛山市","status":"1"}]
         * msg : 请求成功
         */

        private String state;
        private String msg;
        private List<DataEntity> data;


        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public List<DataEntity> getData() {
            return data;
        }

        public void setData(List<DataEntity> data) {
            this.data = data;
        }

        public static class DataEntity implements Comparable<DataEntity> {
            /**
             * areaCode : 1100
             * areaName : 北京市
             * status : 1
             */

            private String areaCode;
            private String areaName;
            private String status;
            public String pinyin;

            public DataEntity(String areaName, String areaCode) {
                this.areaName = areaName;
                this.areaCode = areaCode;
                try {
                    pinyin = PinyinHelper.convertToPinyinString(areaName, ",", PinyinFormat.WITHOUT_TONE);
                    pinyin = pinyin.toUpperCase();
                } catch (PinyinException e) {
                    e.printStackTrace();
                }


            }

            public String getAreaCode() {
                return areaCode;
            }

            public void setAreaCode(String areaCode) {
                this.areaCode = areaCode;
            }

            public String getAreaName() {
                return areaName;
            }

            public void setAreaName(String areaName) {
                this.areaName = areaName;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            @Override
            public int compareTo(DataEntity o) {
                return this.pinyin.compareTo(o.pinyin);
            }
        }
    }
}
