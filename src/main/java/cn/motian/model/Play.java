package cn.motian.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Play extends BaseData {
    private String unionId;
    private String type;
    private String language;
    private String name;
    private String introduction;
    private String image;
    private Long length;//剧目时长  毫秒


    public Play() {
    }

    public Play(String type, String language, String name, String introduction, String image, Long length) {
        this.type = type;
        this.language = language;
        this.name = name;
        this.introduction = introduction;
        this.image = image;
        this.length = length;
    }


}
