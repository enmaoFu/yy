package com.yy.api.api;

import com.yy.api.service.TestService;
import com.yy.entity.req.TestBodyReq;
import com.yy.entity.resp.TestReceiveBodyResp;
import com.yy.entity.resp.TestResp;
import com.yy.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.yy.util.result.ResultCode.SUCCESS_MSG;

@Component
public class TestApi {

    @Autowired
    private TestService testService;

    public Result<TestResp> queryIdApi(Integer id){
        TestResp testResp = testService.test(id);
        return new Result().success().msg(SUCCESS_MSG).data(testResp);
    }

    public Result<TestReceiveBodyResp> testReceiveBodyApi(TestBodyReq testBodyReq){
        System.out.println("=====" + testBodyReq.getToken() + "-----" + testBodyReq.getPager());
        TestReceiveBodyResp testReceiveBodyResp = new TestReceiveBodyResp();
        testReceiveBodyResp.setId(101);
        testReceiveBodyResp.setBodyTitle("在那不遥远的地方");
        testReceiveBodyResp.setBodyText("在那不遥远的地方，埋着你的梦想，散发出微小的光芒");
        return new Result().success().msg(SUCCESS_MSG).data(testReceiveBodyResp);
    }

}
