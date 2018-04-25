package com.example.designpattern.thread;

/**
 * Created by Zc on 2018/3/15.
 */

public class VolatileTest {
    private volatile int count = 1000;
    private boolean isRunning = false;
    private void test(){
        isRunning = true;
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

    private synchronized void count() {
            if(count>0){
                System.out.println(Thread.currentThread().getName() + "--->" + count--);
            }else{
                isRunning = false;
            }
    }

    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();
        volatileTest.test();
    }
}
