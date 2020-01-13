package com.roy.springcloud.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hystrix 监控数据聚合 Turbine【Finchley 版】
 * https://windmt.com/2018/04/17/spring-cloud-6-turbine/
 *
 * 断路器指标数据监控Hystrix Dashboard 和 Turbine
 * https://www.cnblogs.com/chry/p/7286601.html
 *
 */
@SpringBootApplication(scanBasePackages = { "com.roy.springcloud.feign" })
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.roy.springcloud.feign.service"})
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
