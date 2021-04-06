package com.yy.service.impl;

import com.yy.mapper.TestMapper;
import com.yy.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TestImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public Map<String, Object> test(Integer id) {
        return testMapper.testQueryId(id);
    }

}
