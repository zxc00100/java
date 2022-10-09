package com.zxc.sgg.service;

import com.zxc.sgg.entity.CommentResult;
import com.zxc.sgg.entity.OrderNum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "payment",fallback = PaymentFallbackService.class)
public interface PayMentService {
    @GetMapping("/paymentSQL/{id}")
    public CommentResult<OrderNum> paymentSQL(@PathVariable("id") Long id);
}
