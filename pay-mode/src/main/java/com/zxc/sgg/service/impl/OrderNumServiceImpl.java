package com.zxc.sgg.service.impl;

import com.zxc.sgg.dao.OrderNumDao;
import com.zxc.sgg.entity.OrderNum;
import com.zxc.sgg.service.OrderNumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderNumServiceImpl implements OrderNumService {

    @Resource
    private OrderNumDao orderNumDao;

    @Override
    public int create(OrderNum orderNum) {
        return orderNumDao.create(orderNum);
    }

    @Override
    public OrderNum getOrderNumById(Long id) {
        return orderNumDao.getOrderNumById(id);
    }
}
