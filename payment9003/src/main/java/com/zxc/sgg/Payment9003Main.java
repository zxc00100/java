package com.zxc.sgg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Payment9003Main {
    public static void main(String[] args) {
        SpringApplication.run(Payment9003Main.class,args);
    }
}
