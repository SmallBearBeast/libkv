package com.bear.libkv.AppVal;

public class AppBoolVal extends AppVal {
    private boolean mVal;

    public AppBoolVal(String key, boolean val) {
        super(key);
        mVal = val;
    }

    public AppBoolVal(String spName, String key, boolean val) {
        super(spName, key);
        mVal = val;
    }

    public boolean get() {
        return mVal = getSp().getBoolean(getKey(), mVal);
    }

    public void set(boolean val) {
        mVal = val;
        getEditor().putBoolean(getKey(), mVal).apply();
    }

    public void reverse() {
        set(!mVal);
    }

    public void reset() {
        set(false);
    }
}
