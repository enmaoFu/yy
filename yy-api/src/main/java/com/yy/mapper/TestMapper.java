package com.yy.mapper;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface TestMapper {

    Map<String,Integer> testQueryId(Integer id);

}
