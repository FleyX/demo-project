package com.fanxb.exceptiontest.entity.exception;

/**
 * @author fanxb
 * @date 2021-09-26-上午10:41
 */
public class CustomBusinessException extends BaseException {
    private static final long serialVersionUID = 1564935267302330109L;

    /**
     * 自定义业务异常错误码
     */
    private static final int ERROR_CODE = -1;

    public CustomBusinessException() {
        super("自定义义务异常", ERROR_CODE, null);
    }

    public CustomBusinessException(String message, Exception e) {
        super(message, ERROR_CODE, e);
    }
}
