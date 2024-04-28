package com.zgd.annotation.http;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 定义一个注解
 * 定义一个动态代理，处理注解
 * 创建接口的动态代理类
 *
 * @author zgd
 */
public class Main {

    public static void main(String[] args) {
        // 创建一个InvocationHandler对象
        InvocationHandler proxy = new HttpClientProxy();

        // 使用指定的InvocationHandler来生成一个动态代理对象
        HttpClient client = (HttpClient) Proxy.newProxyInstance(
                HttpClient.class.getClassLoader(), new Class[]{HttpClient.class}, proxy);

        // 调用动态代理对象的walk()和sayHello()方法
        client.getData();
    }
}
