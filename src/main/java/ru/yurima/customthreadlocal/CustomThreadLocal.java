package ru.yurima.customthreadlocal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomThreadLocal<T> {
    Map<Long, T> store = new ConcurrentHashMap<>();



}
