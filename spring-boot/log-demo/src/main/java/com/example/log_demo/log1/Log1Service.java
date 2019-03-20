package com.example.log_demo.log1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/3/20 14:05
 */
@Service
public class Log1Service {

    private static Logger logger = LoggerFactory.getLogger(Log1Service.class);

    public void errorLog(){
        logger.error("这是一条测试错误日志");
    }


    public void warnLog(){
        logger.warn("这是一条测试警告日志");
    }

    public void infoLog(){
        logger.info("这是一条测试info日志");
    }


    public void debugLog(){
        logger.debug("这是一条测试debug日志");
    }

}
