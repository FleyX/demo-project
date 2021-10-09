package com.fanxb.exceptiontest.entity.vo;

import com.fanxb.exceptiontest.entity.validation.annotation.CustomCheck;
import lombok.Data;

import javax.validation.Valid;
import java.util.List;

/**
 * @author fanxb
 * @date 2021-09-28-下午4:29
 */
@Data
public class TestBody5 {
    @Valid
    private List<TestBody4> list;
}
