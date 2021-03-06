package com.hzxm.easyloan.model.mine;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 作者：LMZ on 2016/12/29 0029 17:57
 */
public class AmountCreateModel {

    /**
     * Code : 0
     * Msg : ok
     * Time : 2017-01-05 18:12:07
     * ApiUrl : /Api/Metioninfo/othermenu.html
     * Data : {"type":3,"other_menu":[{"id":"20","name":"其他资料","pid":"3","other_img":null}],"base_menu":[{"id":"8","up_type":"3","menu_name":"unit","remark":"单位"},{"id":"9","up_type":"3","menu_name":"socal","remark":"社保"},{"id":"10","up_type":"3","menu_name":"car","remark":"车辆信息"},{"id":"11","up_type":"3","menu_name":"home","remark":"房产证"},{"id":"15","up_type":"3","menu_name":"interfix","remark":"相关证件"}],"info":{"unit":{"unit_name":"新苗网络","unit_tel":"666666","unit_work":"6666","unit_work_year":"10","uint_work_time":"2016.6.6","unit_money":"8000000000","unit_img":[{"name":"工作证/入职协议","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg"},{"name":"单位照片","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg"},{"name":"更多照片","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg"}]},"car":{"car_img":"http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg","car_back_img":"http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg"},"home":{"house_back_img":"0","house_img":"http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg"},"interfix":{"interfix_name":"啊","interfix_img":[{"name":"第一张","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-26/5860f0c730ddd.jpg"},{"name":"第二张","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-26/5860f0c730ddd.jpg"},{"name":"第三张","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-26/5860f0c730ddd.jpg"}]}},"check_status":"0"}
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
         * type : 3
         * other_menu : [{"id":"20","name":"其他资料","pid":"3","other_img":null}]
         * base_menu : [{"id":"8","up_type":"3","menu_name":"unit","remark":"单位"},{"id":"9","up_type":"3","menu_name":"socal","remark":"社保"},{"id":"10","up_type":"3","menu_name":"car","remark":"车辆信息"},{"id":"11","up_type":"3","menu_name":"home","remark":"房产证"},{"id":"15","up_type":"3","menu_name":"interfix","remark":"相关证件"}]
         * info : {"unit":{"unit_name":"新苗网络","unit_tel":"666666","unit_work":"6666","unit_work_year":"10","uint_work_time":"2016.6.6","unit_money":"8000000000","unit_img":[{"name":"工作证/入职协议","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg"},{"name":"单位照片","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg"},{"name":"更多照片","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg"}]},"car":{"car_img":"http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg","car_back_img":"http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg"},"home":{"house_back_img":"0","house_img":"http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg"},"interfix":{"interfix_name":"啊","interfix_img":[{"name":"第一张","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-26/5860f0c730ddd.jpg"},{"name":"第二张","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-26/5860f0c730ddd.jpg"},{"name":"第三张","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-26/5860f0c730ddd.jpg"}]}}
         * check_status : 0
         */

        private int type;
        private InfoEntity info;
        private String check_status;
        private List<OtherMenuEntity> other_menu;
        private List<BaseMenuEntity> base_menu;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public InfoEntity getInfo() {
            return info;
        }

        public void setInfo(InfoEntity info) {
            this.info = info;
        }

        public String getCheck_status() {
            return check_status;
        }

        public void setCheck_status(String check_status) {
            this.check_status = check_status;
        }

        public List<OtherMenuEntity> getOther_menu() {
            return other_menu;
        }

        public void setOther_menu(List<OtherMenuEntity> other_menu) {
            this.other_menu = other_menu;
        }

        public List<BaseMenuEntity> getBase_menu() {
            return base_menu;
        }

        public void setBase_menu(List<BaseMenuEntity> base_menu) {
            this.base_menu = base_menu;
        }

        public static class InfoEntity {
            /**
             * unit : {"unit_name":"新苗网络","unit_tel":"666666","unit_work":"6666","unit_work_year":"10","uint_work_time":"2016.6.6","unit_money":"8000000000","unit_img":[{"name":"工作证/入职协议","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg"},{"name":"单位照片","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg"},{"name":"更多照片","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg"}]}
             * car : {"car_img":"http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg","car_back_img":"http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg"}
             * home : {"house_back_img":"0","house_img":"http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg"}
             * interfix : {"interfix_name":"啊","interfix_img":[{"name":"第一张","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-26/5860f0c730ddd.jpg"},{"name":"第二张","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-26/5860f0c730ddd.jpg"},{"name":"第三张","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-26/5860f0c730ddd.jpg"}]}
             */

            private UnitEntity unit;
            private CarEntity car;
            private HomeEntity home;
            private InterfixEntity interfix;
            private ConnectPersionEntity connect_persion;
            private XuexinEntity xuexin;
            private String school;
            private String school_depart;
            private CompanyEntity company;

            public void setCompany(CompanyEntity company) {
                this.company = company;
            }

            public CompanyEntity getCompany() {
                return company;
            }

            public void setConnect_persion(ConnectPersionEntity connect_persion) {
                this.connect_persion = connect_persion;
            }

            public void setXuexin(XuexinEntity xuexin) {
                this.xuexin = xuexin;
            }

            public void setSchool(String school) {
                this.school = school;
            }

            public void setSchool_depart(String school_depart) {
                this.school_depart = school_depart;
            }


            public ConnectPersionEntity getConnect_persion() {
                return connect_persion;
            }

            public XuexinEntity getXuexin() {
                return xuexin;
            }

            public String getSchool() {
                return school;
            }

            public String getSchool_depart() {
                return school_depart;
            }

            public UnitEntity getUnit() {
                return unit;
            }

            public void setUnit(UnitEntity unit) {
                this.unit = unit;
            }

            public CarEntity getCar() {
                return car;
            }

            public void setCar(CarEntity car) {
                this.car = car;
            }

            public HomeEntity getHome() {
                return home;
            }

            public void setHome(HomeEntity home) {
                this.home = home;
            }

            public InterfixEntity getInterfix() {
                return interfix;
            }

            public void setInterfix(InterfixEntity interfix) {
                this.interfix = interfix;
            }


            public static class UnitEntity implements Parcelable {
                /**
                 * unit_name : 新苗网络
                 * unit_tel : 666666
                 * unit_work : 6666
                 * unit_work_year : 10
                 * uint_work_time : 2016.6.6
                 * unit_money : 8000000000
                 * unit_img : [{"name":"工作证/入职协议","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg"},{"name":"单位照片","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg"},{"name":"更多照片","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg"}]
                 */

                private String unit_name;
                private String unit_tel;
                private String unit_work;
                private String unit_work_year;
                private String uint_work_time;
                private String unit_money;
                private List<UnitImgEntity> unit_img;

                protected UnitEntity(Parcel in) {
                    unit_name = in.readString();
                    unit_tel = in.readString();
                    unit_work = in.readString();
                    unit_work_year = in.readString();
                    uint_work_time = in.readString();
                    unit_money = in.readString();
                }

                public static final Creator<UnitEntity> CREATOR = new Creator<UnitEntity>() {
                    @Override
                    public UnitEntity createFromParcel(Parcel in) {
                        return new UnitEntity(in);
                    }

                    @Override
                    public UnitEntity[] newArray(int size) {
                        return new UnitEntity[size];
                    }
                };

                public String getUnit_name() {
                    return unit_name;
                }

                public void setUnit_name(String unit_name) {
                    this.unit_name = unit_name;
                }

                public String getUnit_tel() {
                    return unit_tel;
                }

                public void setUnit_tel(String unit_tel) {
                    this.unit_tel = unit_tel;
                }

                public String getUnit_work() {
                    return unit_work;
                }

                public void setUnit_work(String unit_work) {
                    this.unit_work = unit_work;
                }

                public String getUnit_work_year() {
                    return unit_work_year;
                }

                public void setUnit_work_year(String unit_work_year) {
                    this.unit_work_year = unit_work_year;
                }

                public String getUint_work_time() {
                    return uint_work_time;
                }

                public void setUint_work_time(String uint_work_time) {
                    this.uint_work_time = uint_work_time;
                }

                public String getUnit_money() {
                    return unit_money;
                }

                public void setUnit_money(String unit_money) {
                    this.unit_money = unit_money;
                }

                public List<UnitImgEntity> getUnit_img() {
                    return unit_img;
                }

                public void setUnit_img(List<UnitImgEntity> unit_img) {
                    this.unit_img = unit_img;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(unit_name);
                    dest.writeString(unit_tel);
                    dest.writeString(unit_work);
                    dest.writeString(unit_work_year);
                    dest.writeString(uint_work_time);
                    dest.writeString(unit_money);
                }

                public static class UnitImgEntity implements Parcelable {
                    /**
                     * name : 工作证/入职协议
                     * image : http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg
                     */

                    private String name;
                    private String image;

                    protected UnitImgEntity(Parcel in) {
                        name = in.readString();
                        image = in.readString();
                    }

                    public static final Creator<UnitImgEntity> CREATOR = new Creator<UnitImgEntity>() {
                        @Override
                        public UnitImgEntity createFromParcel(Parcel in) {
                            return new UnitImgEntity(in);
                        }

                        @Override
                        public UnitImgEntity[] newArray(int size) {
                            return new UnitImgEntity[size];
                        }
                    };

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeString(name);
                        dest.writeString(image);
                    }
                }
            }

            public static class CarEntity implements Parcelable {
                /**
                 * car_img : http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg
                 * car_back_img : http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg
                 */

                private String car_img;
                private String car_back_img;

                protected CarEntity(Parcel in) {
                    car_img = in.readString();
                    car_back_img = in.readString();
                }

                public static final Creator<CarEntity> CREATOR = new Creator<CarEntity>() {
                    @Override
                    public CarEntity createFromParcel(Parcel in) {
                        return new CarEntity(in);
                    }

                    @Override
                    public CarEntity[] newArray(int size) {
                        return new CarEntity[size];
                    }
                };

                public String getCar_img() {
                    return car_img;
                }

                public void setCar_img(String car_img) {
                    this.car_img = car_img;
                }

                public String getCar_back_img() {
                    return car_back_img;
                }

                public void setCar_back_img(String car_back_img) {
                    this.car_back_img = car_back_img;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(car_img);
                    dest.writeString(car_back_img);
                }
            }

            public static class HomeEntity implements Parcelable {
                /**
                 * house_back_img : 0
                 * house_img : http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg
                 */

                private String house_back_img;
                private String house_img;

                protected HomeEntity(Parcel in) {
                    house_back_img = in.readString();
                    house_img = in.readString();
                }

                public static final Creator<HomeEntity> CREATOR = new Creator<HomeEntity>() {
                    @Override
                    public HomeEntity createFromParcel(Parcel in) {
                        return new HomeEntity(in);
                    }

                    @Override
                    public HomeEntity[] newArray(int size) {
                        return new HomeEntity[size];
                    }
                };

                public String getHouse_back_img() {
                    return house_back_img;
                }

                public void setHouse_back_img(String house_back_img) {
                    this.house_back_img = house_back_img;
                }

                public String getHouse_img() {
                    return house_img;
                }

                public void setHouse_img(String house_img) {
                    this.house_img = house_img;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(house_back_img);
                    dest.writeString(house_img);
                }
            }

            public static class InterfixEntity implements Parcelable {
                /**
                 * interfix_name : 啊
                 * interfix_img : [{"name":"第一张","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-26/5860f0c730ddd.jpg"},{"name":"第二张","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-26/5860f0c730ddd.jpg"},{"name":"第三张","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-26/5860f0c730ddd.jpg"}]
                 */

                private String interfix_name;
                private List<InterfixImgEntity> interfix_img;

                protected InterfixEntity(Parcel in) {
                    interfix_name = in.readString();
                }

                public static final Creator<InterfixEntity> CREATOR = new Creator<InterfixEntity>() {
                    @Override
                    public InterfixEntity createFromParcel(Parcel in) {
                        return new InterfixEntity(in);
                    }

                    @Override
                    public InterfixEntity[] newArray(int size) {
                        return new InterfixEntity[size];
                    }
                };

                public String getInterfix_name() {
                    return interfix_name;
                }

                public void setInterfix_name(String interfix_name) {
                    this.interfix_name = interfix_name;
                }

                public List<InterfixImgEntity> getInterfix_img() {
                    return interfix_img;
                }

                public void setInterfix_img(List<InterfixImgEntity> interfix_img) {
                    this.interfix_img = interfix_img;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(interfix_name);
                }

                public static class InterfixImgEntity implements Parcelable {
                    /**
                     * name : 第一张
                     * image : http://139.196.214.241:8100/Uploads/Picture/2016-12-26/5860f0c730ddd.jpg
                     */

                    private String name;
                    private String image;

                    protected InterfixImgEntity(Parcel in) {
                        name = in.readString();
                        image = in.readString();
                    }

                    public static final Creator<InterfixImgEntity> CREATOR = new Creator<InterfixImgEntity>() {
                        @Override
                        public InterfixImgEntity createFromParcel(Parcel in) {
                            return new InterfixImgEntity(in);
                        }

                        @Override
                        public InterfixImgEntity[] newArray(int size) {
                            return new InterfixImgEntity[size];
                        }
                    };

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeString(name);
                        dest.writeString(image);
                    }
                }
            }


            public static class ConnectPersionEntity implements Parcelable {
                /**
                 * student : {"relative":"妈妈","name":"妈妈","tel":"15067126311"}
                 * teacher : {"relative":"妈妈","name":"妈妈","tel":"15067126311"}
                 * mother : {"relative":"妈妈","name":"妈妈","tel":"15067126311"}
                 * father : {"relative":"妈妈","name":"妈妈","tel":"15067126311"}
                 */

                private StudentEntity student;
                private TeacherEntity teacher;
                private MotherEntity mother;
                private FatherEntity father;

                protected ConnectPersionEntity(Parcel in) {
                }

                public static final Creator<ConnectPersionEntity> CREATOR = new Creator<ConnectPersionEntity>() {
                    @Override
                    public ConnectPersionEntity createFromParcel(Parcel in) {
                        return new ConnectPersionEntity(in);
                    }

                    @Override
                    public ConnectPersionEntity[] newArray(int size) {
                        return new ConnectPersionEntity[size];
                    }
                };

                public StudentEntity getStudent() {
                    return student;
                }

                public void setStudent(StudentEntity student) {
                    this.student = student;
                }

                public TeacherEntity getTeacher() {
                    return teacher;
                }

                public void setTeacher(TeacherEntity teacher) {
                    this.teacher = teacher;
                }

                public MotherEntity getMother() {
                    return mother;
                }

                public void setMother(MotherEntity mother) {
                    this.mother = mother;
                }

                public FatherEntity getFather() {
                    return father;
                }

                public void setFather(FatherEntity father) {
                    this.father = father;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                }

                public static class StudentEntity implements Parcelable {
                    /**
                     * relative : 妈妈
                     * name : 妈妈
                     * tel : 15067126311
                     */

                    private String relative;
                    private String name;
                    private String tel;

                    protected StudentEntity(Parcel in) {
                        relative = in.readString();
                        name = in.readString();
                        tel = in.readString();
                    }

                    public static final Creator<StudentEntity> CREATOR = new Creator<StudentEntity>() {
                        @Override
                        public StudentEntity createFromParcel(Parcel in) {
                            return new StudentEntity(in);
                        }

                        @Override
                        public StudentEntity[] newArray(int size) {
                            return new StudentEntity[size];
                        }
                    };

                    public String getRelative() {
                        return relative;
                    }

                    public void setRelative(String relative) {
                        this.relative = relative;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getTel() {
                        return tel;
                    }

                    public void setTel(String tel) {
                        this.tel = tel;
                    }

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeString(relative);
                        dest.writeString(name);
                        dest.writeString(tel);
                    }
                }

                public static class TeacherEntity implements Parcelable {
                    /**
                     * relative : 妈妈
                     * name : 妈妈
                     * tel : 15067126311
                     */

                    private String relative;
                    private String name;
                    private String tel;

                    protected TeacherEntity(Parcel in) {
                        relative = in.readString();
                        name = in.readString();
                        tel = in.readString();
                    }

                    public static final Creator<TeacherEntity> CREATOR = new Creator<TeacherEntity>() {
                        @Override
                        public TeacherEntity createFromParcel(Parcel in) {
                            return new TeacherEntity(in);
                        }

                        @Override
                        public TeacherEntity[] newArray(int size) {
                            return new TeacherEntity[size];
                        }
                    };

                    public String getRelative() {
                        return relative;
                    }

                    public void setRelative(String relative) {
                        this.relative = relative;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getTel() {
                        return tel;
                    }

                    public void setTel(String tel) {
                        this.tel = tel;
                    }

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeString(relative);
                        dest.writeString(name);
                        dest.writeString(tel);
                    }
                }

                public static class MotherEntity implements Parcelable {
                    /**
                     * relative : 妈妈
                     * name : 妈妈
                     * tel : 15067126311
                     */

                    private String relative;
                    private String name;
                    private String tel;

                    protected MotherEntity(Parcel in) {
                        relative = in.readString();
                        name = in.readString();
                        tel = in.readString();
                    }

                    public static final Creator<MotherEntity> CREATOR = new Creator<MotherEntity>() {
                        @Override
                        public MotherEntity createFromParcel(Parcel in) {
                            return new MotherEntity(in);
                        }

                        @Override
                        public MotherEntity[] newArray(int size) {
                            return new MotherEntity[size];
                        }
                    };

                    public String getRelative() {
                        return relative;
                    }

                    public void setRelative(String relative) {
                        this.relative = relative;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getTel() {
                        return tel;
                    }

                    public void setTel(String tel) {
                        this.tel = tel;
                    }

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeString(relative);
                        dest.writeString(name);
                        dest.writeString(tel);
                    }
                }

                public static class FatherEntity implements Parcelable {
                    /**
                     * relative : 妈妈
                     * name : 妈妈
                     * tel : 15067126311
                     */

                    private String relative;
                    private String name;
                    private String tel;

                    protected FatherEntity(Parcel in) {
                        relative = in.readString();
                        name = in.readString();
                        tel = in.readString();
                    }

                    public static final Creator<FatherEntity> CREATOR = new Creator<FatherEntity>() {
                        @Override
                        public FatherEntity createFromParcel(Parcel in) {
                            return new FatherEntity(in);
                        }

                        @Override
                        public FatherEntity[] newArray(int size) {
                            return new FatherEntity[size];
                        }
                    };

                    public String getRelative() {
                        return relative;
                    }

                    public void setRelative(String relative) {
                        this.relative = relative;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getTel() {
                        return tel;
                    }

                    public void setTel(String tel) {
                        this.tel = tel;
                    }

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeString(relative);
                        dest.writeString(name);
                        dest.writeString(tel);
                    }
                }
            }

            public static class XuexinEntity implements Parcelable {
                /**
                 * user : xuexin
                 * pwd : **********
                 */

                private String user;
                private String pwd;

                protected XuexinEntity(Parcel in) {
                    user = in.readString();
                    pwd = in.readString();
                }

                public static final Creator<XuexinEntity> CREATOR = new Creator<XuexinEntity>() {
                    @Override
                    public XuexinEntity createFromParcel(Parcel in) {
                        return new XuexinEntity(in);
                    }

                    @Override
                    public XuexinEntity[] newArray(int size) {
                        return new XuexinEntity[size];
                    }
                };

                public String getUser() {
                    return user;
                }

                public void setUser(String user) {
                    this.user = user;
                }

                public String getPwd() {
                    return pwd;
                }

                public void setPwd(String pwd) {
                    this.pwd = pwd;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(user);
                    dest.writeString(pwd);
                }
            }

            public static class CompanyEntity implements Parcelable {
                /**
                 * company_name : 新苗
                 * company_tel : 66666666666
                 * company_img : [{"name":"工作证/入职协议","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-26/5860f0c730ddd.jpg"},{"name":"公司照片","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg"},{"name":"更多照片","image":"http://139.196.214.241:8100/Uploads/Picture/2016-12-27/5861c14817465.jpg"}]
                 * company_year : 2018.8.8
                 * work_year : 90
                 * work_money : 99999999.00
                 * company_work : 安卓
                 */

                private String company_name;
                private String company_tel;
                private String company_year;
                private String work_year;
                private String work_money;
                private String company_work;
                private List<CompanyImgEntity> company_img;

                protected CompanyEntity(Parcel in) {
                    company_name = in.readString();
                    company_tel = in.readString();
                    company_year = in.readString();
                    work_year = in.readString();
                    work_money = in.readString();
                    company_work = in.readString();
                }

                public static final Creator<CompanyEntity> CREATOR = new Creator<CompanyEntity>() {
                    @Override
                    public CompanyEntity createFromParcel(Parcel in) {
                        return new CompanyEntity(in);
                    }

                    @Override
                    public CompanyEntity[] newArray(int size) {
                        return new CompanyEntity[size];
                    }
                };

                public String getCompany_name() {
                    return company_name;
                }

                public void setCompany_name(String company_name) {
                    this.company_name = company_name;
                }

                public String getCompany_tel() {
                    return company_tel;
                }

                public void setCompany_tel(String company_tel) {
                    this.company_tel = company_tel;
                }

                public String getCompany_year() {
                    return company_year;
                }

                public void setCompany_year(String company_year) {
                    this.company_year = company_year;
                }

                public String getWork_year() {
                    return work_year;
                }

                public void setWork_year(String work_year) {
                    this.work_year = work_year;
                }

                public String getWork_money() {
                    return work_money;
                }

                public void setWork_money(String work_money) {
                    this.work_money = work_money;
                }

                public String getCompany_work() {
                    return company_work;
                }

                public void setCompany_work(String company_work) {
                    this.company_work = company_work;
                }

                public List<CompanyImgEntity> getCompany_img() {
                    return company_img;
                }

                public void setCompany_img(List<CompanyImgEntity> company_img) {
                    this.company_img = company_img;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(company_name);
                    dest.writeString(company_tel);
                    dest.writeString(company_year);
                    dest.writeString(work_year);
                    dest.writeString(work_money);
                    dest.writeString(company_work);
                }

                public static class CompanyImgEntity implements Parcelable {
                    /**
                     * name : 工作证/入职协议
                     * image : http://139.196.214.241:8100/Uploads/Picture/2016-12-26/5860f0c730ddd.jpg
                     */

                    private String name;
                    private String image;

                    protected CompanyImgEntity(Parcel in) {
                        name = in.readString();
                        image = in.readString();
                    }

                    public static final Creator<CompanyImgEntity> CREATOR = new Creator<CompanyImgEntity>() {
                        @Override
                        public CompanyImgEntity createFromParcel(Parcel in) {
                            return new CompanyImgEntity(in);
                        }

                        @Override
                        public CompanyImgEntity[] newArray(int size) {
                            return new CompanyImgEntity[size];
                        }
                    };

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeString(name);
                        dest.writeString(image);
                    }
                }
            }
        }

        public static class OtherMenuEntity implements Parcelable {
            /**
             * id : 20
             * name : 其他资料
             * pid : 3
             * other_img : null
             */

            private String id;
            private String name;
            private String pid;
            private List<OtherImage> other_img;
            private int up_type;

            protected OtherMenuEntity(Parcel in) {
                id = in.readString();
                name = in.readString();
                pid = in.readString();
                up_type = in.readInt();
            }


            public static final Creator<OtherMenuEntity> CREATOR = new Creator<OtherMenuEntity>() {
                @Override
                public OtherMenuEntity createFromParcel(Parcel in) {
                    return new OtherMenuEntity(in);
                }

                @Override
                public OtherMenuEntity[] newArray(int size) {
                    return new OtherMenuEntity[size];
                }
            };

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public List<OtherImage> getOther_img() {
                return other_img;
            }

            public void setOther_img(List<OtherImage> other_img) {
                this.other_img = other_img;
            }

            public int getUp_type() {
                return up_type;
            }

            public void setUp_type(int up_type) {
                this.up_type = up_type;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(id);
                dest.writeString(name);
                dest.writeString(pid);
                dest.writeInt(up_type);
            }

            public static class OtherImage implements Parcelable {
                private String name;
                private String image;

                protected OtherImage(Parcel in) {
                    name = in.readString();
                    image = in.readString();
                }

                public static final Creator<OtherImage> CREATOR = new Creator<OtherImage>() {
                    @Override
                    public OtherImage createFromParcel(Parcel in) {
                        return new OtherImage(in);
                    }

                    @Override
                    public OtherImage[] newArray(int size) {
                        return new OtherImage[size];
                    }
                };

                public void setName(String name) {
                    this.name = name;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getName() {
                    return name;
                }

                public String getImage() {
                    return image;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(name);
                    dest.writeString(image);
                }
            }

        }

        public static class BaseMenuEntity implements Parcelable {
            /**
             * id : 8
             * up_type : 3
             * menu_name : unit
             * remark : 单位
             */

            private String id;
            private int up_type;
            private String menu_name;
            private String remark;

            protected BaseMenuEntity(Parcel in) {
                id = in.readString();
                up_type = in.readInt();
                menu_name = in.readString();
                remark = in.readString();
            }

            public static final Creator<BaseMenuEntity> CREATOR = new Creator<BaseMenuEntity>() {
                @Override
                public BaseMenuEntity createFromParcel(Parcel in) {
                    return new BaseMenuEntity(in);
                }

                @Override
                public BaseMenuEntity[] newArray(int size) {
                    return new BaseMenuEntity[size];
                }
            };

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getUp_type() {
                return up_type;
            }

            public void setUp_type(int up_type) {
                this.up_type = up_type;
            }

            public String getMenu_name() {
                return menu_name;
            }

            public void setMenu_name(String menu_name) {
                this.menu_name = menu_name;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(id);
                dest.writeInt(up_type);
                dest.writeString(menu_name);
                dest.writeString(remark);
            }
        }
    }
}
