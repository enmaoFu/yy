package com.yy.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yy.api.mapper.TestMapper;
import com.yy.api.service.TestService;
import com.yy.entity.resp.TestResp;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, TestResp> implements TestService {

    @Override
    public TestResp test(Integer id) {
        return baseMapper.testQueryId(id);
    }

}
