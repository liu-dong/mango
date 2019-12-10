package com.louis.mango;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//(scanBasePackages={"com.louis.mango"}) 不加也没关系，springboot会默认扫描启动类的当前包及子包
@SpringBootApplication(scanBasePackages={"com.louis.mango"})
public class MangoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MangoApplication.class, args);
	}

}

