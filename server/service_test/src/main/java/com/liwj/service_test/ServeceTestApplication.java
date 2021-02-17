package com.liwj.service_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients  //消费者启用
@SpringBootApplication
public class ServeceTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServeceTestApplication.class, args);
    }

}
