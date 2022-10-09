package com.zxc.sgg.controller;

import com.zxc.sgg.service.PayModeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PayModeController {
    @Resource
    private PayModeService payModeService;

    @GetMapping("/get/infoOk/{id}")
    public String getInfoOk(@PathVariable("id") Integer id){
        return payModeService.getInfoOk(id);
    }
    /*@GetMapping("/get/infoNo/{id}")
    public String getInfoNo(@PathVariable("id") Integer id){
        return payModeService.getInfoNo(id);
    }*/
    @GetMapping("/get/infoNo/{id}")
    public String fusing(@PathVariable("id") Integer id){
        return payModeService.fusing(id);
    }
}
