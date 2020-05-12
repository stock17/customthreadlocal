package ru.yurima.customthreadlocal;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public class CustomThreadLocal<T> implements IThreadLocal<T>{
    private final Map<Thread, T> store = Collections.synchronizedMap(new WeakHashMap<>());

    @Override
    public void set(T value) {
        Thread thread = Thread.currentThread();
        store.put(thread, value);
    }

    @Override
    public T get() {
        Thread thread = Thread.currentThread();
        return store.get(thread);
    }

    @Override
    public void remove() {
        Thread thread = Thread.currentThread();
        store.remove(thread);
    }
}
