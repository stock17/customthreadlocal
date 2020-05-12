package ru.yurima.customthreadlocal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomThreadLocal<T> implements IThreadLocal<T>{
    private volatile Map<Thread, T> store = new ConcurrentHashMap<>();

    @Override
    public synchronized void set(T value) {
        Thread thread = Thread.currentThread();
        store.put(thread, value);
    }

    @Override
    public synchronized T get() {
        Thread thread = Thread.currentThread();
        return store.get(thread);
    }

    @Override
    public synchronized void remove() {
        Thread thread = Thread.currentThread();
        store.remove(thread);
    }
}
