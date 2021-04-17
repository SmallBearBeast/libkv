package com.bear.libkv;

import androidx.annotation.NonNull;

public interface KV<V> {
    @NonNull V get();

    void set(@NonNull V val);

    void reverse();

    void reset();

    void inc();

    void dec();

    void plus(@NonNull V num);

    void minus(@NonNull V num);
}
