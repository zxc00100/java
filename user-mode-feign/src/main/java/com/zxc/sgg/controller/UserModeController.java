package com.zxc.sgg.controller;

import com.zxc.sgg.service.UserModeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class UserModeController {
    @Resource
    private UserModeService userModeService;

    @GetMapping("/consumer/get/port")
    String getPort(){
        return userModeService.getPort();
    }

}
