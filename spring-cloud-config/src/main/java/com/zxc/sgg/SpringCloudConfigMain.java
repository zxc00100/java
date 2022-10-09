package com.zxc.sgg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigMain.class,args);
    }
}
