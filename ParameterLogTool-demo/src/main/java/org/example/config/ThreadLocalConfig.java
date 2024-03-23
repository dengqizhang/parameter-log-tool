package org.example.config;

import org.springframework.stereotype.Component;

/**
 * @describe:
 * @Author Cary
 * @Date 2024/3/23
 **/
@Component
public class ThreadLocalConfig {

    private static ThreadLocal<String> mapThreadLocal = new ThreadLocal<>();

    //获取当前线程存储的变量
    public String get(){
        return mapThreadLocal.get();
    }
    //设置当前线程的变量
    public void set(String ss){
        this.mapThreadLocal.set(ss);
    }

    //移除当前线程存储的变量
    public void remove(){
        this.mapThreadLocal.remove();
    }
}
