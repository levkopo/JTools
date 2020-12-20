package com.github.levkoposc.atomic;

public interface AtomicRun<T, V> {
    T get(V object);
}
