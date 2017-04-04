package com.hzxm.easyloan.model.chamberlain;

import java.util.List;

/**
 * 作者：LMZ on 2016/12/29 0029 14:49
 */
public class CommonProblemModel {

    /**
     * Code : 0
     * Msg : ok
     * Time : 2017-01-06 16:14:39
     * ApiUrl : /Api/Systeminfo/getsystem.html
     * Data : [{"name":"认证问题","img":"/Uploads/Systemmenu/2016-12-29/5864d61b4ee8b.jpg","content":[{"title":"认证问题呢","content":"你猜猜","create_time":"1483004149"},{"title":"OK","content":"偶看","create_time":"1483005228"}]},{"name":"逾期问题","img":"/Uploads/Systemmenu/2016-12-29/5864da16030bc.jpg","content":[{"title":"等死把你","content":"等死把你","create_time":"1483004477"},{"title":"嘻嘻嘻","content":"嘻嘻嘻","create_time":"1483005236"},{"title":"厉害了我的哥","content":"厉害了我的哥","create_time":"1483005249"}]},{"name":"贷款问题","img":"/Uploads/Systemmenu/2016-12-29/5864da29355cf.jpg","content":[{"title":"不借就是傻","content":"不借就是傻","create_time":"1483004489"}]}]
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
         * name : 认证问题
         * img : /Uploads/Systemmenu/2016-12-29/5864d61b4ee8b.jpg
         * content : [{"title":"认证问题呢","content":"你猜猜","create_time":"1483004149"},{"title":"OK","content":"偶看","create_time":"1483005228"}]
         */

        private String name;
        private String img;
        private List<ContentEntity> content;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public List<ContentEntity> getContent() {
            return content;
        }

        public void setContent(List<ContentEntity> content) {
            this.content = content;
        }

        public static class ContentEntity {
            public ContentEntity(String title, String content, String create_time) {
                this.title = title;
                this.content = content;
                this.create_time = create_time;
            }

            /**
             * title : 认证问题呢
             * content : 你猜猜
             * create_time : 1483004149
             */

            private String title;
            private String content;
            private String create_time;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }
        }
    }
}
