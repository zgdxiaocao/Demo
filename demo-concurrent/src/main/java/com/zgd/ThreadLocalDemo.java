package com.zgd;

/**
 * @author zgd
 */
public class ThreadLocalDemo {

    public static void main(String[] args) {
        final ThreadLocal<String> localString = new ThreadLocal<String>();

        localString.set(Thread.currentThread().getName());

        System.out.println(localString.get());
        localString.set("hi");


        Thread thread1 = new Thread(){
            @Override
            public void run() {
                System.out.println(localString.get());
                localString.set(Thread.currentThread().getName());
                System.out.println(localString.get());
            }
        };
        thread1.start();

        System.out.println(localString.get());
    }


}
