package com;

import com.myrule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.BackgroundPreinitializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author lby
 * @date 2020/7/31 16:41
 */

//使用ribbon
//设置使用自定义的ribbon规则
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyselfRule.class)
public class PaymentApplication8002 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8002.class,args);
    }
}
