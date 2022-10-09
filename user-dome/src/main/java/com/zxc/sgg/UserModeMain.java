package com.zxc.sgg;

import com.zxc.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "pay-mode",configuration=MyRule.class)
public class UserModeMain {
    public static void main(String[] args) {
        SpringApplication.run(UserModeMain.class,args);
    }
}
