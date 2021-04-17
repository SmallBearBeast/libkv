package com.bear.libkv.SpVal;

import androidx.annotation.NonNull;

class SpIntVal extends SpVal<Integer> {
    SpIntVal(String spName, String key, int val) {
        super(spName, key);
        mVal = getSp().getInt(getKey(), val);
    }

    @NonNull
    @Override
    public Integer get() {
        return mVal = getSp().getInt(getKey(), mVal);
    }

    @Override
    public void set(@NonNull Integer val) {
        mVal = val;
        getEditor().putInt(getKey(), mVal).apply();
    }

    @Override
    public void reverse() {
        throw new RuntimeException("SpIntVal doesn't support reverse");
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
    public void plus(@NonNull Integer num) {
        set(mVal + num);
    }

    @Override
    public void minus(@NonNull Integer num) {
        set(mVal - num);
    }

    @Override
    public void reset() {
        set(0);
    }
}
