package cn.motian.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order {
    private String unionId;
    private String userId;
    private String paymentAmount;  // 支付金额
    private String retrievedAmount; // 找回金额
    private String status;   // 订单状态


    public Order(String userId, String paymentAmount, String retrievedAmount, String status) {
        this.userId = userId;
        this.paymentAmount = paymentAmount;
        this.retrievedAmount = retrievedAmount;
        this.status = status;
    }

    public Order() {
    }
}
