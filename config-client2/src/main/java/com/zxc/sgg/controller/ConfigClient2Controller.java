package com.zxc.sgg.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RefreshScope
public class ConfigClient2Controller {
    @Value("${config}")
    private String config;

    @GetMapping("/get/configInfo")
    public String getConfigInfo(){
        return "3366"+config;
    }
}
