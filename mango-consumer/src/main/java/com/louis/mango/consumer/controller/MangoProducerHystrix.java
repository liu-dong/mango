package com.louis.mango.consumer.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 服务器熔断
 */
@Component
public class MangoProducerHystrix implements MangoProducerService {

    @RequestMapping("/hello")
    public String hello() {
        return "sorry, hello service call failed.";
    }
}
