package com.fanxb.sjdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.fanxb.sjdemo.entity.Dictionary;
import com.fanxb.sjdemo.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/26 10:17
 */
@RestController
@RequestMapping("dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @PutMapping("")
    public long addOne(@RequestBody JSONObject object) {
        Dictionary dictionary = object.toJavaObject(Dictionary.class);
        return this.dictionaryService.addOne(dictionary);
    }
}
