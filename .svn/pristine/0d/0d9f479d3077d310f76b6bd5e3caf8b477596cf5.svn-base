package com.hzxm.easyloan.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;

import com.hzxm.easyloan.model.mine.ConstanctsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：LMZ on 2016/12/28 0028 12:04
 * 获取系统的一些信息
 */
public class NeedPermissionUtils {
    private List<ConstanctsModel> constancts;
    /**
     * 获取通讯录
     *
     * @param context
     * @return
     */
    public List<ConstanctsModel> GetConstanctsInfo(Context context) {
        constancts = new ArrayList<>();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
        while (cursor.moveToNext()) {
            //通讯录的名字
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            //通讯录的号码
            String num = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            constancts.add(new ConstanctsModel(name, num));
            Log.e("TAG", "用户名" + name + "-----" + "手机号：" + num);
        }
        cursor.close();
        return constancts;
    }

}
