package com.bear.libkv.SpVal;

import androidx.annotation.NonNull;

class SpLongVal extends SpVal<Long> {
    SpLongVal(String spName, String key, long val) {
        super(spName, key);
        mVal = getSp().getLong(getKey(), val);
    }

    @NonNull
    @Override
    public Long get() {
        return mVal = getSp().getLong(getKey(), mVal);
    }

    @Override
    public void set(@NonNull Long val) {
        mVal = val;
        getEditor().putLong(getKey(), mVal).apply();
    }

    @Override
    public void reverse() {
        throw new RuntimeException("SpLongVal doesn't support reverse");
    }

    @Override
    public void inc() {
        set(mVal + 1);
    }

    @Override
    public void dec() {
        set(mVal - 1);
    }

    @Override
    public void plus(@NonNull Long num) {
        set(mVal + num);
    }

    @Override
    public void minus(@NonNull Long num) {
        set(mVal - num);
    }

    @Override
    public void reset() {
        set(0L);
    }
}
