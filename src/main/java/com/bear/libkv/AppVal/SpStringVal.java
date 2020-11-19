package com.bear.libkv.AppVal;


public class SpStringVal extends SpVal {
    private String mVal;

    public SpStringVal(String key, String val) {
        super(key);
        mVal = getSp().getString(getKey(), val);
    }


    public SpStringVal(String spName, String key, String val) {
        super(spName, key);
        mVal = getSp().getString(getKey(), val);
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
