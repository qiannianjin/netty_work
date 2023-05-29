package com.yinghu.yinghu.common;

/**
 * @Classname Result
 * @Description TODO
 * @Date 2022/10/19 15:04
 * @Created by whz
 */


//返回结果集，以这个为标准封装
public class Result {
    //是否成功
    private boolean flag;
    //返回的状态码
    private Integer code;
    //返回信息
    private String message;
    //返回数据
    private Object data;

    //全参构造方法
    public Result(boolean flag, Integer code, String message, Object data) {
        //super();
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    //无参构造方法
    public Result() {
    }

    //没有返回数据的方法
    public Result(boolean flag, Integer code, String message) {
        super();
        this.flag = flag;
        this.code = code;
        this.message = message;
    }



    // 通用的成功  无返回结果
    public static Result success() {
        return new Result(true, StatusCode.OK.getCode(), "OK", null);
    }

    // 通用的成功  有返回结果
    public static Result success(Object data) {
        return new Result(true, StatusCode.OK.getCode(), "OK", data);
    }
    public static Result success(String message,Integer code,Object data) {
        return new Result(true, code, message, data);
    }

    // 通用的失败创建接口  没有返回结果
    public static Result fail(int statusCode, String message) {
        return new Result(false, statusCode, message, null);
    }

    // 通用的失败创建接口  有返回结果
    public static Result fail(int statusCode, String message, Object data) {
        return new Result(false, statusCode, message, data);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}




