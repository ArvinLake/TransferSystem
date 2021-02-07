package com.arvin.bat;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    @Test
    public void test() {
        ReentrantLock lock = new ReentrantLock(true);

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
            }
        }).start();
        lock.lock();
    }
}
