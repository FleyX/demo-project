package com.fanxb.exceptiontest.entity.validation;

import com.fanxb.exceptiontest.entity.validation.annotation.CustomCheck;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author fanxb
 * @date 2021-10-08 23:27
 */
public class CustomCheckValidator implements ConstraintValidator<CustomCheck, String> {
    private String param1;

    @Override
    public void initialize(CustomCheck constraintAnnotation) {
        //在此获取校验参数
        param1 = constraintAnnotation.param1();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return param1 != null && param1.equals(s);
    }
}
