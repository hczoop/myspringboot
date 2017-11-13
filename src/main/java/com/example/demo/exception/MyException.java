package com.example.demo.exception;

/**
 * 自定义异常
 * Created by xing on 2017/6/19.
 */
public class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }
}
