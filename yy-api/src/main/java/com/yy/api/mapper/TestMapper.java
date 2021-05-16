package com.yy.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yy.entity.resp.TestResp;
import org.apache.ibatis.annotations.Param;

public interface TestMapper extends BaseMapper<TestResp> {

    TestResp testQueryId(@Param("id") Integer id);

}
