package com.bear.libkv.MmpVal;

import com.tencent.mmkv.MMKV;

public class MmpStringVal extends MmpVal {
    private String mVal;

    public MmpStringVal(String key, String val) {
        super(key);
        mVal = val;
    }

    public MmpStringVal(String mmkvId, String key, String val) {
        super(mmkvId, key);
        mVal = val;
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
