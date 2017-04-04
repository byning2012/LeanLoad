package com.hzxm.easyloan.model.home;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 作者：LMZ on 2017/1/10 0010 10:18
 */
public class HomeModel {

    /**
     * Code : 0
     * Msg : 返回成功
     * Time : 2017-01-16 13:57:03
     * ApiUrl : /Api/Billinfo/bill_index.html
     * Data : {"still_money":"22999.00","status":"1","step":"3","normal_salary":"0.001","normal_check":"0.001","normal_crash":"0.001","normal_time":"50","depart_salary":"0.001","depart_check":"0.001","depart_crash":"0.001","depart_money":"0.001","repay_status":2,"repay":{"id":"1","borrow_time":"2","repay_money":"3"}}
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

    public static class DataEntity implements Parcelable{
        /**
         * still_money : 22999.00
         * status : 1
         * step : 3
         * normal_salary : 0.001
         * normal_check : 0.001
         * normal_crash : 0.001
         * normal_time : 50
         * depart_salary : 0.001
         * depart_check : 0.001
         * depart_crash : 0.001
         * depart_money : 0.001
         * repay_status : 2
         * repay : {"id":"1","borrow_time":"2","repay_money":"3"}
         */

        private String still_money;
        private String status;
        private String step;
        private String normal_salary;
        private String normal_check;
        private String normal_crash;
        private String normal_time;
        private String depart_salary;
        private String depart_check;
        private String depart_crash;
        private String depart_money;
        private int repay_status;
        private RepayEntity repay;

        protected DataEntity(Parcel in) {
            still_money = in.readString();
            status = in.readString();
            step = in.readString();
            normal_salary = in.readString();
            normal_check = in.readString();
            normal_crash = in.readString();
            normal_time = in.readString();
            depart_salary = in.readString();
            depart_check = in.readString();
            depart_crash = in.readString();
            depart_money = in.readString();
            repay_status = in.readInt();
        }

        public static final Creator<DataEntity> CREATOR = new Creator<DataEntity>() {
            @Override
            public DataEntity createFromParcel(Parcel in) {
                return new DataEntity(in);
            }

            @Override
            public DataEntity[] newArray(int size) {
                return new DataEntity[size];
            }
        };

        public String getStill_money() {
            return still_money;
        }

        public void setStill_money(String still_money) {
            this.still_money = still_money;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStep() {
            return step;
        }

        public void setStep(String step) {
            this.step = step;
        }

        public String getNormal_salary() {
            return normal_salary;
        }

        public void setNormal_salary(String normal_salary) {
            this.normal_salary = normal_salary;
        }

        public String getNormal_check() {
            return normal_check;
        }

        public void setNormal_check(String normal_check) {
            this.normal_check = normal_check;
        }

        public String getNormal_crash() {
            return normal_crash;
        }

        public void setNormal_crash(String normal_crash) {
            this.normal_crash = normal_crash;
        }

        public String getNormal_time() {
            return normal_time;
        }

        public void setNormal_time(String normal_time) {
            this.normal_time = normal_time;
        }

        public String getDepart_salary() {
            return depart_salary;
        }

        public void setDepart_salary(String depart_salary) {
            this.depart_salary = depart_salary;
        }

        public String getDepart_check() {
            return depart_check;
        }

        public void setDepart_check(String depart_check) {
            this.depart_check = depart_check;
        }

        public String getDepart_crash() {
            return depart_crash;
        }

        public void setDepart_crash(String depart_crash) {
            this.depart_crash = depart_crash;
        }

        public String getDepart_money() {
            return depart_money;
        }

        public void setDepart_money(String depart_money) {
            this.depart_money = depart_money;
        }

        public int getRepay_status() {
            return repay_status;
        }

        public void setRepay_status(int repay_status) {
            this.repay_status = repay_status;
        }

        public RepayEntity getRepay() {
            return repay;
        }

        public void setRepay(RepayEntity repay) {
            this.repay = repay;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(still_money);
            dest.writeString(status);
            dest.writeString(step);
            dest.writeString(normal_salary);
            dest.writeString(normal_check);
            dest.writeString(normal_crash);
            dest.writeString(normal_time);
            dest.writeString(depart_salary);
            dest.writeString(depart_check);
            dest.writeString(depart_crash);
            dest.writeString(depart_money);
            dest.writeInt(repay_status);
        }

        public static class RepayEntity {
            /**
             * id : 1
             * borrow_time : 2
             * repay_money : 3
             */

            private String id;
            private String borrow_time;
            private String repay_money;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getBorrow_time() {
                return borrow_time;
            }

            public void setBorrow_time(String borrow_time) {
                this.borrow_time = borrow_time;
            }

            public String getRepay_money() {
                return repay_money;
            }

            public void setRepay_money(String repay_money) {
                this.repay_money = repay_money;
            }
        }
    }
}
