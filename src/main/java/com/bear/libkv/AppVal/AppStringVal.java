package com.bear.libkv.AppVal;


public class AppStringVal extends AppVal {
    private String mVal;

    public AppStringVal(String key, String val) {
        super(key);
        mVal = val;
    }


    public AppStringVal(String spName, String key, String val) {
        super(spName, key);
        mVal = val;
    }

    public String get() {
        return mVal = getSp().getString(getKey(), mVal);
    }

    public void set(String val) {
        mVal = val;
        getEditor().putString(getKey(), mVal).apply();
    }

    public void reset() {
        set("");
    }
}
