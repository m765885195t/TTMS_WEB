package cn.motian.mapper;

import cn.motian.model.Studio;
import cn.motian.model.User;

import java.util.List;

public interface StudioMapper {
    boolean insert(Studio studio);

    boolean update(User user);

    Studio getByUnionId(String unionId);

    boolean deleter(String unionId);

    List<Studio> getStudioList();
}
