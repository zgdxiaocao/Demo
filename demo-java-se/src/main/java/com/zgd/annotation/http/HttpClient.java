package com.zgd.annotation.http;

/**
 * 通过注解的方式发送请求
 *
 * @author zgd
 */
public interface HttpClient {
    /**
     * 获取注释
     */
    @HttpSend(url = "https://example.com/api/data", method = "POST", contentType = "application/x-www-form-urlencoded")
    public void getData();
}