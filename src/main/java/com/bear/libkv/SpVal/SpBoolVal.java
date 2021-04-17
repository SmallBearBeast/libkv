package com.bear.libkv.SpVal;

import androidx.annotation.NonNull;

class SpBoolVal extends SpVal<Boolean> {
    SpBoolVal(String spName, String key, Boolean val) {
        super(spName, key);
        mVal = getSp().getBoolean(getKey(), val);
    }

    @NonNull
    @Override
    public Boolean get() {
        return mVal = getSp().getBoolean(getKey(), mVal);
    }

    @Override
    public void set(@NonNull Boolean val) {
        mVal = val;
        getEditor().putBoolean(getKey(), mVal).apply();
    }

    @Override
    public void reverse() {
        set(!mVal);
    }

    @Override
    public void reset() {
        set(Boolean.FALSE);
    }

    @Override
    public void inc() {
        throw new RuntimeException("SpBoolVal doesn't support inc");
    }

    @Override
    public void dec() {
        throw new RuntimeException("SpBoolVal doesn't support dec");
    }

    @Override
    public void plus(@NonNull Boolean num) {
        throw new RuntimeException("SpBoolVal doesn't support plus");
    }

    @Override
    public void minus(@NonNull Boolean num) {
        throw new RuntimeException("SpBoolVal doesn't support minus");
    }
}
