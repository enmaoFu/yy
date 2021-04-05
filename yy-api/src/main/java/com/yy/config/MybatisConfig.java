package com.yy.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.yy.mapper")
public class MybatisConfig {

    @Mapper
    public interface NoWarnMapper {
    }
}