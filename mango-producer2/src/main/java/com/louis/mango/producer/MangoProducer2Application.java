package com.louis.mango.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient//注册中心能够发现，扫描到改服务
@SpringBootApplication
public class MangoProducer2Application {

	public static void main(String[] args) {
		SpringApplication.run(MangoProducer2Application.class, args);
	}
}
