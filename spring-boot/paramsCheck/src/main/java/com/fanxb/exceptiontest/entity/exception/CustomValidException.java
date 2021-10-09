package com.fanxb.exceptiontest.entity.exception;

/**
 * @author fanxb
 * @date 2021-10-09-下午4:06
 */
public class CustomValidException extends BaseException {
    private static final long serialVersionUID = -5540634625578625266L;

    /**
     * 自定义业务异常错误码
     */
    private static final int ERROR_CODE = -2;

    public CustomValidException(String message) {
        super(message, ERROR_CODE, null);
    }
}
