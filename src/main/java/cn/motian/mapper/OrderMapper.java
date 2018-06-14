package cn.motian.mapper;

import cn.motian.model.Order;
import cn.motian.model.OrderRecord;

import java.util.List;

public interface OrderMapper {
    Order insert(Order order);

    boolean addOrderRecord(OrderRecord orderRecord);

    Order getByUnionId(String unionId);


    List<Order> getOrderListByUserId(String userId);

    boolean update(Order order);
}
