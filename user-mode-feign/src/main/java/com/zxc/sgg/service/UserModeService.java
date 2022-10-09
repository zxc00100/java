package com.zxc.sgg.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "pay-mode")
public interface UserModeService {
    @GetMapping("/get/port")
    String getPort();
}
