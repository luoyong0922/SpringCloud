package com.roy.springcloud.feign.controller;

import com.roy.springcloud.feign.service.HiService;
import com.roy.springcloud.feign.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HiController {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @Autowired
    HiService service;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "name") String name){
        return schedualServiceHi.sayHi(name);
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name") String name){
        return service.hiService(name);
    }

    @RequestMapping(value = "/consumer",method = RequestMethod.GET)
    public String consumer(){
        return schedualServiceHi.consumer();
    }
}
