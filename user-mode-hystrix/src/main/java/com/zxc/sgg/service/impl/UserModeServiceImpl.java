package com.zxc.sgg.service.impl;

import com.zxc.sgg.service.UserModeService;
import org.springframework.stereotype.Component;

@Component
public class UserModeServiceImpl implements UserModeService {
    @Override
    public String getInfoOk(Integer id) {
        return "80-->fallback-->ok;id-->"+id;
    }

    @Override
    public String getInfoNo(Integer id) {
        return "80-->fallback-->no;id-->"+id;
    }
}
