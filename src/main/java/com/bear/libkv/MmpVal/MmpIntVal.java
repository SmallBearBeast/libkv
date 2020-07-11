package com.bear.libkv.MmpVal;

import com.tencent.mmkv.MMKV;

public class MmpIntVal extends MmpVal {
    private int mVal;

    public MmpIntVal(String key, int val) {
        super(key);
        mVal = val;
    }

    public MmpIntVal(String mmkvId, String key, int val) {
        super(mmkvId, key);
        mVal = val;
    }

    public int get() {
        return mVal = MMKV.mmkvWithID(getMmkvID()).getInt(getKey(), mVal);
    }

    public void set(int val) {
        mVal = val;
        MMKV.mmkvWithID(getMmkvID()).putInt(getKey(), val);
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
