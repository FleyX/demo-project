package com.fxb.licensingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient  //使用不带Ribbon功能的Spring RestTemplate,其他情况下可删除
@EnableFeignClients //使用Feign客户端进行服务调用，其他情况下可删除
public class LicensingserviceApplication {

    /**
     * 使用带有Ribbon 功能的Spring RestTemplate，其他情况可删除
     */
    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(LicensingserviceApplication.class, args);
    }
}
