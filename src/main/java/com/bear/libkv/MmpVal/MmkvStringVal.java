package com.bear.libkv.MmpVal;

import com.tencent.mmkv.MMKV;

public class MmkvStringVal extends MmkvVal {
    private String mVal;

    public MmkvStringVal(String key, String val) {
        super(key);
        mVal = MMKV.mmkvWithID(getMmkvID()).getString(getKey(), val);
    }

    public MmkvStringVal(String mmkvId, String key, String val) {
        super(mmkvId, key);
        mVal = MMKV.mmkvWithID(getMmkvID()).getString(getKey(), val);
    }

    public String get() {
        return mVal = MMKV.mmkvWithID(getMmkvID()).getString(getKey(), mVal);
    }

    public void set(String val) {
        mVal = val;
        MMKV.mmkvWithID(getMmkvID()).putString(getKey(), val);
    }

    public void reset() {
        set("");
    }
}
