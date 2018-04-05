该项目是基于springboot和springcloud的微服务架构模版

个人见解：
1.Eureka：服务注册中心
2.RestTemplate：通过注册中心，消费者可以使用http协议调用提供者返回的数据
3.Ribbon：消费端拉取提供端数据的负载均衡器（位于消费端的负载均衡器），与RestTemplate配合使用使其负载均衡的拉取提供端的数据，内部有多种负载均衡算法也可以自定义
4.Feign：相当于HttpClient，通过http协议获取其他微服务数据
5.hystrix:充当RestTemplate、feign、zuul等的断路器（直接返回防止多线程导致集群雪崩）
6.zuul:服务器的反向代理（用户访问zuul服务器，zuul服务器用http协议请求其他服务器响应结果）
7.sidecar：用于代理其他语言编写的服务和zuul类似

spring-boot-maven-plugin插件：
1.可以打包和运行springboot容器
2.运行容器maven goals是spring-boot:run