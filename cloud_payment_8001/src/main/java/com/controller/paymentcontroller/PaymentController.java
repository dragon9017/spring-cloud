package com.controller.paymentcontroller;

import com.api.commons.CommonResult;
import com.api.entiry.payment.Payment;
import com.service.paymentservice.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import sun.plugin.com.DispatchClient;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author lby
 * @date 2020/7/31 9:58
 */
@Slf4j
@RestController
@RequestMapping("payment")
public class PaymentController {
    @Value("${server.port}")
    private String port;
    @Resource
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/system/update")
    public CommonResult UpdateData(@RequestBody Payment payment){
        Boolean aBoolean = paymentService.UpdatePayment(payment);
        return new CommonResult(200,"修改成功",aBoolean);
    }

    /**
     * 暴露当前微服务的自身信息
     */
    @GetMapping("/system/about")
    public Object SelectAbout(){
        List<String> services = discoveryClient.getServices();
        System.out.println("当前服务"+services);
//        通过服务id获取信息
        List<ServiceInstance> payment8001 = discoveryClient.getInstances("cloud_payment_service");
        for (ServiceInstance serviceInstance:payment8001){
            System.out.println("服务的内容"+serviceInstance.getInstanceId()+"----"+serviceInstance.getHost()+"----"+serviceInstance.getPort()+"----"+serviceInstance.getUri());
        }
        return this.discoveryClient;
    }

    /**
     * 查看zookeeper的端口号是否注入成功
     */
    @GetMapping("/system/about/zookeeper")
    public String GetZooker(){
        log.info("当前服务器的端口号"+port+"--------流水号"+UUID.randomUUID().toString());
        return (UUID.randomUUID().toString());
    }

}
