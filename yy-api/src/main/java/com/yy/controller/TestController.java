package com.yy.controller;

import com.yy.api.TestApi;
import com.yy.entity.TestBodyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestApi testApi;

    @GetMapping("/queryId")
    public String queryId(int id) {
        return testApi.queryIdApi(id);
    }

    @PostMapping("/testReceiveBody")
    public String testReceiveBody(@RequestBody TestBodyEntity testBodyEntity){
        return testApi.testReceiveBodyApi(testBodyEntity);
    }
}
