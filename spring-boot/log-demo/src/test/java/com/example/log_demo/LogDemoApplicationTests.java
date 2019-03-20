package com.example.log_demo;

import com.example.log_demo.log1.Log1Service;
import com.example.log_demo.log2.Log2Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogDemoApplicationTests {

    @Autowired
    private Log1Service log1Service;

    @Autowired
    private Log2Service log2Service;

    @Test
    public void log() {
        log1Service.debugLog();
        log1Service.infoLog();
        log1Service.warnLog();
        log1Service.errorLog();


        log2Service.debugLog();
        log2Service.infoLog();
        log2Service.warnLog();
        log2Service.errorLog();
    }
}
