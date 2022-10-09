package com.zxc.sgg.dao;

import com.zxc.sgg.entity.OrderNum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderNumDao {

    int create(OrderNum orderNum);

    OrderNum getOrderNumById(@Param("id")Long id);
}
