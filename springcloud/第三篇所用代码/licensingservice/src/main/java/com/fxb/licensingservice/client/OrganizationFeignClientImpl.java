package com.fxb.licensingservice.client;

import com.fxb.licensingservice.Entity.Organization;
import org.springframework.stereotype.Component;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2018/12/7 11:30
 */
@Component
public class OrganizationFeignClientImpl implements OrganizationFeignClient{

    @Override
    public Organization getOrganization(String orgId) {
        Organization organization=new Organization();
        organization.setId("0");
        organization.setName("后备模式返回的数据");
        return organization;
    }
}
