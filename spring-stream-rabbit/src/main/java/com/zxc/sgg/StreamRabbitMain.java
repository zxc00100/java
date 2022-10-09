package com.zxc.sgg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class StreamRabbitMain {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitMain.class,args);
    }
}
