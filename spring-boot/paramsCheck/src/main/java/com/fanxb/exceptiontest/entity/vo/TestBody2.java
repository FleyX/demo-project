package com.fanxb.exceptiontest.entity.vo;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author fanxb
 * @date 2021-09-28-下午4:29
 */
@Data
public class TestBody2 {
    @NotBlank
    @Email(message = "请输入一个邮箱")
    private String param1;
    @NotNull
    private String param2;
    @NotNull
    @Valid
    private TestBody testBody;
}
