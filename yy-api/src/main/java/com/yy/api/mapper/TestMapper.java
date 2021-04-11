package com.yy.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yy.entity.resp.TestEntity;
import org.apache.ibatis.annotations.Param;

public interface TestMapper extends BaseMapper<TestEntity> {

    TestEntity testQueryId(@Param("id") Integer id);

}
