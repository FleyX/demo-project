package com.fxb.licensingservice.controller;

import com.fxb.licensingservice.Entity.Licensing;
import com.fxb.licensingservice.client.OrganizationFeignClient;
import com.fxb.licensingservice.service.OrganizationByRibbonService;
import com.fxb.licensingservice.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类功能简述：
 * 类功能详述：
 *
 * @author fanxb
 * @date 2018/11/22 19:51
 */
@RestController
public class LicensingController {

    private OrganizationService organizationService;
    private OrganizationByRibbonService ribbonService;
    private OrganizationFeignClient organizationFeignClient;

    @Autowired
    public LicensingController(OrganizationService organizationService, OrganizationByRibbonService ribbonService, OrganizationFeignClient feignClient) {
        this.organizationService = organizationService;
        this.ribbonService = ribbonService;
        this.organizationFeignClient = feignClient;
    }

    @GetMapping("/licensing/{orgId}")
    public Licensing getLicensing(@PathVariable("orgId") String orgId) {
        Licensing licensing = new Licensing();
        licensing.setValid(false);
        licensing.setOrganization(organizationService.getOrganization(orgId));
        return licensing;
    }

    @GetMapping("/licensingByRibbon/{orgId}")
    public Licensing getLicensingByRibbon(@PathVariable("orgId") String orgId) {
        Licensing licensing = new Licensing();
        licensing.setValid(false);
        licensing.setOrganization(ribbonService.getOrganizationWithRibbon(orgId));
        return licensing;
    }

    @GetMapping("/licensingByFeign/{orgId}")
    public Licensing getLicensingByFeign(@PathVariable("orgId") String orgId) {
        Licensing licensing = new Licensing();
        licensing.setValid(false);
        licensing.setOrganization(organizationFeignClient.getOrganization(orgId));
        return licensing;
    }
}
