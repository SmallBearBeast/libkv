package com.bear.libkv.SpVal;

import android.content.Context;
import android.content.SharedPreferences;

import com.bear.libkv.KV;

import java.util.HashSet;

abstract class SpVal<V> implements KV<V>{
    private static boolean sIsInit = false;
    private static final HashSet<String> sSpNameSet = new HashSet<>();
    private static Context sContext;
    private String mSpName;
    private String mKey;
    protected V mVal;

    SpVal(String spName, String key) {
        checkInit();
        mSpName = spName;
        mKey = key;
        sSpNameSet.add(spName);
    }

    static void init(Context context) {
        sIsInit = true;
        sContext = context;
    }

    static void preload(String... spNames) {
        checkInit();
        for (String spName : spNames) {
            sContext.getSharedPreferences(spName, Context.MODE_PRIVATE);
            sSpNameSet.add(spName);
        }
    }

    static void clear(String... spNames) {
        for (String spName : spNames) {
            if (sSpNameSet.contains(spName)) {
                sContext.getSharedPreferences(spName, Context.MODE_PRIVATE).edit().clear().apply();
                sSpNameSet.remove(spName);
            }
        }
    }

    static void clearAll() {
        for (String spName : sSpNameSet) {
            sContext.getSharedPreferences(spName, Context.MODE_PRIVATE).edit().clear().apply();
            sSpNameSet.clear();
        }
    }

    static void checkInit() {
        if (!sIsInit) {
            throw new RuntimeException("should init MmpVal first");
        }
    }

    SharedPreferences getSp() {
        return sContext.getSharedPreferences(mSpName, Context.MODE_PRIVATE);
    }

    SharedPreferences.Editor getEditor() {
        return sContext.getSharedPreferences(mSpName, Context.MODE_PRIVATE).edit();
    }

    String getKey() {
        return mKey;
    }
}
