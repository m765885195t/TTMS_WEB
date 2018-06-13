package cn.motian.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Schedule {
    private String unionId;
    private String studioId;
    private String playId;
    private Long time; //演出开始时间  毫秒
    private String price;
    private String status;


    public Schedule() {
    }

    public Schedule(String studioId, String playId, Long time, String price, String status) {
        this.studioId = studioId;
        this.playId = playId;
        this.time = time;
        this.price = price;
        this.status = status;
    }
}
