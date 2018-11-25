package com.fxb.licensingservice.service;

import com.fxb.licensingservice.Entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2018/11/22 19:29
 */
@Service
public class OrganizationService {

    private static final String SERVICE_NAME = "organizationservice";
    private DiscoveryClient discoveryClient;

    @Autowired
    public OrganizationService(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    /**
     * 使用Spring DiscoveryClient查询
     *
     * @param id
     * @return
     */
    public Organization getOrganization(String id) {
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances(SERVICE_NAME);
        if (instances.size() == 0) {
            throw new RuntimeException("无可用的服务");
        }
        String serviceUri = String.format("%s/organization/%s", instances.get(0).getUri().toString(), id);
        ResponseEntity<Organization> responseEntity = restTemplate.exchange(serviceUri, HttpMethod.GET
                , null, Organization.class, id);
        return responseEntity.getBody();
    }

}
