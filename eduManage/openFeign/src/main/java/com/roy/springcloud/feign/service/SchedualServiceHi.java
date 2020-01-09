package com.roy.springcloud.feign.service;

import com.roy.springcloud.feign.hystrix.SchedualServiceHiHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使用 @FeignClient注解需引入spring-cloud-starter-eureka依赖，且value需对应服务名称 (不区分大小写)
 * 否则会出现 "com.netflix.client.ClientException: Load balancer does not have available server for client: springcloud-client" 错误
 * 需引入 spring-boot-starter-web 依赖，否则无法启动
 */
@FeignClient(value = "SpringCloud-client",fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHi(@RequestParam(value = "name") String name);

    @GetMapping("/")
    String consumer();
}
