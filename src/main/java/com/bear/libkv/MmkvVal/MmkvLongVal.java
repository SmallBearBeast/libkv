package com.bear.libkv.MmkvVal;

import com.tencent.mmkv.MMKV;

public class MmkvLongVal extends MmkvVal {
    private long mVal;

    public MmkvLongVal(String key, long val) {
        super(key);
        mVal = MMKV.mmkvWithID(getMmkvID()).getLong(getKey(), val);
    }

    public MmkvLongVal(String mmkvId, String key, long val) {
        super(mmkvId, key);
        mVal = MMKV.mmkvWithID(getMmkvID()).getLong(getKey(), val);
    }

    public long get() {
        return mVal = MMKV.mmkvWithID(getMmkvID()).getLong(getKey(), mVal);
    }

    public void set(long val) {
        mVal = val;
        MMKV.mmkvWithID(getMmkvID()).getLong(getKey(), val);
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
