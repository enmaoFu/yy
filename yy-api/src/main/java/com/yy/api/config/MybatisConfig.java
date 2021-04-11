package com.yy.api.config;

import org.mapstruct.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.yy.api.mapper")
public class MybatisConfig {

    /**
     * 解决启动找不到mapper警告
     */
    @Mapper
    public interface NoWarnMapper {
    }
}