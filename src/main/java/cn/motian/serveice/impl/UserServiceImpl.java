package cn.motian.serveice.impl;

import cn.motian.mapper.UserMapper;
import cn.motian.model.User;
import cn.motian.serveice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean addUser(User user) {
        return userMapper.insert(user);
    }

    public boolean updateUser(User user) {
        return userMapper.update(user);
    }

    public User getByUnionId(String unionId) {
        return userMapper.getByUnionId(unionId);
    }

    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    public boolean deleterUser(String unionId) {
        return userMapper.deleter(unionId);
    }
}

