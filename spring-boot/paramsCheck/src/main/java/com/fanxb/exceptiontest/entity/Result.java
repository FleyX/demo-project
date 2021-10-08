package com.fanxb.exceptiontest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author fanxb
 * @date 2021-09-24-下午4:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {
    private static final long serialVersionUID = 451834802206432869L;
    /**
     * 1：成功,其他失败,具体数值在自定义的异常类中
     */
    @NotNull
    @Email
    @Range
    private int code;
    /**
     * message提示内容，当接口异常时提示异常信息
     */
    private String message;
    /**
     * 携带真正需要返回的数据
     */
    private Object data;

    public static Result success(Object obj) {
        return new Result(1, null, obj);
    }
}
