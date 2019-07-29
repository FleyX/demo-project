package com.fanxb.esdemo.entity;

/**
 * 类功能简述： 插入es的数据
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/7/29 11:33
 */
public class Book {
    private Integer id;
    private Integer userId;
    private String name;

    public Book() {
    }

    public Book(Integer id, Integer userId, String name) {
        this.id = id;
        this.userId = userId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
