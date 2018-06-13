package cn.motian.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Studio extends BaseData {
    private String unionId;
    private String name;
    private int row;
    private int col;
    private String introduce;

    public Studio() {
    }

    public Studio(String name, int row, int col,
                  String introduce) {
        this.name = name;
        this.row = row;
        this.col = col;
        this.introduce = introduce;
    }
}