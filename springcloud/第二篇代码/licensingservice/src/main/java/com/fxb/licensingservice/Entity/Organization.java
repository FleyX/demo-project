package com.fxb.licensingservice.Entity;

import java.io.Serializable;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2018/11/22 19:30
 */
public class Organization implements Serializable {

    private String id;
    private String name;

    public Organization() {
    }

    public Organization(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
