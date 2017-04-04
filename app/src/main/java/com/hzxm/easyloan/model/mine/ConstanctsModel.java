package com.hzxm.easyloan.model.mine;

/**
 * 作者：LMZ on 2016/12/28 0028 11:59
 * 通讯录的Model
 */
public class ConstanctsModel {
    private String name;
    private String num;

    public ConstanctsModel(String name, String num) {
        this.name = name;
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }
}
