package com.example.mybatistest.entity;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ${fxb}
 * Email: fanxb.tl@gmail.com
 * Date: 2018-07-30
 */
public class User {
    private int id;
    private String name;
    private int age;
    private String password;

    public User(int id, String name, int age, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.password = password;
    }
    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
