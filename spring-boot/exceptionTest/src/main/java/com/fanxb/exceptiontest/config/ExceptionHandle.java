package com.fanxb.exceptiontest.config;

import com.fanxb.exceptiontest.entity.Result;
import com.fanxb.exceptiontest.entity.exception.BaseException;
import com.fanxb.exceptiontest.entity.exception.CustomBusinessException;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author fanxb
 * @date 2021-09-24-下午4:37
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHandle {
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        BaseException be;
        if (e instanceof BaseException) {
            be = (BaseException) e;
            //手动抛出的异常，仅记录message
            log.info("baseException:{}", be.getMessage());
            if (be instanceof CustomBusinessException) {
                //可在这里进行一些针对特定异常的处理逻辑
                log.info("customBusinessException:{}", be.getMessage());
            }
        } else {
            //其它异常，非自动抛出的,无需给前端返回具体错误内容（用户不需要看见空指针之类的异常信息）
            log.error("other exception:{}", e.getMessage(), e);
            be = new BaseException("系统异常，请稍后重试", e);
        }
        return new Result(be.getCode(), be.getMessage(), null);
    }
}
