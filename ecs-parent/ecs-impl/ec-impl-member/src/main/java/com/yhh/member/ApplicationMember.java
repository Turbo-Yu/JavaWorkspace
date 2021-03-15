package com.yhh.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 会员服务启动类
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ApplicationMember {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMember.class,args);
    }
}
