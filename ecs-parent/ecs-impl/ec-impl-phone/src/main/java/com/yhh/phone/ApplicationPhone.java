package com.yhh.phone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 手机服务启动类
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //由于不适用数据库，所以排除数据源
@EnableEurekaClient
@EnableFeignClients
public class ApplicationPhone {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationPhone.class,args);
    }
}
