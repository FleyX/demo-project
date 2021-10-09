package com.fanxb.exceptiontest.config;

import com.fanxb.exceptiontest.entity.Result;
import com.fanxb.exceptiontest.entity.exception.BaseException;
import com.fanxb.exceptiontest.entity.exception.CustomBusinessException;
import com.fanxb.exceptiontest.entity.exception.CustomValidException;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Objects;

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
        } else if (e instanceof ConstraintViolationException) {
            //url参数、数组类参数校验报错类
            ConstraintViolationException ce = (ConstraintViolationException) e;
            //针对参数校验异常，建立了一个异常类
            be = new CustomValidException(ce.getMessage());
        } else if (e instanceof MethodArgumentNotValidException) {
            //json对象类参数校验报错类
            MethodArgumentNotValidException ce = (MethodArgumentNotValidException) e;
            be = new CustomValidException(Objects.requireNonNull(ce.getFieldError()).getDefaultMessage());
        } else {
            //其它异常，非自动抛出的,无需给前端返回具体错误内容（用户不需要看见空指针之类的异常信息）
            log.error("other exception:{}", e.getMessage(), e);
            be = new BaseException("系统异常，请稍后重试", e);
        }
        return new Result(be.getCode(), be.getMessage(), null);
    }
}
