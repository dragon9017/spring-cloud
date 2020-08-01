package com.myrule;

/**
 * @author lby
 * @date 2020/8/1 17:18
 */

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义ribbot规则
 */
@Configuration
public class MyselfRule {
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }

}
