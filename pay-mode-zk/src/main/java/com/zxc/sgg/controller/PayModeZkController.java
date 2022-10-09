package com.zxc.sgg.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PayModeZkController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/zk/info")
    public String getZkInfo(){
        return "springcloud with zk:" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
