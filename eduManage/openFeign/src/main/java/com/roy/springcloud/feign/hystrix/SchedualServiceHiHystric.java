package com.roy.springcloud.feign.hystrix;

import com.roy.springcloud.feign.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * 在微服务架构中，根据业务来拆分成一个个的服务，服务与服务之间可以相互调用（RPC），在Spring Cloud可以用RestTemplate+Ribbon和Feign来调用。为了保证其高可用，单个服务通常会集群部署。由于网络原因或者自身的原因，服务并不能保证100%可用，如果单个服务出现问题，调用这个服务就会出现线程阻塞，此时若有大量的请求涌入，Servlet容器的线程资源会被消耗完毕，导致服务瘫痪。服务与服务之间的依赖性，故障会传播，会对整个微服务系统造成灾难性的严重后果，这就是服务故障的“雪崩”效应。
 *
 * 为了解决这个问题，业界提出了断路器模型。
 *
 * Netflix开源了Hystrix组件，实现了断路器模式，SpringCloud对这一组件进行了整合。 在微服务架构中，一个请求需要调用多个服务是非常常见的,
 *
 * 较底层的服务如果出现故障，会导致连锁故障。当对特定的服务的调用的不可用达到一个阀值（Hystric 是5秒20次） 断路器将会被打开。
 *
 * 断路打开后，可用避免连锁故障，fallback方法可以直接返回一个固定值。
 *
 * 微服务SpringCloud组件的断路器Hystrix的封装
 * https://blog.csdn.net/orlaneBoy/article/details/79156122
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHi(String name) {
        return "Sorry,"+name+",服务器已断开连接，请稍后再试！";
    }

    @Override
    public String consumer() {
        return "consumer";
    }
}
