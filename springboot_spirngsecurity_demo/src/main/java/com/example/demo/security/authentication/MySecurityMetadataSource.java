package com.example.demo.security.authentication;

import com.example.demo.entity.Jurisdiction;
import com.example.demo.mapper.JurisdictionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ${fxb}
 * Email: fanxb.tl@gmail.com
 * Date: 2018-07-19
 */
@Component
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JurisdictionMapper jurisdictionMapper;
    private List<Jurisdiction> jurisdictions;

    private void loadResource() {
        log.info("get all jurisdiction");
        this.jurisdictions = jurisdictionMapper.selectAllPermission();
    }


    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (jurisdictions == null) this.loadResource();
        HttpServletRequest request = ((FilterInvocation) object).getRequest();
        Set<ConfigAttribute> allConfigAttribute = new HashSet<>();
        AntPathRequestMatcher matcher;
        for (Jurisdiction jurisdiction : jurisdictions) {
            matcher = new AntPathRequestMatcher(jurisdiction.getUrl(), jurisdiction.getMethod());
            if (matcher.matches(request)) {
                ConfigAttribute configAttribute = new MyConfigAttribute(request,new MyGrantedAuthority(jurisdiction.getMethod(),jurisdiction.getUrl()));
                allConfigAttribute.add(configAttribute);
                return allConfigAttribute;
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
