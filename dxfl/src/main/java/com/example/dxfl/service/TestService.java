package com.example.dxfl.service;

import com.example.dxfl.config.ReadOnly;
import com.example.dxfl.entity.Test;
import com.example.dxfl.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description
 *
 * @author fxb
 * @date 2018-09-04
 */
@Service
public class TestService {

    private final TestMapper testMapper;

    @Autowired
    public TestService(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    /**
     * 测试读取，应该使用读库
     */
    @ReadOnly
    public List<Test> getAll() {
        return testMapper.getAll();
    }

    /**
     * 测试读取和插入,应该使用写库
     */
    public void testReadAndWrite() {
        this.getAll();
        this.insertOne();
    }

    /**
     * 测试插入数据,应该使用写库
     */
    public void insertOne() {
        Test test = new Test();
        test.setName("fxb");
        testMapper.insertOne(test);
    }

    /**
     * 测试事务能否正常工作
     */
    @Transactional(rollbackFor = RuntimeException.class)
    public void transInsert(){
        Test test = new Test();
        test.setName("heiheihei");
        testMapper.insertOne(test);
        throw new RuntimeException("测试事务");
    }
}
