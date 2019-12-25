package com.louis.mango.consumer.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * fallback 服务熔断回调方法
 */
@FeignClient(name = "mango-producer", fallback = MangoProducerHystrix.class)
public interface MangoProducerService {

    @RequestMapping("/hello")
    public String hello();

}
