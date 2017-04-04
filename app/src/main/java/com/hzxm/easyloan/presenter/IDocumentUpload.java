package com.hzxm.easyloan.presenter;

import java.io.File;

/**
 * 作者：LMZ on 2016/12/26 0026 16:39
 * 证件上传
 */
public interface IDocumentUpload {
    void uploadFace(File file, String uid, String hashid, int type);

    void baseinfoImg(String uid, String cardImgFace, String cardImgBack, String cardImgAll);
}
