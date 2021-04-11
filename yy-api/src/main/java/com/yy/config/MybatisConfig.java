package com.yy.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.yy.mapper")
public class MybatisConfig {

    /**
     * 解决启动找不到mapper警告
     */
    @Mapper
    public interface NoWarnMapper {
    }
}