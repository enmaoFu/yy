package com.yy.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "测试返回实体类信息1")
public class TestEntity implements Serializable {

    @ApiModelProperty(value = "测试返回实体类ID")
    private Integer id;
}
