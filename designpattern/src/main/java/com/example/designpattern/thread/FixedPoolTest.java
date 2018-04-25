package com.example.designpattern.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Zc on 2018/3/15.
 */

public class FixedPoolTest {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        for (int i=0; i<20; i++) {
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName());
//                }
//            };
//            executorService.execute(runnable);
//        }
        //延迟5秒后执行
//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
//        for (int i = 0; i < 20; i++) {
//            Runnable syncRunnable = new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName());
//                }
//            };
//            executorService.schedule(syncRunnable, 5000, TimeUnit.MILLISECONDS);
//        }

//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
//        Runnable syncRunnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName());
//            }
//        };
//        executorService.scheduleAtFixedRate(syncRunnable, 5000, 3000, TimeUnit.MILLISECONDS);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 20; i++) {
            Runnable syncRunnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executorService.execute(syncRunnable);
        }

    }
}
