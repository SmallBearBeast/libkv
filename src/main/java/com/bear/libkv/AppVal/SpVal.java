package com.bear.libkv.AppVal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;

public abstract class SpVal {
    private static final String DEFAULT_APPVAL_NAME = "default_appval_name";
    private static boolean sIsInit = false;
    private static final HashSet<String> sSpNameSet = new HashSet<>();
    private static Application sApp;
    private String mSpName;
    private String mKey;

    SpVal(String key) {
        this(DEFAULT_APPVAL_NAME, key);
    }

    SpVal(String spName, String key) {
        checkInit();
        mSpName = spName;
        mKey = key;
        sSpNameSet.add(spName);
    }

    public static void init(Application app) {
        sIsInit = true;
        sApp = app;
    }

    public static void preload(String... spNames) {
        checkInit();
        for (String spName : spNames) {
            sApp.getSharedPreferences(spName, Context.MODE_PRIVATE);
            sSpNameSet.add(spName);
        }
    }

    public static void clear(String... spNames) {
        for (String spName : spNames) {
            if (sSpNameSet.contains(spName)) {
                sApp.getSharedPreferences(spName, Context.MODE_PRIVATE).edit().clear().apply();
                sSpNameSet.remove(spName);
            }
        }
    }

    public static void clearAll() {
        for (String spName : sSpNameSet) {
            sApp.getSharedPreferences(spName, Context.MODE_PRIVATE).edit().clear().apply();
            sSpNameSet.clear();
        }
    }

    static void checkInit() {
        if (!sIsInit) {
            throw new RuntimeException("should init MmpVal first");
        }
    }

    SharedPreferences getSp() {
        return sApp.getSharedPreferences(mSpName, Context.MODE_PRIVATE);
    }

    SharedPreferences.Editor getEditor() {
        return sApp.getSharedPreferences(mSpName, Context.MODE_PRIVATE).edit();
    }

    String getKey() {
        return mKey;
    }
}
