package cn.motian.mapper;

import cn.motian.model.User;

public interface UserMapper {
    boolean insert(User user);

    boolean update(User user);

    User getByUnionId(String unionId);
}