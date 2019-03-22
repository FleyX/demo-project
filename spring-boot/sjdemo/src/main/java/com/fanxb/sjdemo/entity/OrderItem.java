package com.fanxb.sjdemo.entity;


import lombok.Data;

@Data
public class OrderItem {

    private long orderItemId;
    private long orderId;
    private String name;
    private long price;

}
