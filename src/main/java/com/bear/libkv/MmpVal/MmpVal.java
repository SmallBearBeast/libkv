package com.bear.libkv.MmpVal;

import android.app.Application;

import com.tencent.mmkv.MMKV;

import java.util.HashSet;

public abstract class MmpVal {
    static final String DEFAULT_MMPVAL_ID = "default_mmpval_id";
    private static boolean sIsInit = false;
    private static final HashSet<String> sMmkvIdSet = new HashSet<>();
    private String mMmkvId;
    private String mKey;

    MmpVal(String key) {
        this(DEFAULT_MMPVAL_ID, key);
    }

    MmpVal(String mmkvId, String key) {
        checkInit();
        mMmkvId = mmkvId;
        mKey = key;
        sMmkvIdSet.add(mmkvId);
    }

    public static void init(Application app) {
        sIsInit = true;
        MMKV.initialize(app);
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
            }
        }
    }

    public static void clearAll() {
        for (String mmkvId : sMmkvIdSet) {
            MMKV.mmkvWithID(mmkvId).clearAll();
        }
    }

    String getKey() {
        return mKey;
    }

    String getMmkvID() {
        return mMmkvId;
    }
}
