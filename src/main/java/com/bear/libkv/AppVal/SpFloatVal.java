package com.bear.libkv.AppVal;

public class SpFloatVal extends SpVal {
    private float mVal;

    public SpFloatVal(String key, float val) {
        super(key);
        mVal = getSp().getFloat(getKey(), val);
    }

    public SpFloatVal(String spName, String key, float val) {
        super(spName, key);
        mVal = getSp().getFloat(getKey(), val);
    }

    public float get() {
        return mVal = getSp().getFloat(getKey(), mVal);
    }

    public void set(float val) {
        mVal = val;
        getEditor().putFloat(getKey(), mVal).apply();
    }

    public void reset() {
        set(0f);
    }
}
