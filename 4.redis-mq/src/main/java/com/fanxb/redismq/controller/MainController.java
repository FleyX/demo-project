package com.fanxb.redismq.controller;

import com.fanxb.redismq.util.RedisMqUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA
 * Created By Fxb
 * Date: 4/14/20
 * Time: 6:08 AM
 */
@RestController
public class MainController {
    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private RedisMqUtil mqUtil;

    @RequestMapping("/topic1")
    public void addOne(String message) {
        mqUtil.addToMq("topic1", message);
    }

    @RequestMapping("/topic2")
    public void addOne1(String message) {
        mqUtil.addToMq("topic2", message);
    }


}

