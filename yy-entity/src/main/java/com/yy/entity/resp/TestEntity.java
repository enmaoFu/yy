package com.yy.entity.resp;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@TableName("test")
@Data
@ApiModel(value = "测试返回实体类信息1")
public class TestEntity extends Model<TestEntity> {

    @ApiModelProperty(value = "测试返回实体类ID")
    private Integer id;
}
