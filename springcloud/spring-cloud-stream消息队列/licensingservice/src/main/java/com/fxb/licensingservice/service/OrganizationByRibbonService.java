package com.fxb.licensingservice.service;

import com.fxb.licensingservice.Entity.Organization;
import com.fxb.licensingservice.util.RedisKeyUtils;
import com.fxb.licensingservice.util.RedisUtils;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public OrganizationByRibbonService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    }, fallbackMethod = "getOrganizationWithRibbonBackup",
            threadPoolKey = "licenseByOrgThreadPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "30"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            })
    public Organization getOrganizationWithRibbon(String id) {
        String key = RedisKeyUtils.getOrgCacheKey(id);
        //先从redis缓存取数据
        Object res = RedisUtils.get(key);
        if (res == null) {
            logger.info("当前数据无缓存：{}", id);
            try{

            ResponseEntity<Organization> responseEntity = restTemplate.exchange("http://organizationservice/organization/{id}",
                    HttpMethod.GET, null, Organization.class, id);
            res = responseEntity.getBody();
            RedisUtils.setObj(key, res);
            }catch (Exception e){
                e.printStackTrace();
            }
        } else {
            logger.info("当前数据为缓存数据：{}", id);
        }
        return (Organization) res;
    }

    public Organization getOrganizationWithRibbonBackup(String id) {
        Organization organization = new Organization();
        organization.setId("0");
        organization.setName("组织服务调用失败");
        return organization;
    }
}
