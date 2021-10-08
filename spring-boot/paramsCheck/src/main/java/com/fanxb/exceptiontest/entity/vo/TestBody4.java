package com.fanxb.exceptiontest.entity.vo;

import com.fanxb.exceptiontest.entity.consistant.Insert;
import com.fanxb.exceptiontest.entity.consistant.Update;
import com.fanxb.exceptiontest.entity.validation.annotation.CustomCheck;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author fanxb
 * @date 2021-09-28-下午4:29
 */
@Data
public class TestBody4 {
    @CustomCheck(message = "此参数固定为fff", param1 = "fff")
    private String param1;
    @CustomCheck(message = "此参数固定为ggg", param1 = "ggg")
    private String param2;
}
