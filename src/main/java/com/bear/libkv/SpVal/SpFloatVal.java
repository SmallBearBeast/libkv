package com.bear.libkv.SpVal;

import androidx.annotation.NonNull;

class SpFloatVal extends SpVal<Float> {
    SpFloatVal(String spName, String key, float val) {
        super(spName, key);
        mVal = getSp().getFloat(getKey(), val);
    }

    @NonNull
    @Override
    public Float get() {
        return mVal = getSp().getFloat(getKey(), mVal);
    }

    @Override
    public void set(@NonNull Float val) {
        mVal = val;
        getEditor().putFloat(getKey(), mVal).apply();
    }

    @Override
    public void reverse() {
        throw new RuntimeException("SpFloatVal doesn't support reverse");
    }

    @Override
    public void reset() {
        set(0f);
    }

    @Override
    public void inc() {
        throw new RuntimeException("SpFloatVal doesn't support inc");
    }

    @Override
    public void dec() {
        throw new RuntimeException("SpFloatVal doesn't support dec");
    }

    @Override
    public void plus(@NonNull Float num) {
        throw new RuntimeException("SpFloatVal doesn't support plus");
    }

    @Override
    public void minus(@NonNull Float num) {
        throw new RuntimeException("SpFloatVal doesn't support minus");
    }
}
