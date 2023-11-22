package com.bear.libkv.MmkvVal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.tencent.mmkv.MMKV;

import java.util.HashSet;

public abstract class MmkvVal {
    private static final String SP_TO_MMKV_FLAG = "sp_to_mmkv_flag";
    public static final String DEFAULT_MMPVAL_ID = "default_mmpval_id";
    private static boolean sIsInit = false;
    private static final HashSet<String> sMmkvIdSet = new HashSet<>();
    private String mMmkvId;
    private String mKey;

    MmkvVal(String key) {
        this(DEFAULT_MMPVAL_ID, key);
    }

    MmkvVal(String mmkvId, String key) {
        checkInit();
        mMmkvId = mmkvId;
        mKey = key;
        sMmkvIdSet.add(mmkvId);
    }

    public static void init(Context context) {
        sIsInit = true;
        MMKV.initialize(context);
    }

    static void checkInit() {
        if (!sIsInit) {
            throw new RuntimeException("should init MmpVal first");
        }
    }

    public static void clear(String... mmkvIds) {
        for (String mmkvId : mmkvIds) {
            if (sMmkvIdSet.contains(mmkvId)) {
                MMKV.mmkvWithID(mmkvId).clearAll();
                sMmkvIdSet.remove(mmkvId);
            }
        }
    }

    public static void clearAll() {
        for (String mmkvId : sMmkvIdSet) {
            MMKV.mmkvWithID(mmkvId).clearAll();
            sMmkvIdSet.clear();
        }
    }

    public static void importFromSharedPreferences(Context context, String mmkvId, String spName) {
        checkInit();
        mmkvId = TextUtils.isEmpty(mmkvId) ? DEFAULT_MMPVAL_ID : mmkvId;
        MMKV mmkv = MMKV.mmkvWithID(mmkvId);
        if (!mmkv.contains(SP_TO_MMKV_FLAG)) {
            SharedPreferences preferences = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
            MMKV.mmkvWithID(mmkvId).importFromSharedPreferences(preferences);
            preferences.edit().clear().apply();
            mmkv.putBoolean(SP_TO_MMKV_FLAG, true);
        }
    }

    String getKey() {
        return mKey;
    }

    String getMmkvID() {
        return mMmkvId;
    }
}
