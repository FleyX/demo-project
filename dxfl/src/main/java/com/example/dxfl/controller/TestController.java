package com.example.dxfl.controller;

import com.example.dxfl.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 *
 * @author fxb
 * @date 2018-09-04
 */
@RestController
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/getAll")
    public Object getAll(){
        return testService.getAll();
    }

    @GetMapping("insertOne")
    public void insertOne(){
        testService.insertOne();
    }

    @GetMapping("readAndWrite")
    public void readAndWrite(){
        testService.testReadAndWrite();
    }

    @GetMapping("transInsert")
    public void transInsert(){
        testService.transInsert();
    }

}
