package com.zxc.sgg.controller;

import com.zxc.sgg.service.MessageSendService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MessageSendController {
    @Resource
    private MessageSendService messageSendService;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageSendService.send();
    }
}
