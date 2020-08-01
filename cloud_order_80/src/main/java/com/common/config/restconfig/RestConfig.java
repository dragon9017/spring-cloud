package com.common.config.restconfig;

/**
 * @author lby
 * @date 2020/7/31 11:10
 */

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置rest配置类
 *
 * 使用Resttemplate进行不同服务端口之间的调用
 */
@Configuration
public class RestConfig {
//    容器注入resttemplate
//开启resttemplate的负载均衡
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
