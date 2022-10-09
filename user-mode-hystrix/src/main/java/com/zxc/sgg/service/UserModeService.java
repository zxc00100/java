package com.zxc.sgg.service;

import com.zxc.sgg.service.impl.UserModeServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Component
@FeignClient(value = "pay-mode-hystrix",fallback = UserModeServiceImpl.class)
public interface UserModeService {
    @GetMapping("/get/infoOk/{id}")
    String getInfoOk(@PathVariable("id") Integer id);

    @GetMapping("/get/infoNo/{id}")
    String getInfoNo(@PathVariable("id") Integer id);
}
