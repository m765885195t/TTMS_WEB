package cn.motian.mapper;

import cn.motian.model.User;


public interface UserMapper {
    //这里以接口形式定义了数据库操作方法,我们只需
    // 在Mybatis映射文件中对其进行映射就可以直接使用
    boolean insert(User user);

    boolean update(User user);

    User getByUnionId(String unionId);
}