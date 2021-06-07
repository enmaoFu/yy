package com.yy.api.controller;

import com.yy.api.api.TestApi;
import com.yy.api.service.TestService;
import com.yy.entity.req.TestBodyReq;
import com.yy.entity.resp.TestResp;
import com.yy.entity.resp.TestReceiveBodyResp;
import com.yy.util.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.yy.util.result.ResultCode.SUCCESS_MSG;


@RestController
@RequestMapping("/test")
@Api(value = "/test", tags = "测试接口首页")
public class TestController {

    @Autowired
    private TestApi testApi;

    @GetMapping("/queryId")
    @ApiOperation(value = "测试接口-根据id查询", notes = "测试接口-根据id查询详细描述")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据id", dataType = "Integer", required = true)
    })
    public Result<TestResp> queryId(@RequestParam() Integer id) {
        return testApi.queryIdApi(id);
    }

    @PostMapping("/testReceiveBody")
    @ApiOperation(value = "测试接口-根据json查询", notes = "测试接口根据json查询详细描述")
    public Result<TestReceiveBodyResp> testReceiveBody(@RequestBody TestBodyReq testBodyReq){
        return testApi.testReceiveBodyApi(testBodyReq);
    }
}
