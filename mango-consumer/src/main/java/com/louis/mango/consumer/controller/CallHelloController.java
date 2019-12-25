package com.louis.mango.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CallHelloController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;//负载均衡器

    /**
     * 一个简单的服务调用和负载均衡
     *
     * @return
     */
    @RequestMapping("/call")
    public String call() {
        //查找服务，通过LoadBalancerClient负载均衡器查询服务
        ServiceInstance serviceInstance = loadBalancerClient.choose("mango-producer");
        System.out.println("服务地址：" + serviceInstance.getUri());
        System.out.println("服务名称：" + serviceInstance.getServiceId());

        //调用服务，使用RestTemplate进行远程调用服务
        String callServiceResult = new RestTemplate().getForObject(serviceInstance.getUri().toString() + "/hello", String.class);
        System.out.println(callServiceResult);
        return callServiceResult;
    }

}