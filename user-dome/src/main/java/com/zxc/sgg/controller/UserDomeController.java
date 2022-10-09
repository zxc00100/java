package com.zxc.sgg.controller;

import com.zxc.sgg.entity.CommentResult;
import com.zxc.sgg.entity.OrderNum;
import com.zxc.sgg.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class UserDomeController {

    private static final String url = "http://pay-mode";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/orderNum/create")
    public CommentResult<OrderNum> create(OrderNum orderNum){
        return restTemplate.postForEntity(url + "/orderNum/create", orderNum, CommentResult.class).getBody();
        //return restTemplate.postForObject(url + "/orderNum/create", orderNum, CommentResult.class);
    }

    @GetMapping("/consumer/orderNum/get/{id}")
    public CommentResult getOrderNum(@PathVariable("id") Long id){
        ResponseEntity<CommentResult> entity = restTemplate.getForEntity(url + "/orderNum/get/" + id, CommentResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommentResult(444,"错误");
        }
        //return restTemplate.getForObject(url + "/orderNum/get/" + id, CommentResult.class);
    }
    @GetMapping("/consumer/get/port")
    public String getPort(){
        /*List<String> services = discoveryClient.getServices();
        services.forEach(service -> {
            System.out.println(service);
        });*/
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("pay-mode");
        /*serviceInstances.forEach(server->{
            System.out.println(server.getInstanceId()+"\t"+server.getHost()+"\t"+server.getPort()+"\t"+server.getUri());
        });*/
        if (serviceInstances == null && serviceInstances.size() <= 0){
            return null;
        }
        ServiceInstance instance = loadBalancer.instance(serviceInstances);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/get/port", String.class);
    }
}
