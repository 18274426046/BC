package com.medicine.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -2804195259517755050L;

    public static final int SUCCESS_CODE = 0;

    public static final String ERROR_MSG = "fail";

    private int code; // 状态码

    private String message; // 说明信息

    private String result; // result结果，快速判断

    private T data; // 结果数据


    public Result() {
        this(SUCCESS_CODE, "成功", "success", null);
    }

    public Result(int code, String msg) {
        this(code, msg, ERROR_MSG, null);
    }

    public Result(T data) {
        this(SUCCESS_CODE, "成功", "success", data);
    }

    public Result(int code, String message, String result, T data) {
        this.code = code;
        this.message = message;
        this.result = result;
        this.data = data;
    }
}
