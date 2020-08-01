package com.mapper.paymentmapper;

import com.api.entiry.payment.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lby
 * @date 2020/7/31 9:43
 */

/**
 * 支付操作
 */
@Mapper
public interface PaymentMapper {

    /**
     * 修改
     */
    Boolean UpdatePayment(Payment payment);
}
