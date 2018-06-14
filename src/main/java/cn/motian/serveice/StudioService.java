package cn.motian.serveice;

import cn.motian.model.Studio;

import java.util.List;

public interface StudioService {
    boolean addStudio(Studio studio);

    Studio getByUnionId(String unionId);

    Studio getByName(String name);


    boolean updateStudio(Studio studio);

    List<Studio> getStudioList();

    boolean deleterStudio(String unionId);

    boolean deleterStudioByName(String name);
}
