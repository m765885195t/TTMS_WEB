package cn.motian.serveice;

import cn.motian.exception.TTMSException;
import cn.motian.model.User;

import java.util.List;

public interface UserService {

    boolean addUser(User user);

    boolean updateUser(User user);

    User getByUnionId(String unionId) throws TTMSException;

    boolean deleterUser(String unionId);

    List<User> getUserList();
}
