package com.bear.libkv.MmkvVal;

import com.tencent.mmkv.MMKV;

public class MmkvFloatVal extends MmkvVal {
    private float mVal;

    public MmkvFloatVal(String key, float val) {
        super(key);
        mVal = MMKV.mmkvWithID(getMmkvID()).getFloat(getKey(), val);
    }

    public MmkvFloatVal(String mmkvId, String key, float val) {
        super(mmkvId, key);
        mVal = MMKV.mmkvWithID(getMmkvID()).getFloat(getKey(), val);
    }

    public float get() {
        return mVal = MMKV.mmkvWithID(getMmkvID()).getFloat(getKey(), mVal);
    }

    public void set(float val) {
        mVal = val;
        MMKV.mmkvWithID(getMmkvID()).putFloat(getKey(), val);
    }

    public void reset() {
        set(0f);
    }
}
