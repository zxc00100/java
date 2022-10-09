package com.zxc.sgg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigClient2Main {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient2Main.class,args);
    }
}
