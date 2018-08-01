package com.example.demo.security.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class MyAccessDecisionManager implements AccessDecisionManager{
    private Logger log = LoggerFactory.getLogger(this.getClass());
    private AuthenticationTrustResolver authenticationTrustResolver = new AuthenticationTrustResolverImpl();

    @Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
	    //无需验证放行
	    if(configAttributes==null || configAttributes.size()==0)
	        return;
	    log.info("开始验证");
//	    if(!authentication.isAuthenticated()){
        if(authenticationTrustResolver.isAnonymous(authentication)){
	        throw new InsufficientAuthenticationException("未登录");
        }
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for(ConfigAttribute attribute : configAttributes){
            if(!(attribute instanceof MyConfigAttribute)) continue;
            MyConfigAttribute urlConfigAttribute = (MyConfigAttribute)attribute;
            for(GrantedAuthority authority: authorities){
                if(!(authority instanceof MyGrantedAuthority)) continue;
                MyGrantedAuthority myGrantedAuthority = (MyGrantedAuthority)authority;
                if(urlConfigAttribute.getMyGrantedAuthority().equals(myGrantedAuthority))
                    return;
            }
        }
        throw new AccessDeniedException("无权限");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}
}
