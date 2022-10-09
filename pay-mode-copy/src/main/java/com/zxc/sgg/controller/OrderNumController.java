package com.zxc.sgg.controller;

import com.zxc.sgg.entity.CommentResult;
import com.zxc.sgg.entity.OrderNum;
import com.zxc.sgg.service.OrderNumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderNumController {

    @Resource
    private OrderNumService orderNumService;
    @Value("${server.port}")
    private String port;

    @PostMapping("orderNum/create")
    public CommentResult create(@RequestBody OrderNum orderNum){
        int result = orderNumService.create(orderNum);
        if (result > 0){
            log.info("========");
            return new CommentResult(200,"插入数据成功",result);
        }else {
            return new CommentResult(444,"插入失败",null);
        }
    }

    @GetMapping("orderNum/get/{id}")
    public CommentResult getOrderNumById(@PathVariable("id") Long id){
        OrderNum orderNum = orderNumService.getOrderNumById(id);
        if (orderNum != null){
            return new CommentResult(200,"查询成功",orderNum);
        }else {
            return new CommentResult(444,"查询失败，id："+id,null);
        }
    }
    @GetMapping("/get/port")
    public String getPort(){
        return port;
    }
}
