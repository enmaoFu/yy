package com.yy.api.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yy.entity.resp.TestResp;

public interface TestService extends IService<TestResp> {

    TestResp test(Integer id);

}
