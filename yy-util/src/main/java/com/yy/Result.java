package com.yy;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import static com.yy.ResultCode.FAILURE;
import static com.yy.ResultCode.SUCCESS;

@ApiModel(value = "返回说明")
public class Result<T> {

    @ApiModelProperty(value = "状态码：200:成功，201:失败")
    private int code;

    @ApiModelProperty(value = "描述信息")
    private String msg;

    @ApiModelProperty(value = "返回数据")
    private T data;

    public Result() {
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public Result<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Result<T> success() {
        this.code = SUCCESS;
        return this;
    }

    public Result<T> fail() {
        this.code = FAILURE;
        return this;
    }

    public Result<T> msg(String msg) {
        this.msg = msg;
        return this;
    }

    public Result<T> data(T data) {
        this.data = data;
        return this;
    }


}
