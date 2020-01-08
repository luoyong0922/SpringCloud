package com.roy.springcloud.feign.service;

import org.springframework.stereotype.Service;

@Service
public class HiService {

    public String sayHi(String name){
        return "Hi,"+name;
    }
}
