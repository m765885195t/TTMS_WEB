package cn.motian.mapper;

import cn.motian.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    boolean insert(User user);

    boolean update(User user);

    User getByUnionId(String unionId);

    boolean deleter(String unionId);

    User getUserInfo(@Param("name") String name, @Param("identity")String identity);

    List<User> getUserList();
}