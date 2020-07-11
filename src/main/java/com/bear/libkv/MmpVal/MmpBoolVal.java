package com.bear.libkv.MmpVal;

import com.tencent.mmkv.MMKV;

public class MmpBoolVal extends MmpVal {
    private boolean mVal;

    public MmpBoolVal(String key, boolean val) {
        super(key);
        mVal = val;
    }

    public MmpBoolVal(String mmkvId, String key, boolean val) {
        super(mmkvId, key);
        mVal = val;
    }

    public boolean get() {
        return mVal = MMKV.mmkvWithID(getMmkvID()).getBoolean(getKey(), mVal);
    }

    public void set(boolean val) {
        mVal = val;
        MMKV.mmkvWithID(getMmkvID()).putBoolean(getKey(), val);
    }

    public void reverse() {
        set(!mVal);
    }

    public void reset() {
        set(false);
    }
}
