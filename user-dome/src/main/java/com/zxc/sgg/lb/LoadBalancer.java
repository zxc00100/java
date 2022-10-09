package com.zxc.sgg.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LoadBalancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
