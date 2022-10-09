package com.zxc.sgg.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PayModeService {
    public String getInfoOk(Integer id){
        return "线程池 ："+Thread.currentThread().getName()+"OK!O(∩_∩)O哈哈~--->id:"+id;
    }

    @HystrixCommand(fallbackMethod = "fallBack",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String getInfoNo(Integer id){
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池 ："+Thread.currentThread().getName()+"NO!o(╥﹏╥)o--->id:"+id;
    }
    public String fallBack(Integer id){
        return "链接超时┭┮﹏┭┮ --->id:"+id;
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "fallBack",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public String fusing(Integer id){
        if (id < 0){
            throw new RuntimeException("=========id不能为负数=======id="+id);
        }else {
            return "ok,id="+id;
        }
    }
}
