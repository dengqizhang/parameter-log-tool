## 通过此工具深入浅出springboot

### springboot的run()执行时经历了哪些流程？
1，创建SpringApplication对象，该对象是Springboot应用程序的主要入口点。     
执行SpringApplication的构造方法：
```
public SpringApplication(ResourceLoader resourceLoader, Class<?>... primarySources) {
    // 应用程序需要一个资源加载器，来加载外部的文件。
    this.resourceLoader = resourceLoader;
    Assert.notNull(primarySources, "PrimarySources must not be null");
    // 给应用程序设定主配置类。
    this.primarySources = new LinkedHashSet<>(Arrays.asList(primarySources));
    // 根据关键字获取当前 SpringApplication 的类型，结果是：SERVLET。
    this.webApplicationType = WebApplicationType.deduceFromClasspath();
    // 设置引导启动器。
    this.bootstrappers = new ArrayList<>(getSpringFactoriesInstances(Bootstrapper.class));
    // 设置初始化器。
    setInitializers((Collection) getSpringFactoriesInstances(ApplicationContextInitializer.class));
    // 设置监听器。
    setListeners((Collection) getSpringFactoriesInstances(ApplicationListener.class));
    // 设置主类。
    this.mainApplicationClass = deduceMainApplicationClass();
}
```

2，进入run()方法，创建应用监听器SpringApplicationRunListeners开始监听        
3, 然后加载SpringBoot配置环境(ConfigurableEnvironment)     
4, 然后把配置环境(Environment)加入监听对象中     
5, 然后加载应用上下文(ConfigurableApplicationContext)，当做run方法的返回对象    
6, 最后创建Spring容器，refreshContext(context)，实现starter自动化配置和bean的实例化等工作。   

### IOC是什么？
IOC（控制反转）

IOC的启动是由ApplicationContext接口的refresh()方法来实现的，这个方法会触发IOC容器的初始化过程。
- 执行流程：   
1，加载配置信息    
IOC容器会读取配置信息(如xml配置文件)或其他配置源，解析其中的Bean定义和其他相关配置信息。    
2，创建并注册BeanDefinition     
IOC 容器会将解析到的 Bean 定义信息转化为内部的数据结构，即 BeanDefinition 对象。BeanDefinition 描述了 Bean 的各种属性和依赖关系。   
3，实例化Bean     
根据 BeanDefinition 中的信息，IOC 容器会实例化 Bean 对象。这涉及到类的加载、实例化和依赖注入等过程。   
4，依赖注入和属性填充     
IOC 容器会解析 Bean 之间的依赖关系，并将相应的依赖注入到 Bean 中。这可以通过构造函数注入、Setter 方法注入或字段注入等方式实现。      
5，初始化Bean     
IOC 容器会调用 Bean 的初始化方法（如在 Bean 上标注的 @PostConstruct 方法），执行一些初始化逻辑和配置。    
6，注册Bean    
已经实例化和初始化的 Bean 将被注册到 IOC 容器中，以供其他 Bean 或组件使用。    
7，完成启动     
当所有的Bean都被创建，初始化并注册到IOC容器中，IOC容器启动完成。

### BeanDefinition对象是什么？
用于描述和定义一个Bean的属性，行为，依赖关系。它在SpringIOC容器中用于存储和管理Bean配置信息的数据结构。

每个被Spring管理的Bean都对应一个BeanDefinition对象


### 什么是AOP？
AOP(面向切面编程)，将例如日志记录等功能抽离出来，将其模块化，它定义了在特定的连接点，例如方法执行前,执行后，抛出异常后等。

通过自定义注解@interface，并定义切面类实现规则，完成切面逻辑，或通过动态代理在运行时织入切面。


### 什么是动态代理？

动态代理是一种在运行时动态生成代理对象的机制，它允许在不修改原始类的情况下，通过代理对象来控制原始对象的访问和行为。

在Java中，动态代理可以通过一下两种方式实现。
- 1，基于接口的动态代理    
基于接口的动态代理使用 Java 标准库中的 java.lang.reflect.Proxy 类和相关接口来生成代理对象。代理对象实现了指定接口，并将方法调用委托给一个实现了 InvocationHandler 接口的对象。在 InvocationHandler 的实现中，可以通过反射机制拦截方法调用并添加额外的逻辑。
- 2，基于类的动态代理    
基于类的动态代理使用第三方库（如 CGLIB、ByteBuddy 等）来生成代理对象。与基于接口的动态代理不同，基于类的动态代理可以代理不实现任何接口的类。它通过继承目标类，并重写其中的方法来实现代理逻辑。

### 什么是反射？
反射是指在运行时动态地获取、检查和操作类的信息的机制。它允许程序在运行时获取类的元数据（如类名、字段、方法、构造函数等），并在运行时操作对象、调用方法和访问属性，而无需提前在编译时知道这些信息。

例如在切面类里的获取对应方法等
```
 //拦截匹配切入点的方法,覆盖原始方法的执行
    @Around("testAspect()")
    public String ruleFUNC (ProceedingJoinPoint joinPoint) throws Throwable {
        //将方法的入参和出参打印到日志
        log.info("获取到方法入参参数={},出参参数={}", Arrays.asList(joinPoint.getArgs()),joinPoint.proceed());
        return (String) joinPoint.proceed(); //返回原始方法的返回值
    }
```

### 怎么利用springboot做变量的上下文变量传递
可以使用ThreadLocal，用来存当前线程的局部变量，拿完数据后清理数据。

### 什么是自动配置?




