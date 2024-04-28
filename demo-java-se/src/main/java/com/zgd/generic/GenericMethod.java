package com.zgd.generic;

/**
 * 泛型方法演示
 *
 * @author zgd
 */
public class GenericMethod<E> {
    /**
     * 注意：泛型方法的泛型和类上的泛型是独立的，互不影响的
     */
    public <T> void printFruit(T t) {
        System.out.println(t);
    }
}
