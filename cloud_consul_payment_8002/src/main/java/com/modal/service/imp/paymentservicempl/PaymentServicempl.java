package com.modal.service.imp.paymentservicempl;

import com.api.entiry.payment.Payment;
import com.modal.mapper.paymentmapper.PaymentMapper;
import com.modal.service.paymentservice.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lby
 * @date 2020/7/31 9:52
 */
@Service
@Slf4j
public class PaymentServicempl implements PaymentService {
    @Resource
    private  PaymentMapper paymentMapper;

    @Override
    public Boolean UpdatePayment(Payment payment) {
        Boolean aBoolean = paymentMapper.UpdatePayment(payment);
        if (aBoolean){
            log.info("修改成功");
            return aBoolean;
        }
        else {
            log.info("修改失败");
            return aBoolean;
        }
    }
}
