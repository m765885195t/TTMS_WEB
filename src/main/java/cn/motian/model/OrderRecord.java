package cn.motian.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderRecord {
    private String unionId;  // 订单记录
    private String ticketId;  // 票
    private String orderId;  //所属订单
    private String price;    //票价

    public OrderRecord(String ticketId, String orderId, String price) {
        this.ticketId = ticketId;
        this.orderId = orderId;
        this.price = price;
    }

    public OrderRecord() {
    }
}
