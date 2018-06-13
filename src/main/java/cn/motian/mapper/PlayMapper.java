package cn.motian.mapper;

import cn.motian.model.Play;

import java.util.List;

public interface PlayMapper {
    boolean insert(Play play);

    boolean update(Play play);

    Play getByUnionId(String unionId);

    boolean deleter(String unionId);

    List<Play> getPlayList();

    Play getByName(String name);
}
