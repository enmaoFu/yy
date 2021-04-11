package com.yy.api.controller;

import com.yy.api.service.TestService;
import com.yy.entity.req.TestBodyEntity;
import com.yy.entity.resp.TestEntity;
import com.yy.entity.resp.TestReceiveBody;
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
    private TestService testService;

    @GetMapping("/queryId")
    @ApiOperation(value = "测试接口-根据id查询", notes = "测试接口-根据id查询详细描述")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "数据id", dataType = "Integer", required = true)
    })
    public Result<TestEntity> queryId(@RequestParam() Integer id) {
        TestEntity testEntity = testService.test(id);
        return new Result().success().msg(SUCCESS_MSG).data(testEntity);
    }

    @PostMapping("/testReceiveBody")
    @ApiOperation(value = "测试接口-根据json查询", notes = "测试接口根据json查询详细描述")
    public Result<TestReceiveBody> testReceiveBody(@RequestBody TestBodyEntity testBodyEntity){
        System.out.println("=====" + testBodyEntity.getToken() + "-----" +testBodyEntity.getPager());
        TestReceiveBody testReceiveBody = new TestReceiveBody();
        testReceiveBody.setId(101);
        testReceiveBody.setBodyTitle("在那不遥远的地方");
        testReceiveBody.setBodyText("在那不遥远的地方，埋着你的梦想，散发出微小的光芒");
        return new Result().success().msg(SUCCESS_MSG).data(testReceiveBody);
    }
}
