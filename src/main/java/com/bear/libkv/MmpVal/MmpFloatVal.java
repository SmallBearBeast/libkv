package com.bear.libkv.MmpVal;

import com.tencent.mmkv.MMKV;

public class MmpFloatVal extends MmpVal {
    private float mVal;

    public MmpFloatVal(String key, float val) {
        super(key);
        mVal = val;
    }

    public MmpFloatVal(String mmkvId, String key, float val) {
        super(mmkvId, key);
        mVal = val;
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
