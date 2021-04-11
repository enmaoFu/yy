package com.yy.controller;

import com.yy.Result;
import com.yy.resp.TestEntity;
import com.yy.resp.TestReceiveBody;
import com.yy.service.TestService;
import com.yy.req.TestBodyEntity;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static com.yy.ResultCode.SUCCESS_MSG;

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
