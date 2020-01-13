package com.roy.springcloud.feign.controller;

import com.roy.springcloud.feign.service.HiService;
import com.roy.springcloud.feign.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HiController {

    // https://stackoverflow.com/questions/37565186/spring-couldnt-autowired-there-is-more-than-one-bean-of-type
    // Spring Couldn't autowired,there is more than one bean of `` type
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
