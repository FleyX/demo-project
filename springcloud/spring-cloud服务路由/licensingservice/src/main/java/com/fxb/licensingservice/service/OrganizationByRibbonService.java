package com.fxb.licensingservice.service;

import com.fxb.licensingservice.Entity.Organization;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2018/11/23 15:36
 */
@Component
public class OrganizationByRibbonService {

    private RestTemplate restTemplate;


    @Autowired
    public OrganizationByRibbonService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    }, fallbackMethod = "getOrganizationWithRibbonBackup",
            threadPoolKey = "licenseByOrgThreadPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "30"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            })
    public Organization getOrganizationWithRibbon(String id) throws Exception {
        ResponseEntity<Organization> responseEntity = restTemplate.exchange("http://organizationservice/organization/{id}",
                HttpMethod.GET, null, Organization.class, id);
        return responseEntity.getBody();
    }

    public Organization getOrganizationWithRibbonBackup(String id) throws Exception {
        Organization organization = new Organization();
        organization.setId("0");
        organization.setName("组织服务调用失败");
        return organization;
    }
}
