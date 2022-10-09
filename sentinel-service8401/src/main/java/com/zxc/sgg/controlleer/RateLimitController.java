package com.zxc.sgg.controlleer;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zxc.sgg.entity.CommentResult;
import com.zxc.sgg.entity.OrderNum;
import com.zxc.sgg.myHandler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommentResult byResource(){
        return new CommentResult(200,"按资源名称限流测试OK",new OrderNum(2020L,"seral001"));
    }
    public CommentResult handleException(BlockException exception){
        return new CommentResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用");
    }
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource("byUrl")
    public CommentResult byUrl(){
        return new CommentResult(200,"按url限流测试OK",new OrderNum(2020L,"seral002"));
    }
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handleException2")
    public CommentResult customerBlockHandler(){
        return new CommentResult(200,"按用户自定义限流测试OK",new OrderNum(2020L,"seral003"));
    }
}
