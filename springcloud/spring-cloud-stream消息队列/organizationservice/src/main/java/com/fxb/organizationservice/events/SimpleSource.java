package com.fxb.organizationservice.events;

import com.fxb.organizationservice.controller.OrganizationController;
import com.fxb.organizationservice.entity.OrganizationChange;
import com.fxb.organizationservice.utils.UserContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;


/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2019/2/21 16:09
 */

@EnableBinding(Source.class)
public class SimpleSource {
    private Logger logger = LoggerFactory.getLogger(SimpleSource.class);

    private Source source;

    @Autowired
    public SimpleSource(Source source) {
        this.source = source;
    }

    public void publishOrChange(String action, String orgId) {
        logger.info("在请求：{}中，发送kafka消息：{} for Organization Id:{}", UserContextHolder.getContext().id, action, orgId);
        OrganizationChange change = new OrganizationChange(action, orgId, UserContextHolder.getContext().id);
        source.output().send(MessageBuilder.withPayload(change).build());
    }
}
