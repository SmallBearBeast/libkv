package com.bear.libkv.MmkvVal;

import com.tencent.mmkv.MMKV;

public class MmkvBoolVal extends MmkvVal {
    private boolean mVal;

    public MmkvBoolVal(String key, boolean val) {
        super(key);
        mVal = MMKV.mmkvWithID(getMmkvID()).getBoolean(getKey(), val);
    }

    public MmkvBoolVal(String mmkvId, String key, boolean val) {
        super(mmkvId, key);
        mVal = MMKV.mmkvWithID(getMmkvID()).getBoolean(getKey(), val);
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
