package com.fxb.licensingservice.controller;

import com.fxb.licensingservice.Entity.Licensing;
import com.fxb.licensingservice.service.OrganizationByRibbonService;
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

    private OrganizationByRibbonService ribbonService;

    @Autowired
    public LicensingController(OrganizationByRibbonService ribbonService) {
        this.ribbonService = ribbonService;
    }

    @GetMapping("/licensingByRibbon/{orgId}")
    public Licensing getLicensingByRibbon(@PathVariable("orgId") String orgId) throws Exception {
        Licensing licensing = new Licensing();
        licensing.setOrganization(ribbonService.getOrganizationWithRibbon(orgId));
        return licensing;
    }
}
