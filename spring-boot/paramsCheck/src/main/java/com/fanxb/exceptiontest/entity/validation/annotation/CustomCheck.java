package com.fanxb.exceptiontest.entity.validation.annotation;

import com.fanxb.exceptiontest.entity.validation.CustomCheckValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author fanxb
 * @date 2021-10-08-23:22
 */

@Target({ElementType.FIELD}) //作用于字段
@Retention(RetentionPolicy.RUNTIME)//生命周期
@Constraint(validatedBy = CustomCheckValidator.class)//校验逻辑实现类
public @interface CustomCheck {

    String message() default "自定义校验默认错误提示";

    /**
     * 自定义参数，可传递到校验实现类CustomCheckValidator中
     */
    String param1() default "";

    Class<?>[] groups() default {}; //用于分组校验

    Class<? extends Payload>[] payload() default {};

}
