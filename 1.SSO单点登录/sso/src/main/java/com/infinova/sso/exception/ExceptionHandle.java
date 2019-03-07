package com.infinova.sso.exception;

import com.infinova.sso.entity.ReturnEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/5 11:10
 */
@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(Exception.class)
    public ReturnEntity handleException(Exception e) {
        e.printStackTrace();
        if (e instanceof CustomException) {
            return ReturnEntity.failedResult(e.getMessage());
        } else {
            return ReturnEntity.failedResult("未知错误：" + e.getMessage());
        }
    }
}
