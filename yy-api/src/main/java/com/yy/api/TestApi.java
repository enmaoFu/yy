package com.yy.api;

import com.yy.Result;
import com.yy.ResultCode;
import com.yy.resp.TestEntity;
import com.yy.service.TestService;
import com.yy.vo.TestBodyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TestApi implements ResultCode {

    @Autowired
    private TestService testService;

    public Result<TestEntity> queryIdApi(Integer id){
        Map<String, Object> map = testService.test(id);
        return new Result().success().msg(SUCCESS_MSG).data(map);
    }

    public Result<?> testReceiveBodyApi(TestBodyEntity testBodyEntity){
        System.out.println("=====" + testBodyEntity.getToken() + "-----" +testBodyEntity.getPager());
        return new Result().success().msg(SUCCESS_MSG).data(null);
    }

}
