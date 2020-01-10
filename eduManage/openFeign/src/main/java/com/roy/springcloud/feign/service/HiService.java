package com.roy.springcloud.feign.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HiService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForEntity("http://SPRINGCLOUD-CLIENT/hi?name="+name,String.class).getBody();
    }

    public String hiError(String name) {
        return "hi,"+name+",something is wrong!";
    }
}
