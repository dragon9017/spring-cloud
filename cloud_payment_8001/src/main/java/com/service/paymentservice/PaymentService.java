package com.service.paymentservice;

import com.api.entiry.payment.Payment;

/**
 * @author lby
 * @date 2020/7/31 9:51
 */
public interface PaymentService {
    /**
     * 修改
     */
    Boolean UpdatePayment(Payment payment);
}
