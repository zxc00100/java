package com.zxc.sgg.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class UserDomeController {

    private static final String url = "http://pay-mode-consul";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/consul/info")
    public String getInfo(){
        return restTemplate.getForObject(url + "/consul/info", String.class);
    }

}
