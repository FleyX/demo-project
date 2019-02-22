package com.fxb.licensingservice;

import com.fxb.licensingservice.interceptors.UserContextInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
@EnableCircuitBreaker //告诉Spring Cloud将要使用Hystrix
@EnableDiscoveryClient
public class LicensingserviceApplication {

    private Logger logger = LoggerFactory.getLogger(LicensingserviceApplication.class);

    /**
     * 使用带有Ribbon 功能的Spring RestTemplate
     */
    @LoadBalanced
    @Bean
    @SuppressWarnings("unchecked")
    public RestTemplate getRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        //加上拦截器，发出请求前加入管理id Header
        List interceptors = restTemplate.getInterceptors();
        if(interceptors==null){
            restTemplate.setInterceptors(Collections.singletonList(new UserContextInterceptor()));
        }else{
            interceptors.add(new UserContextInterceptor());
        }
        return restTemplate;
    }




    public static void main(String[] args) {
        SpringApplication.run(LicensingserviceApplication.class, args);
    }
}
