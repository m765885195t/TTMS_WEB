package cn.motian.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Seat {
    private String unionId;
    private String studioId;
    private String row;
    private String col;
    private String status;

    public Seat() {
    }

    public Seat(String studioId, String row, String col, String status) {
        this.studioId = studioId;
        this.row = row;
        this.col = col;
        this.status = status;
    }


}
