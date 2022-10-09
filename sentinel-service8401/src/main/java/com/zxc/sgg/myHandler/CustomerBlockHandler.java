package com.zxc.sgg.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zxc.sgg.entity.CommentResult;

public class CustomerBlockHandler {
    public static CommentResult handleException1(BlockException exception){
        return new CommentResult(444,"客户自定义 global handleException1服务不可用");
    }
    public static CommentResult handleException2(BlockException exception){
        return new CommentResult(444,"客户自定义 global handleException2服务不可用");
    }
}
