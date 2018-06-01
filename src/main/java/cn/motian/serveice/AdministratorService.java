package cn.motian.serveice;

import cn.motian.exception.TTMSException;
import cn.motian.mapper.UserMapper;
import cn.motian.model.User;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@CommonsLog
public class AdministratorService {

    @Autowired
    private UserMapper userMapper;

    public boolean addUser(User user) throws TTMSException {
        return userMapper.insert(user);
    }

    public User updateUser(String unionId, String name, String pass) throws TTMSException {
        User user = getByUnionId(unionId);
        user.setName(name);
        user.setPass(pass);
        userMapper.update(user);
        return user;
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
