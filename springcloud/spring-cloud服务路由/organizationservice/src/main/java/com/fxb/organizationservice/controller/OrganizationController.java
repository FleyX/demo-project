package com.fxb.organizationservice.controller;

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

    private static int count=1;

    @GetMapping(value = "/organization/{orgId}")
    public Object getOrganizationInfo(@PathVariable("orgId") String orgId) throws Exception{
//        if(count%2==0){
//            TimeUnit.SECONDS.sleep(2);
//        }
//        count++;
        Map<String, String> data = new HashMap<>(2);
        data.put("id", orgId);
        data.put("name", orgId + "公司");
        return data;
    }
}
