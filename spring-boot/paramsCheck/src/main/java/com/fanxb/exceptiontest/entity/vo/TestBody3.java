package com.fanxb.exceptiontest.entity.vo;

import com.fanxb.exceptiontest.entity.consistant.Insert;
import com.fanxb.exceptiontest.entity.consistant.Update;
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
public class TestBody3 {
    @NotBlank(groups = {Insert.class})
    private String param1;
    @NotBlank(groups = {Update.class})
    private String param2;
}
