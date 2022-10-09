package com.zxc.sgg.service;

import com.zxc.sgg.entity.OrderNum;
import org.apache.ibatis.annotations.Param;

public interface OrderNumService {

    int create(OrderNum orderNum);

    OrderNum getOrderNumById(@Param("id")Long id);

}
