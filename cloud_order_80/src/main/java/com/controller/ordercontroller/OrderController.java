package com.controller.ordercontroller;

import com.api.commons.CommonResult;
import com.api.entiry.payment.Payment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author lby
 * @date 2020/7/31 11:04
 */

/**
 * 客户端控制
 * 在客户端服务中调用支付服务
 */
@RestController
@Slf4j
@RequestMapping("order")
public class OrderController {
//    使用resttemplate调用服务
    @Resource
    private RestTemplate restTemplate;
    @Value("${server.port}")
    private String port;
    @PostMapping ("/system/update")
    public CommonResult UpdateData(@RequestBody Payment payment){
//       resttemplate发送post请求
        log.info("80发送8001调用");
        CommonResult commonResult = restTemplate.postForObject("http://localhost:8081/payment/system/update", payment, CommonResult.class);
        return new CommonResult(200,"调用成功",commonResult);
    }

    @GetMapping("/system/about")
    public String Show_zookeeper(){
        log.info("当前端口"+port);
//        访问8001中的获取8001服务器的接口
        String forObject = restTemplate.getForObject("http://CLOUD-PAYMENT-SERVICE/payment/system/update", String.class);
        log.info("获取支付系统信息");
        return forObject;
    }


    /**
     * resttemplate
     */

//    @PostMapping ("/system/update")
//    public CommonResult UpdateData(@RequestBody Payment payment){
////       resttemplate发送post请求
//        log.info("80发送8001调用");
//        ResponseEntity<CommonResult> commonResultResponseEntity = restTemplate.postForEntity("http://localhost:8081/payment/system/update", payment, CommonResult.class);
////        获取请求返回状态
//        HttpStatus statusCode = commonResultResponseEntity.getStatusCode();
////        判断请求状态的不同
//        if (statusCode.is2xxSuccessful()){
//            log.info("返回成功"+statusCode.getReasonPhrase());
//            return new CommonResult(200,"调用成功");
//        }
//        else if (statusCode.is4xxClientError()){
//            log.info("页面错误"+statusCode.getReasonPhrase());
//            return new CommonResult(400,"页面错误");
//        }
//        else if (statusCode.is5xxServerError()){
//            log.info("服务器错误"+statusCode.getReasonPhrase());
//            return new CommonResult(500,"服务器错误");
//        }
//        else{
//            return new CommonResult(100,"未知");
//        }
//    }


}
