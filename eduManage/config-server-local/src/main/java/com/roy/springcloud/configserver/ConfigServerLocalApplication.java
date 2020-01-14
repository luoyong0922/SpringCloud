package com.roy.springcloud.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient // 注册到注册中心
@EnableConfigServer // 启动配置中心
public class ConfigServerLocalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerLocalApplication.class, args);
    }

}
