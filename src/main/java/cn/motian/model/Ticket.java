package cn.motian.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Ticket {
    private String unionId;
    private String seatId;
    private String scheduleId;
    private String price;
    private String status;

    public Ticket() {
    }

    public Ticket(String seatId, String scheduleId, String price, String status) {
        this.seatId = seatId;
        this.scheduleId = scheduleId;
        this.price = price;
        this.status = status;
    }
}
