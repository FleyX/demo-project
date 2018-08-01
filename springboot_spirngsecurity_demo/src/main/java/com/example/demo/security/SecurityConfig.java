package com.example.demo.security;

import com.example.demo.security.authentication.MyFilterSecurityInterceptor;
import com.example.demo.service.SecurityUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MyAuthFailedHandle myAuthFailedHandle;
	@Autowired
	private MyAuthSuccessHandle myAuthSuccessHandle;
	@Autowired
	private MyAccessDeniedHandler myAccessDeniedHandler;
	@Autowired
	private MyLogoutSuccessHandle myLogoutSuccessHandle;
	@Autowired
	private AuthenticationManagerBuilder authenticationManagerBuilder;
	@Autowired
    private MyAuthenticationEntryPoint myAuthenticationEntryPoint;
	@Autowired
    private MyFilterSecurityInterceptor urlFilterSecurityInterceptor;
	@Autowired
    private SecurityUserService securityUserService;
	@Autowired
    private MyPasswordEncoder myPasswordEncoder;
	@Autowired
    DataSource dataSource;

	@Bean
	public AuthenticationManager authenticationManager() throws Exception {
		return this.authenticationManagerBuilder.build();
	}

	@Bean
    public MyUsernamePasswordAuthentication myUsernamePasswordAuthentication(){
	    MyUsernamePasswordAuthentication myUsernamePasswordAuthentication = new MyUsernamePasswordAuthentication();
	    //设置登录成功处理，登录失败处理
	    myUsernamePasswordAuthentication.setAuthenticationFailureHandler(myAuthFailedHandle);
	    myUsernamePasswordAuthentication.setAuthenticationSuccessHandler(myAuthSuccessHandle);
	    myUsernamePasswordAuthentication.setFilterProcessesUrl("/public/login");
	    myUsernamePasswordAuthentication.setRememberMeServices(rememberMeServices());
	    myUsernamePasswordAuthentication.setUsernameParameter("id");
	    myUsernamePasswordAuthentication.setPasswordParameter("password");
	    return myUsernamePasswordAuthentication;
    }

//    @Bean
//    public UrlFilterSecurityInterceptor urlFilterSecurityInterceptor(){
//	    UrlFilterSecurityInterceptor urlFilterSecurityInterceptor = new UrlFilterSecurityInterceptor();
//	    urlFilterSecurityInterceptor.setSecurityMetadataSource(mySecurityMetadataSource);
//	    urlFilterSecurityInterceptor.setAccessDecisionManager(myAccessDecisionManager);
//	    return urlFilterSecurityInterceptor;
//    }
	

	
	//设置登录
	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(securityUserService)
			.passwordEncoder(myPasswordEncoder);
//		auth.eraseCredentials(false);
	}

	@Bean
    public RememberMeServices rememberMeServices(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        PersistentTokenBasedRememberMeServices rememberMeServices =
                new PersistentTokenBasedRememberMeServices("INTERNAL_SECRET_KEY",securityUserService,jdbcTokenRepository);
//        rememberMeServices.setCookieName("heiyou");
        return rememberMeServices;
    }



	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.sessionManagement().maximumSessions(1).expiredUrl("/public/unlogin");
		http
		.csrf() //跨站
		.disable() //关闭跨站检测
        //自定义鉴权过程，无需下面设置
//		.authorizeRequests()//验证策略
//			.antMatchers("/public/**").permitAll()//无需验证路径
//            .antMatchers("/user/**").permitAll()
//            .antMatchers("/login").permitAll()//放行登录
//			.antMatchers(HttpMethod.GET, "/user").hasAuthority("getAllUser")//拥有权限才可访问
//			.antMatchers(HttpMethod.GET, "/user").hasAnyAuthority("1","2")//拥有任一权限即可访问
			//角色类似，hasRole(),hasAnyRole()
//			.anyRequest().authenticated()
//		.and()
		.exceptionHandling()
            .authenticationEntryPoint(myAuthenticationEntryPoint)//未登录处理
			.accessDeniedHandler(myAccessDeniedHandler)//权限不足处理
		.and()
        .addFilterBefore(myUsernamePasswordAuthentication(),UsernamePasswordAuthenticationFilter.class)
		.addFilterBefore(urlFilterSecurityInterceptor,FilterSecurityInterceptor.class)
        .rememberMe()//默认放在内存中
            .rememberMeServices(rememberMeServices())
            .key("INTERNAL_SECRET_KEY")
//       重写usernamepasswordauthenticationFilter后，下面的设置失效
//        .and()
//		.formLogin()
//			.loginPage("/public/unlogin") //未登录跳转页面,设置了authenticationentrypoint后无需设置未登录跳转页面
//			.loginProcessingUrl("/public/login")//登录api
//            .successForwardUrl("/success")
//            .failureForwardUrl("/failed")
//            .usernameParameter("id")
//            .passwordParameter("password")
//			.failureHandler(myAuthFailedHandle) //登录失败处理
//			.successHandler(myAuthSuccessHandle)//登录成功处理
//            .usernameParameter("id")
		.and()
		.logout()//自定义登出
			.logoutUrl("/public/logout")
//            .logoutSuccessUrl("public/logoutSuccess")
			.logoutSuccessHandler(myLogoutSuccessHandle);
	}
}
