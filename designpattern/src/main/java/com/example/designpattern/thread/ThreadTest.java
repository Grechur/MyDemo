package com.example.designpattern.thread;


import java.util.concurrent.locks.ReentrantLock;

import sun.rmi.runtime.Log;

/**
 * Created by Zc on 2018/3/15.
 */

public class ThreadTest {
    public static final String TAG = "ThreadTest";
    private  int count = 1000;
    private boolean isRunning = false;
    ReentrantLock lock;
    private void test(){
        isRunning = true;
        lock = new ReentrantLock();
        SyncThread syncThread1 = new SyncThread("线程一");
        SyncThread syncThread2 = new SyncThread("线程二");
        SyncThread syncThread3 = new SyncThread("线程三");
        syncThread1.start();
        syncThread2.start();
        syncThread3.start();
    }
    private class SyncThread extends Thread{
        public SyncThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (isRunning) {
                count();
            }
        }
    }
    private void count() {
        lock.lock();
        if (count > 0) {
            System.out.println(Thread.currentThread().getName() + "--->" + count--);
        } else {
            isRunning = false;
        }
        lock.unlock();
    }
    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.test();
    }
}
