package com.api.entiry.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
/**
 * 支付商家
 * 序列化
 */
public class Payment implements Serializable {

    /**
     * 主键
     */
    private long  id;

    /**
     *支付流水号
     */
    private String serial;
}
