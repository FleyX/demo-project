package com.fanxb.esdemo.entity;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/7/29 11:29
 */
public final class EsEntity<T> {

    private String id;
    private T data;

    public EsEntity() {
    }

    public EsEntity(String id, T data) {
        this.data = data;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

