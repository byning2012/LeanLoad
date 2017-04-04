package com.lmz.baselibrary.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class SharedPreferencesUtil {

    private static SharedPreferencesUtil sharedPreferencesUtil;
    private static Context context;
    private SharedPreferences sharedPreferences;
    private static int mode = context.MODE_PRIVATE;
    private Editor editor;
    private static String sharedPreferenceName = "EasyLoan";


    private SharedPreferencesUtil() {
    }

    public static SharedPreferencesUtil getInstance(Context context) {
        SharedPreferencesUtil.context = context;
        if (sharedPreferencesUtil == null) {
            sharedPreferencesUtil = new SharedPreferencesUtil();
        }
        return sharedPreferencesUtil;
    }

    public static SharedPreferencesUtil getInstance(Context context, String sharedPreferenceName, int mode) {
        SharedPreferencesUtil.context = context;
        SharedPreferencesUtil.sharedPreferenceName = sharedPreferenceName;
        SharedPreferencesUtil.mode = mode;
        if (sharedPreferencesUtil == null) {
            sharedPreferencesUtil = new SharedPreferencesUtil();
        }
        return sharedPreferencesUtil;
    }

    private void createSharedPreferences() {
        sharedPreferences = context.getSharedPreferences(sharedPreferenceName, mode);
    }

    public SharedPreferences getSharedPreferences() {
        createSharedPreferences();
        return sharedPreferences;
    }

    /**
     * 获取 SharedPreferences boolean值
     *
     * @param key      键
     * @param defValue 默认值
     * @return
     */
    public boolean getBoolean(String key, boolean defValue) {
        createSharedPreferences();
        return sharedPreferences.getBoolean(key, defValue);
    }

    /**
     * 获取 SharedPreferences String值
     *
     * @param key      键
     * @param defValue 默认值
     * @return
     */
    public String getString(String key, String defValue) {
        createSharedPreferences();
        return sharedPreferences.getString(key, defValue);
    }


    public void putString(String key, String value) {
        createSharedPreferences();
        editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * 获取 SharedPreferences int值
     *
     * @param key      键
     * @param defValue 默认值
     * @return
     */
    public int getInt(String key, int defValue) {
        createSharedPreferences();
        return sharedPreferences.getInt(key, defValue);
    }


    public void putInt(String key, int value) {
        createSharedPreferences();
        editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public void putBoolean(String key, boolean value) {
        createSharedPreferences();
        editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * 删除key
     *
     * @param key
     */
    public void removeKey(String key) {
        createSharedPreferences();
        editor = sharedPreferences.edit();
        editor.remove(key);
        editor.commit();
        Log.e("zzz", "removeKey: " + key);
    }

    /**
     * 清空所有的key
     */
    public void clearKey() {
        createSharedPreferences();
        editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    List<HashMap<String, String>> datas = new ArrayList<>();
    List<HashMap<String, String>> getDatas = new ArrayList<>();

    public void removeContent(Context context, String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        Editor edit = sharedPreferences.edit();
        edit.clear();
        edit.commit();
    }

    public void removeInfo(Context context, String key, int data) {
        List<HashMap<String, String>> listInfo = getListInfo(context, key);
        listInfo.remove(data);
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < listInfo.size(); i++) {
            JSONObject object = new JSONObject();
            HashMap<String, String> itemMap = listInfo.get(i);
            Iterator<Map.Entry<String, String>> iterator = itemMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> next = iterator.next();
                try {
                    object.put(next.getKey(), next.getValue());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            jsonArray.put(object);
        }
        Log.e("zzz", "removeInfo: " + listInfo);
        SharedPreferences sharedPreferences = context.getSharedPreferences("addcollect", Context.MODE_PRIVATE);
        Editor edit = sharedPreferences.edit();
        edit.putString(key, jsonArray.toString());
        edit.commit();

    }


    public void listInfo(Context context, String key, HashMap<String, String> hashMap) {
        datas.clear();
        List<HashMap<String, String>> listInfo = getListInfo(context, key);
        if (listInfo != null) {
            datas.addAll(listInfo);
        }
        if (hashMap != null) {
            datas.add(hashMap);
        }
        JSONArray jsonArray = new JSONArray();
        Log.e("datas:", datas.size() + "");
        for (int i = 0; i < datas.size(); i++) {
            JSONObject object = new JSONObject();
            HashMap<String, String> itemMap = datas.get(i);
            Iterator<Map.Entry<String, String>> iterator = itemMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> next = iterator.next();
                try {
                    object.put(next.getKey(), next.getValue());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            jsonArray.put(object);
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("addcollect", Context.MODE_PRIVATE);
        Editor edit = sharedPreferences.edit();
        edit.putString(key, jsonArray.toString());
        edit.commit();
        Log.e("zzz", "datas: " + datas);
    }

    public List<HashMap<String, String>> getListInfo(Context context, String key) {
        getDatas.clear();
        SharedPreferences sp = context.getSharedPreferences("addcollect", Context.MODE_PRIVATE);
        String result = sp.getString(key, "");
        try {
            JSONArray array = new JSONArray(result);
            for (int i = 0; i < array.length(); i++) {
                JSONObject itemObject = array.getJSONObject(i);
                JSONArray names = itemObject.names();
                HashMap<String, String> itemMap = new HashMap<>();
                if (names != null) {
                    for (int j = 0; j < names.length(); j++) {
                        int name = names.getInt(j);
                        String value = itemObject.getString(name + "");
                        itemMap.put(name + "", value);
                    }
                }
                getDatas.add(itemMap);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e("zzz", "getListInfo: " + getDatas);
        return getDatas;
    }


    public void saveInfo(Context context, String key, List<Map<String, String>> datas) {
        JSONArray mJsonArray = new JSONArray();
        for (int i = 0; i < datas.size(); i++) {
            Map<String, String> itemMap = datas.get(i);
            Iterator<Map.Entry<String, String>> iterator = itemMap.entrySet().iterator();
            JSONObject object = new JSONObject();

            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                try {
                    object.put(entry.getKey(), entry.getValue());
                } catch (JSONException e) {

                }
            }
            mJsonArray.put(object);
        }

        SharedPreferences sp = context.getSharedPreferences("finals", Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putString(key, mJsonArray.toString());
        editor.commit();
    }

    public List<Map<String, String>> getInfo(Context context, String key) {
        List<Map<String, String>> datas = new ArrayList<Map<String, String>>();
        SharedPreferences sp = context.getSharedPreferences("finals", Context.MODE_PRIVATE);
        String result = sp.getString(key, "");
        try {
            JSONArray array = new JSONArray(result);
            for (int i = 0; i < array.length(); i++) {
                JSONObject itemObject = array.getJSONObject(i);
                Map<String, String> itemMap = new HashMap<String, String>();
                JSONArray names = itemObject.names();
                if (names != null) {
                    for (int j = 0; j < names.length(); j++) {
                        String name = names.getString(j);
                        String value = itemObject.getString(name);
                        itemMap.put(name, value);
                    }
                }
                datas.add(itemMap);
            }
        } catch (JSONException e) {

        }

        return datas;
    }

    public void saveMap(Context context, String key, List<Map<Integer, String>> datas) {
        JSONArray mJsonArray = new JSONArray();
        for (int i = 0; i < datas.size(); i++) {
            Map<Integer, String> itemMap = datas.get(i);
            Iterator<Map.Entry<Integer, String>> iterator = itemMap.entrySet().iterator();
            JSONObject object = new JSONObject();

            while (iterator.hasNext()) {
                Map.Entry<Integer, String> entry = iterator.next();
                try {
                    object.put(entry.getKey() + "", entry.getValue());
                } catch (JSONException e) {

                }
            }
            mJsonArray.put(object);
        }

        SharedPreferences sp = context.getSharedPreferences("finals", Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.putString(key, mJsonArray.toString());
        editor.commit();
    }

    public List<Map<Integer, String>> getMap(Context context, String key) {
        List<Map<Integer, String>> datas = new ArrayList<Map<Integer, String>>();
        SharedPreferences sp = context.getSharedPreferences("finals", Context.MODE_PRIVATE);
        String result = sp.getString(key, "");
        try {
            JSONArray array = new JSONArray(result);
            for (int i = 0; i < array.length(); i++) {
                JSONObject itemObject = array.getJSONObject(i);
                Map<Integer, String> itemMap = new HashMap<Integer, String>();
                JSONArray names = itemObject.names();
                if (names != null) {
                    for (int j = 0; j < names.length(); j++) {
                        int name = names.getInt(j);
                        String value = itemObject.getString(name + "");
                        itemMap.put(name, value);
                    }
                }
                datas.add(itemMap);
            }
        } catch (JSONException e) {

        }

        return datas;
    }


}
