package com.yy.entity.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "测试返回实体类信息2")
public class TestReceiveBodyResp {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "标题")
    private String bodyTitle;

    @ApiModelProperty(value = "内容")
    private String bodyText;

}
