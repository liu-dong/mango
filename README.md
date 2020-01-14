#### 启动过程

    1、启动服务注册中心
        打开终端，进入consul.exe所在目录，
        执行命令：consul agent -dev
    2、启动系统服务监控
        mango-monitor
    3、启动服务提供者
        mango-producer
        mango-producer2
    4、启动服务消费者
        mango-consumer
    5、启动服务网关
        mango-zuul
    6、启动服务熔断
        mango-hystrix
       
#### 访问地址
    swagger：http://localhost:8081/swagger-ui.html#/
    consul：http://localhost:8500/
