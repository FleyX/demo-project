package com.fanxb.sjdemo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {

  private long orderId;
  private long userId;
  private Date createTime;
  private long totalPrice;

}
