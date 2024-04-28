package com.zgd;

/**
 * @author zgd
 */
public class ExceptionTest {

    public static void main(String[] args) {
        int i;
        try {
            System.out.println("try thread name: " + Thread.currentThread().getName());
            i = 1 / 0;
        } catch (Exception e) {
            System.out.println("exception thread name: " + Thread.currentThread().getName());
        }
    }

}
