package com.bear.libkv.MmkvVal;

import com.tencent.mmkv.MMKV;

public class MmkvIntVal extends MmkvVal {
    private int mVal;

    public MmkvIntVal(String key, int val) {
        super(key);
        mVal = MMKV.mmkvWithID(getMmkvID()).getInt(getKey(), val);
    }

    public MmkvIntVal(String mmkvId, String key, int val) {
        super(mmkvId, key);
        mVal = MMKV.mmkvWithID(getMmkvID()).getInt(getKey(), val);
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
