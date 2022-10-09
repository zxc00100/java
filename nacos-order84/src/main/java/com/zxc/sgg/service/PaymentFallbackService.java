package com.zxc.sgg.service;

import com.zxc.sgg.entity.CommentResult;
import com.zxc.sgg.entity.OrderNum;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PayMentService{
    @Override
    public CommentResult<OrderNum> paymentSQL(Long id) {
        return new CommentResult<>(444444,"服务降级返回",new OrderNum(id,"error"));
    }
}
