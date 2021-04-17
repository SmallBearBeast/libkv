package com.bear.libkv.SpVal;

import androidx.annotation.NonNull;

class SpStringVal extends SpVal<String> {
    SpStringVal(String spName, String key, String val) {
        super(spName, key);
        mVal = getSp().getString(getKey(), val);
    }

    @NonNull
    @Override
    public String get() {
        return mVal = getSp().getString(getKey(), mVal);
    }

    @Override
    public void set(@NonNull String val) {
        mVal = val;
        getEditor().putString(getKey(), mVal).apply();
    }

    @Override
    public void reverse() {
        throw new RuntimeException("SpStringVal doesn't support reverse");
    }

    @Override
    public void reset() {
        set("");
    }

    @Override
    public void inc() {
        throw new RuntimeException("SpStringVal doesn't support inc");
    }

    @Override
    public void dec() {
        throw new RuntimeException("SpStringVal doesn't support dec");
    }

    @Override
    public void plus(@NonNull String num) {
        throw new RuntimeException("SpStringVal doesn't support plus");
    }

    @Override
    public void minus(@NonNull String num) {
        throw new RuntimeException("SpStringVal doesn't support minus");
    }
}
