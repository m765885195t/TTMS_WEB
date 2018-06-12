package cn.motian.serveice.impl;

import cn.motian.exception.TTMSException;
import cn.motian.mapper.UserMapper;
import cn.motian.model.User;
import cn.motian.serveice.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private UserMapper userMapper;

    public boolean addUser(User user) {
        return userMapper.insert(user);
    }

    public boolean updateUser(User user) {



        return userMapper.update(user);
    }

    public User getByUnionId(String unionId) throws TTMSException {
        User user = userMapper.getByUnionId(unionId);
        if (user == null) {
            throw new TTMSException("user not find, unionId=" + unionId,
                    TTMSException.TTMSExceptionType.UNKNOWN_UNION_ID);
        }
        return user;
    }
}
