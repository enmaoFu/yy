package com.yy.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.api.mapper.TestMapper;
import com.yy.api.service.TestService;
import com.yy.entity.resp.TestEntity;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, TestEntity> implements TestService {

    @Override
    public TestEntity test(Integer id) {
        return baseMapper.testQueryId(id);
    }

}
