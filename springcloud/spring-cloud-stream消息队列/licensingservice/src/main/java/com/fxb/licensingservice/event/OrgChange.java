package com.fxb.licensingservice.event;

import com.fxb.licensingservice.Entity.OrganizationChange;
import com.fxb.licensingservice.util.RedisKeyUtils;
import com.fxb.licensingservice.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/2/22 10:33
 */
@EnableBinding(Sink.class) //使用Sink接口中定义的通道来监听传入消息
public class OrgChange {

    private Logger logger = LoggerFactory.getLogger(OrgChange.class);

    @StreamListener(Sink.INPUT)
    public void loggerSink(OrganizationChange change){
        logger.info("收到一个消息，组织id为：{},关联id为：{}",change.getOrgId(),change.getId());
        RedisUtils.del(RedisKeyUtils.getOrgCacheKey(change.getOrgId()));
    }
}
