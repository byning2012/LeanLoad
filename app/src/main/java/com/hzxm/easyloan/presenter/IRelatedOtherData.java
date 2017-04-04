package com.hzxm.easyloan.presenter;

import java.io.File;

/**
 * 作者：LMZ on 2017/1/3 0003 09:46
 */
public interface IRelatedOtherData {
    void uploadFace(File file, String uid, String hashid, int type);

    void addOtherInfo(String uid, String other_name, String other_img, String type, String other_pid);

    void addInterfix(String uid, String interfix_name, String interfix_img);
}
