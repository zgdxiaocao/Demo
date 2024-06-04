package com.zgd;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试countDownLaunch的demo
 *
 * @author zgd
 */
public class CountDownLaunchDemo {
    public static CountDownLatch countDownLatch = new CountDownLatch(5);

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(5));

        for (int i = 0; i < 5; i++) {
            executor.submit(new Print());
        }

        // 等待
        countDownLatch.await();
        System.out.println("主线程执行");
    }


    public static class Print implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "执行");
            countDownLatch.countDown();
        }

    }
}
