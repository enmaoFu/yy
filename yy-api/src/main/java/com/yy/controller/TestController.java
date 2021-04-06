package com.yy.controller;

import com.yy.Result;
import com.yy.api.TestApi;
import com.yy.resp.TestEntity;
import com.yy.vo.TestBodyEntity;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.yy.ResultCode.SUCCESS;
import static com.yy.ResultCode.SUCCESS_MSG;

@RestController
@RequestMapping("/test")
@Api(value = "/test", tags = "测试接口首页")
public class TestController {

    @Autowired
    private TestApi testApi;

    @GetMapping("/queryId")
    @ApiOperation(value = "测试接口-根据id查询", notes = "测试接口-根据id查询详细描述")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据id", dataType = "Integer")
    })
    public Result<TestEntity> queryId(@RequestParam() Integer id) {
        return testApi.queryIdApi(id);
    }

    @PostMapping("/testReceiveBody")
    @ApiOperation(value = "测试接口-根据json查询", notes = "测试接口根据json查询详细描述")
    public Result<?> testReceiveBody(@RequestBody TestBodyEntity testBodyEntity){
        return testApi.testReceiveBodyApi(testBodyEntity);
    }
}
