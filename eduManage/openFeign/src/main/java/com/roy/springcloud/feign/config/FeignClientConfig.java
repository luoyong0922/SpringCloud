package com.roy.springcloud.feign.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

/**
 * springcloud的fegin加入全局拦截器
 */
@Configuration
public class FeignClientConfig implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {

        //这里可以添加feign请求的全局参数
        requestTemplate.header("msClientId", "8888");

    }
}

