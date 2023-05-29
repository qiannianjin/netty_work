package com.yinghu.yinghu.common;

import lombok.Getter;

/**
 * @Classname StatusCode
 * @Description TODO
 * @Date 2022/10/19 15:06
 * @Created by whz
 */
@Getter
public enum StatusCode {

    //定义一组常量，建议使用枚举类
    OK(200,"成功"),
    Error(0,"失败"),
    LOGINERROR(500,"登录失败");
    //private Integer code ;

    private Integer code;
    private String desc;

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
    StatusCode(Integer code, String desc){
        this.code = code;
        this.desc = desc;
    }



}
