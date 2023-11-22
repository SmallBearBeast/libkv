package com.bear.libkv.SpVal;

import android.app.Application;
import android.content.Context;

import com.bear.libkv.KV;

public class SpHelper {
    public static final String DEFAULT_SPVAL_NAME = "default_spval_name";

    public static <V> KV<V> create(String key, V val) {
        return create(DEFAULT_SPVAL_NAME, key, val);
    }

    public static <V> KV<V> create(String name, String key, V val) {
        if (val instanceof Boolean) {
            return (KV<V>) new SpBoolVal(name, key, (Boolean) val);
        } else if (val instanceof Float) {
            return (KV<V>) new SpFloatVal(name, key, (Float)val);
        } else if (val instanceof Integer) {
            return (KV<V>) new SpIntVal(name, key, (Integer)val);
        } else if (val instanceof Long) {
            return (KV<V>) new SpLongVal(name, key, (Long)val);
        } else if (val instanceof String) {
            return (KV<V>) new SpStringVal(name, key, (String)val);
        }
        throw new RuntimeException();
    }

    public static void init(Context context) {
        SpVal.init(context);
    }

    public static void preload(String... spNames) {
        SpVal.preload(spNames);
    }

    public static void clear(String... spNames) {
        SpVal.clear(spNames);
    }

    public static void clearAll() {
        SpVal.clearAll();
    }
}
