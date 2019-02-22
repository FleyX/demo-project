package com.fxb.organizationservice.controller;

import com.fxb.organizationservice.events.SimpleSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2018/11/22 18:23
 */
@RestController
public class OrganizationController {

    @Autowired
    private SimpleSource simpleSource;

    private Logger logger = LoggerFactory.getLogger(OrganizationController.class);

    @GetMapping(value = "/organization/{orgId}")
    public Object getOrganizationInfo(@PathVariable("orgId") String orgId) throws Exception {
        Map<String, String> data = new HashMap<>(2);
        data.put("id", orgId);
        data.put("name", orgId + "公司");
        return data;
    }

    @DeleteMapping(value = "/organization/{orgId}")
    public void deleteOne(@PathVariable("orgId") String id) {
        logger.debug("删除了组织：{}", id);
        simpleSource.publishOrChange("delete", id);
    }
}
