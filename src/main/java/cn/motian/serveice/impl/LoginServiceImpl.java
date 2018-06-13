package cn.motian.serveice.impl;

import cn.motian.mapper.UserMapper;
import cn.motian.model.User;
import cn.motian.serveice.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(String name, String pass) {
        User user = userMapper.getUserInfo(name);
        if (user != null && user.getPass().equals(pass)) {
            return user.getIdentity();
        }
        return null;

    }
}
