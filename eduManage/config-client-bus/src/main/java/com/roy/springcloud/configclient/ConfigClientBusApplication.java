package com.roy.springcloud.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring boot 2.0的改动较大，/bus/refresh全部整合到actuador里面了，所以之前1.x的management.security.enabled全部失效，不适用于2.0
 * 适用于2.0的配置是这样的：
 *
 *  management:
 *   endpoints:
 *     web:
 *       exposure:
 *         include: bus-refresh
 *
 * 另外注解 @RefreshScope
 * 需要在配置的页面加上，就是说附带@Value的页面加上此注解
 *
 * 请求刷新的页面由原来1.5.x的localhost:8888/bus/refresh
 * 变成：http://localhost:8888/actuator/bus-refresh
 *
 * 注意：config-server和config-client的配置都得加上
 */
@SpringBootApplication
@RestController
@RefreshScope // 开启消息总线刷新配置功能
public class ConfigClientBusApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientBusApplication.class, args);
    }

    @Value("${name}")
    String name;
    @RequestMapping(value = "/hello")
    public String hello(){
        if(name.startsWith("$")) name = "配置文件未找到！";
        return name;
    }
}
