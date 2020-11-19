package com.bear.libkv.AppVal;


public class SpIntVal extends SpVal {
    private int mVal;

    public SpIntVal(String key, int val) {
        super(key);
        mVal = getSp().getInt(getKey(), val);
    }

    public SpIntVal(String spName, String key, int val) {
        super(spName, key);
        mVal = getSp().getInt(getKey(), val);
    }

    public int get() {
        return mVal = getSp().getInt(getKey(), mVal);
    }

    public void set(int val) {
        mVal = val;
        getEditor().putInt(getKey(), mVal).apply();
    }

    public void inc() {
        set(mVal + 1);
    }

    public void dec() {
        set(mVal - 1);
    }

    public void plus(int num) {
        set(mVal + num);
    }

    public void minus(int num) {
        set(mVal - num);
    }

    public void reset() {
        set(0);
    }
}
