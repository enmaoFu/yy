package com.yy.api.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * 原生UI风格路径：http://localhost:9099/swagger-ui.html
     * knife4j UI风格路径：http://localhost:9099/doc.html#/home
     */

    /**
     * 创建API
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 是否启用Swagger
                .enable(true)
                .pathMapping("")
                // 用来创建该API的基本信息，展示在文档的页面中（自定义展示的信息）
                .apiInfo(apiInfoInit())
                // 设置哪些接口暴露给Swagger展示
                .select()
                // 扫描所有有注解的api，用这种方式更灵活
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 扫描指定包中的swagger注解
                // .apis(RequestHandlerSelectors.basePackage("com.faresn.admin"))
                // 扫描所有.apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                // 设置安全模式，swagger可以设置访问token
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    /**
     * api信息初始化，用ApiInfoBuilder进行定制
     */
    private ApiInfo apiInfoInit() {
        return new ApiInfoBuilder()
                // 设置标题
                .title("标题：测试接口文档")
                // 描述
                .description("描述：测试接口文档描述")
                // 作者信息
                .contact(new Contact("enmaoFu", "www.fu.com", "980740792@qq.com"))
                // 版本
                .version("版本号:V1.0.0")
                .build();
    }

    /**
     * 安全模式，这里指定token通过Authorization头请求头传递
     */
    private List<ApiKey> securitySchemes() {
        List<ApiKey> apiKeyList = new ArrayList<>();
        apiKeyList.add(new ApiKey("Authorization", "Authorization", "header"));
        return apiKeyList;
    }

    /**
     * 安全上下文
     */
    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(
                SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))
                        .build());
        return securityContexts;
    }

    /**
     * 默认的安全上引用
     */
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }
}


