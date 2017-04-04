package com.hzxm.easyloan.presenter;

import java.io.File;

/**
 * 作者：LMZ on 2016/12/30 0030 17:20
 */
public interface IPropertyCar {
    void uploadFace(File file, String uid, String hashid, int type);

    //房产证信息
    void houseMessage(String uid, String house_img, String house_back_img);

    //车辆信息
    void carMessage(String uid, String car_img, String car_back_img);

}
