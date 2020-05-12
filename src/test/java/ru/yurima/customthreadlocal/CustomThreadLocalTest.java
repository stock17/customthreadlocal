package ru.yurima.customthreadlocal;

import org.junit.Test;

public class CustomThreadLocalTest {

    @Test
    public void testCustomThreadLocal() {
        CustomThreadLocal<String> threadLocal = new CustomThreadLocal<>();
        Thread thread1 = new Thread(() -> {
            threadLocal.set("First");
            assert ("First".equals(threadLocal.get()));
            threadLocal.remove();
            assert(threadLocal.get() == null);
        });
        Thread thread2 = new Thread(() -> {
            threadLocal.set("Second");
            assert ("Second".equals(threadLocal.get()));
            threadLocal.remove();
            assert(threadLocal.get() == null);
        });
        thread1.start();
        thread2.start();
    }
}