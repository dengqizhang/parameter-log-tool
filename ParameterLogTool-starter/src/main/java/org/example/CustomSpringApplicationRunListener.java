package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;

/**
 * @describe:
 * @Author Cary
 * @Date 2024/3/22
 **/
public class CustomSpringApplicationRunListener implements SpringApplicationRunListener {
    private final SpringApplication application;

    private final String[] args;
    public CustomSpringApplicationRunListener(SpringApplication application, String[] args){
        this.application = application;
        this.args = args;
    }
    //在应用程序即将启动前调用，执行初始化操作
    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println("starting.......");
    }
    //在环境准备阶段调用，用于对应用程序的环境进行配置和修改
    @Override
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        System.out.println("environmentPrepared........");
    }
    //在上下文准备阶段调用，可用于对应用程序上下文进行一些配置或修改
    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("contextPrepared..........");
    }
    //在上下文加载阶段调用，用于对应用程序上下文进行一些额外的处理
    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("contextLoaded........");
    }
    //在应用程序启动完成后调用，执行启动后的逻辑
    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println("started...........");
    }
    //在应用程序准备就绪后调用，用于执行一些就绪后的操作
    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken){
        System.out.println("ready...........");
    }
    //在应用程序启动失败后调用，可用于处理启动失败的情况
    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("failed");
    }
}
