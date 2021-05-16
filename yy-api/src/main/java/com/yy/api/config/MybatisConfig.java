package com.yy.api.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mapstruct.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.yy.api.mapper")
public class MybatisConfig {

    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 解决启动找不到mapper警告
     */
    @Mapper
    public interface NoWarnMapper {
    }
}