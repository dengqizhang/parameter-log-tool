# ParameterLogTool
## 项目简介
该项目的目的用于使用AOP实现请求到达服务端时，记录入参，结束时记录出参，并将日志信息存入父工程的指定日志文件下。
用户只需通过配置，使用注解，引入依赖，即可完成记录日志功能。

## 特性
- 在指定的切点处拦截方法调用
- 记录方法的输入参数和返回值
- 支持自定义日志格式和输出方式
- 集成了日志框架slf4j

## 安装和配置
- 安装依赖
Springboot 3.2.3
JDK  17
maven 3.9.2

## 使用示例
将demo更换为自己的项目模块后，引入依赖
```
  <dependency>
            <groupId>org.example</groupId>
            <artifactId>ParameterLogTool-starter</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>

```
并配置starter模块的application.yml文件日志存储路径

```
logging:
  pattern:
    console: '%d{yyyy-MM-dd HH:mm:ss} %-5level [%thread] %logger{15} : %msg%n'
  file:
    name: console.log
    path: D:\个人项目\技术栈\springboot\ParameterLogTool/
  level:
    root: info
    sql: info
    web: info
```

然后在自己的项目模块下的controller方法加入@LogTool注解即可。

## 高级配置

## 致谢
https://github.com/RadianceL
https://github.com/RadianceL/olympus-gemini

