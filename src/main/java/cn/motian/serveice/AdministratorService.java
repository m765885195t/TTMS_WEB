package cn.motian.serveice;

import cn.motian.exception.TTMSException;
import cn.motian.model.User;

public interface AdministratorService {


    boolean addUser(User user);

    boolean updateUser(User user);

    User getByUnionId(String unionId) throws TTMSException;

}
