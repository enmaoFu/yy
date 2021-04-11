package com.yy.api.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.entity.resp.TestEntity;

public interface TestService extends IService<TestEntity> {

    TestEntity test(Integer id);

}
