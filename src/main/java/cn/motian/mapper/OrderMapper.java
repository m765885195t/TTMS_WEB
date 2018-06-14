package cn.motian.mapper;

import cn.motian.model.Order;
import cn.motian.model.OrderRecord;

import java.util.List;

public interface OrderMapper {
    Order addOrder(Order order);

    boolean addOrderRecord(OrderRecord orderRecord);

    Order getByUnionId(String unionId);

    boolean updateOrder(Order order);

    List<Order> getOrderListByUserId(String userId);
}
