package com.zxc.sgg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PayModeZKMain {
    public static void main(String[] args) {
        SpringApplication.run(PayModeZKMain.class,args);
    }
}
