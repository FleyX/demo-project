package com.fxb.licensingservice.service;

import com.fxb.licensingservice.Entity.Organization;
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

    public Organization getOrganizationWithRibbon(String id) {
        ResponseEntity<Organization> responseEntity = restTemplate.exchange("http://organizationservice/organization/{id}",
                HttpMethod.GET, null, Organization.class, id);
        return responseEntity.getBody();
    }
}
