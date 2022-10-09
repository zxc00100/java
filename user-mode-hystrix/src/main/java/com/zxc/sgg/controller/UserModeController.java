package com.zxc.sgg.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zxc.sgg.service.UserModeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
//@DefaultProperties(defaultFallback = "fallBack2")
public class UserModeController {

    @Resource
    private UserModeService userModeService;

    @GetMapping("/consumer/get/infoOk/{id}")
    String getOK(@PathVariable("id") Integer id){
        return userModeService.getInfoOk(id);
    }

    @GetMapping("/consumer/get/infoNo/{id}")
    /*@HystrixCommand(fallbackMethod = "fallBack",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })*/
    //@HystrixCommand
    String getNo(@PathVariable("id") Integer id){
        //int a = 10/0;
        return userModeService.getInfoNo(id);
    }

    String fallBack(@PathVariable("id") Integer id){
        return "80...╮(╯▽╰)╭...id-->"+id;
    }
    String fallBack2(){
        return "80...╮(╯▽╰)╭...id-->0.0";
    }
}
