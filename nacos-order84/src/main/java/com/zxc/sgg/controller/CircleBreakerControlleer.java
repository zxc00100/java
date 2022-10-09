package com.zxc.sgg.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zxc.sgg.entity.CommentResult;
import com.zxc.sgg.entity.OrderNum;
import com.zxc.sgg.service.PayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
public class CircleBreakerControlleer {
    public static final String SERVICE_URL = "http://payment";
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/fallback/{id}")
    //@SentinelResource("fallback")
    //@SentinelResource(value = "fallback",fallback = "handlerFallback")
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler")
    //@SentinelResource(value = "fallback",blockHandler = "blockHandler",fallback = "handlerFallback")
    @SentinelResource(value = "fallback",blockHandler = "blockHandler",fallback = "handlerFallback",
            exceptionsToIgnore = {IllegalArgumentException.class})
    public CommentResult<OrderNum> fallback(@PathVariable Long id){
        CommentResult<OrderNum> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommentResult.class);
        if(id == 4){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
        }else if (result.getData() == null){
            throw new NullPointerException("NullPointerException,该ID没有对应记录，空指针异常");
        }
        return result;
    }
    public CommentResult<OrderNum> handlerFallback(@PathVariable Long id,Throwable e){

        OrderNum orderNum = new OrderNum(id, "null");
        return new CommentResult<>(444,"兜底异常handlerFallback，内容："+e.getMessage(),orderNum);
    }
    public CommentResult<OrderNum> blockHandler(@PathVariable Long id, BlockException e){

        OrderNum orderNum = new OrderNum(id, "null");
        return new CommentResult<>(444,"blockHandler限流，无此流水："+e.getMessage(),orderNum);
    }

    @Resource
    private PayMentService payMentService;

    @GetMapping("/consumer/paymentSQL/{id}")
    public CommentResult<OrderNum> paymentSQL(@PathVariable("id")Long id){
        return payMentService.paymentSQL(id);
    }
}
