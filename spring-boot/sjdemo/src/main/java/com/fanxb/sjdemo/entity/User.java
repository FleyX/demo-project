package com.fanxb.sjdemo.entity;


import lombok.Data;

@Data
public class User {

    private long userId;
    private String name;
    private int age;

    public User() {
    }

    public User(long userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
    }
}
