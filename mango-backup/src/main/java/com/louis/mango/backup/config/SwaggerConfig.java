package com.louis.mango.backup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置
 * Swagger集成文档有：
 *      功能丰富：支持多种注解，自动生成文档界面，还能测试、
 *      及时更新：开发过程中写好注释就可以及时更新、
 *      整合简单：内嵌于应用中，无需独立部署
 *   等特点。
 *
 * @author Louis
 * @date Jan 11, 2019
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.any())//指定提供接口所在的基包 any()表示所有接口
                .paths(PathSelectors.any()).build();
    }

    /**
     * API说明信息(即API的包含内容)
     * @return
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().build();

        /*  //该套 API 说明，包含作者、简介、版本、host、服务URL
            return new ApiInfoBuilder()
                .title("demo api 说明")//标题
                .contact(new Contact("allen","null","name@example.com"))//作者
                .version("0.1")//版本
                .termsOfServiceUrl("localhost:8080/demo1/")//地址
                .description("demo api")//说明
                .build();*/
    }

}