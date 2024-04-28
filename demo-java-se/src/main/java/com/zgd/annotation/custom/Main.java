package com.zgd.annotation.custom;

import java.lang.reflect.Method;

/**
 * @author zgd
 */
public class Main {
    public static void main(String[] args) {
        MyClass myObject = new MyClass();
        Class<?> clazz = myObject.getClass();

        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(CustomAnnotation.class)) {
                CustomAnnotation annotation = method.getAnnotation(CustomAnnotation.class);
                String value = annotation.value();
                System.out.println("Annotation value: " + value);
                // 可以在这里处理注解生效的逻辑
            }
        }
    }
}