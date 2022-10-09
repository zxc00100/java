package com.zxc.sgg.controller;

import com.zxc.sgg.entity.CommentResult;
import com.zxc.sgg.entity.OrderNum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Slf4j
public class PayMentController {
    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long, OrderNum> hashMap = new HashMap();
    static {
        hashMap.put(1L,new OrderNum(1L,"65416464654"));
        hashMap.put(2L,new OrderNum(2L,"446464"));
        hashMap.put(3L,new OrderNum(3L,"8888888888888"));
    }
    @GetMapping("/paymentSQL/{id}")
    public CommentResult<OrderNum> paymentSQL(@PathVariable("id")Long id){
        OrderNum orderNum = hashMap.get(id);
        CommentResult result = new CommentResult(200, "serverport:" + serverPort, orderNum);
        return result;
    }
}
