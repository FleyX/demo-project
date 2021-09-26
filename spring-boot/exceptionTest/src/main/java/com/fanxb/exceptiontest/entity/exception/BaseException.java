package com.fanxb.exceptiontest.entity.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * @author fanxb
 * @date 2021-09-24-下午5:13
 */
@Getter
public class BaseException extends RuntimeException {
    private static final long serialVersionUID = -3149747381632839680L;
    /**
     * 基本错误code为0
     */
    private static final int BASE_CODE = 0;
    private final int code;
    private final String message;

    public BaseException() {
        this(null, null, null);
    }

    public BaseException(String message) {
        this(message, null, null);
    }

    public BaseException(Exception e) {
        this(null, null, e);
    }

    public BaseException(String message, Exception e) {
        this(message, null, e);
    }

    protected BaseException(String message, Integer code, Exception e) {
        super(e);
        this.message = message == null ? "" : message;
        this.code = code == null ? BASE_CODE : code;
    }

    @Override
    public String getMessage() {
        if (this.message != null && this.message.length() > 0) {
            return this.message;
        }
        return super.getMessage();
    }
}
