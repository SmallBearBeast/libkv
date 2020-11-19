package com.bear.libkv.AppVal;

public class AppFloatVal extends AppVal {
    private float mVal;

    public AppFloatVal(String key, float val) {
        super(key);
        mVal = getSp().getFloat(getKey(), val);
    }

    public AppFloatVal(String spName, String key, float val) {
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
