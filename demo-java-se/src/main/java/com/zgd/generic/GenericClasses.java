package com.zgd.generic;

/**
 * 泛型类
 *
 * @author zgd
 */
public class GenericClasses<T> {
    private T t;

    public T getT() {
        return this.t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "GenericClasses{" +
                "t=" + t +
                '}';
    }
}
