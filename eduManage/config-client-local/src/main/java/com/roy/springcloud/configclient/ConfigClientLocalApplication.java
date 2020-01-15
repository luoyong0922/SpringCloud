package com.roy.springcloud.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope // 开启消息总线刷新配置功能
public class ConfigClientLocalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientLocalApplication.class, args);
    }
    // 防止未找到相关属性 （如：${foo}）而导致项目启动失败
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
        c.setIgnoreUnresolvablePlaceholders(true);
        return c;
    }

    @Value("${foo}")
    String foo;
    @RequestMapping(value = "/hi")
    public String hi(){
        if(foo.startsWith("$")) foo = "配置文件未找到！";
        return foo;
    }

    @Value("${name}")
    String name;
    @RequestMapping(value = "/hello")
    public String hello(){
        if(name.startsWith("$")) name = "配置文件未找到！";
        return name;
    }
}
