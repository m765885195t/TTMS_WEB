package cn.motian.serveice;

import cn.motian.model.Play;

import java.util.List;

public interface PlayService {
    boolean addPlay(Play play);

    Play getByUnionId(String unionId);

    Play getByName(String name);

    boolean updatePlay(Play play);

    List<Play> getPlayList();

    boolean deleterPlay(String unionId);
}
