package com.bear.libkv.AppVal;

public class SpBoolVal extends SpVal {
    private boolean mVal;

    public SpBoolVal(String key, boolean val) {
        super(key);
        mVal = getSp().getBoolean(getKey(), val);
    }

    public SpBoolVal(String spName, String key, boolean val) {
        super(spName, key);
        mVal = getSp().getBoolean(getKey(), val);
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
