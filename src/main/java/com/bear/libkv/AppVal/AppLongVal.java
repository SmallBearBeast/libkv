package com.bear.libkv.AppVal;

public class AppLongVal extends AppVal {
    private long mVal;

    public AppLongVal(String key, long val) {
        super(key);
        mVal = getSp().getLong(getKey(), val);
    }

    public AppLongVal(String spName, String key, long val) {
        super(spName, key);
        mVal = getSp().getLong(getKey(), val);
    }

    public long get() {
        return mVal = getSp().getLong(getKey(), mVal);
    }

    public void set(long val) {
        mVal = val;
        getEditor().putLong(getKey(), mVal).apply();
    }

    public void inc() {
        set(mVal + 1);
    }

    public void dec() {
        set(mVal - 1);
    }

    public void plus(long num) {
        set(mVal + num);
    }

    public void minus(long num) {
        set(mVal - num);
    }

    public void reset() {
        set(0L);
    }
}
