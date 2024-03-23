package org.example.starter;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @describe: 切面类
 * @Author Cary
 * @Date 2024/3/19
 **/
@Aspect  //表示该类用于定义切面逻辑
public class ToolAspect {
    //初始化日志对象
    private static final Logger log =  LoggerFactory.getLogger(ToolAspect.class);


    @Pointcut("@annotation(org.example.annotation.LogTool)")
    public void testAspect(){

    }

    //拦截匹配切入点的方法,覆盖原始方法的执行
    @Around("testAspect()")
    public String ruleFUNC (ProceedingJoinPoint joinPoint) throws Throwable {
        //将方法的入参和出参打印到日志
        log.info("获取到方法入参参数={},出参参数={}", Arrays.asList(joinPoint.getArgs()),joinPoint.proceed());
        return (String) joinPoint.proceed(); //返回原始方法的返回值
    }

}
