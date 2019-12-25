package com.louis.mango.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MangoConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MangoConsumerApplication.class, args);
    }

    /**
     * 为了使用Ribbon来进行负载均衡，注入RestTemplate，并添加@LoadBalanced注解（用于拦截请求）
     *
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
