package com.yy.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "测试body实体")
public class TestBodyEntity {
    @ApiModelProperty(value = "token")
    private String token;
    @ApiModelProperty(value = "页码")
    private int pager;
}
