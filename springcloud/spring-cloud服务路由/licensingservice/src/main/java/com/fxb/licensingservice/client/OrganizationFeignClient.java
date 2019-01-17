package com.fxb.licensingservice.client;

import com.fxb.licensingservice.Entity.Organization;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2018/11/23 17:24
 */
@FeignClient(name="organizationservice",fallback = OrganizationFeignClientImpl.class)//使用FeignClient注解指定目标服务
public interface OrganizationFeignClient {

    /**
     * 获取组织信息
     *
     * @param orgId 组织id
     * @return Organization
     */
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    @RequestMapping(method = RequestMethod.GET, value = "/organization/{orgId}", consumes = "application/json")
    Organization getOrganization(@PathVariable("orgId") String orgId);
}
