package com.yy.service.impl;

import com.yy.mapper.TestMapper;
import com.yy.resp.TestEntity;
import com.yy.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public TestEntity test(Integer id) {
        return testMapper.testQueryId(id);
    }

}
