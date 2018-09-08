package com.example.dxfl;

import com.example.dxfl.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description
 *
 * @author fxb
 * @date 2018-09-05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceTest {

    @Autowired
    private TestService testService;

    @Test
    public void insertOne(){
        testService.insertOne();
    }

    @Test
    public void getAll(){
        testService.getAll();
    }
}
