package com.example.wechatpay.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * t_pay_history
 */
@Data
@Accessors(chain = true)
public class PayHistoryPo {
    private Integer id;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 创建人
     */
    private Integer createUser;

    /**
     * 更新时间
     */
    private Long updateTime;

    /**
     * 更新人
     */
    private Integer updateUser;

    /**
     * 预支付id
     */
    private String prePayId;

    /**
     * 应用流水号
     */
    private String sn;

    /**
     * 支付金额
     */
    private BigDecimal price;

    /**
     * 描述信息
     */
    private String description;


    /**
     * 0:未支付，1：已支付
     */
    private String status;

}