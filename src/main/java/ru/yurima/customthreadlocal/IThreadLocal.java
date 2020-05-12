package ru.yurima.customthreadlocal;

public interface IThreadLocal<T> {
    void set(T value);
    T get();
    void remove();
}
