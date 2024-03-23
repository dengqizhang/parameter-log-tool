package org.example.service;

import org.example.config.ThreadLocalConfig;
import org.example.controller.ToolDemoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * @describe: 使用反射获取方法参数
 * @Author Cary
 * @Date 2024/3/23
 **/
@Service
public class ToolDemoService {
    @Autowired
    ThreadLocalConfig threadLocalConfig;

    public void processMethodParameters(Class<? extends ToolDemoController> aClass, String methodName, Object... args) {
        try{
            //获取方法对象
            Method method = aClass.getMethod(methodName,String.class);
            //获取方法的参数列表
            Class<?>[] parameterTypes = method.getParameterTypes();

            //打印参数信息
            for (int i = 0;i < parameterTypes.length; i++){
                Class<?> parameterType = parameterTypes[i];
                Object arg = args[i];
                System.out.println("参数类型：" + parameterType.getName());
                System.out.println("参数值：" + arg);
            }

            String ss = threadLocalConfig.get();
            System.out.println("获取到上下文传递的变量: " + ss);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
