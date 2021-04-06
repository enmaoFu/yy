package com.yy.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "测试返回实体类信息")
public class TestEntity {

    @ApiModelProperty(value = "测试返回实体类ID")
    private int id;
}
