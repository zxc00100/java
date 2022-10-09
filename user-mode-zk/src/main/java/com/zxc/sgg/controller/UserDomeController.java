package com.zxc.sgg.controller;

import com.zxc.sgg.entity.CommentResult;
import com.zxc.sgg.entity.OrderNum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class UserDomeController {

    private static final String url = "http://pay-mode-zk";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/zk/info")
    public String getInfo(){
        return restTemplate.getForObject(url + "/zk/info", String.class);
    }

}
