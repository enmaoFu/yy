package com.yy.mapper;

import com.yy.resp.TestEntity;
import org.springframework.stereotype.Component;

@Component
public interface TestMapper {

    TestEntity testQueryId(Integer id);

}
