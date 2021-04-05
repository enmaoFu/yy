package com.yy.api;

import com.yy.Result;
import com.yy.ResultCode;
import com.yy.GsonUtils;
import com.yy.entity.TestBodyEntity;
import com.yy.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TestApi implements ResultCode {

    @Autowired
    private TestService testService;

    public String queryIdApi(Integer id){
        Map<String,Integer> map = testService.test(id);
        return GsonUtils.toJson(new Result(SUCCESS, SUCCESS_MSG, map));
    }

    public String testReceiveBodyApi(TestBodyEntity testBodyEntity){
        System.out.println("=====" + testBodyEntity.getToken() + "-----" +testBodyEntity.getPager());
        return GsonUtils.toJson(new Result().success().msg(SUCCESS_MSG).data(null));
    }

}
