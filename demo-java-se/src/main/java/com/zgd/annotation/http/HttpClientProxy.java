package com.zgd.annotation.http;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zgd
 */
public class HttpClientProxy implements InvocationHandler {

    /**
     *
     * @param proxy the proxy instance that the method was invoked on
     *
     * @param method the {@code Method} instance corresponding to
     * the interface method invoked on the proxy instance.  The declaring
     * class of the {@code Method} object will be the interface that
     * the method was declared in, which may be a superinterface of the
     * proxy interface that the proxy class inherits the method through.
     *
     * @param args an array of objects containing the values of the
     * arguments passed in the method invocation on the proxy instance,
     * or {@code null} if interface method takes no arguments.
     * Arguments of primitive types are wrapped in instances of the
     * appropriate primitive wrapper class, such as
     * {@code java.lang.Integer} or {@code java.lang.Boolean}.
     *
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 根据注解的信息发送http请求

        if (method.isAnnotationPresent(HttpSend.class)) {
            HttpSend annotation = method.getAnnotation(HttpSend.class);
            String url = annotation.url();
            String httpMethod = annotation.method();
            String contentType = annotation.contentType();

            // 在这里使用注解的属性来发送Http请求
            System.out.println("Sending HTTP request to " + url + " using " + httpMethod + " method with content type " + contentType);
        }

        // 如果函数有执行体的话
        return method.invoke(args);
    }

}