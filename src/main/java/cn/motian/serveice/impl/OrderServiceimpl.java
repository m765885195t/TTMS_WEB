package cn.motian.serveice.impl;

import cn.motian.mapper.OrderMapper;
import cn.motian.model.Order;
import cn.motian.model.OrderRecord;
import cn.motian.serveice.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceimpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order addOrder(Order order) {
        return orderMapper.insert(order);
    }

    @Override
    public boolean addOrderRecord(OrderRecord orderRecord) {
        return orderMapper.addOrderRecord(orderRecord);
    }

    @Override
    public Order getByUnionId(String unionId) {
        return orderMapper.getByUnionId(unionId);
    }

    @Override
    public boolean updateOrder(Order order) {
        return orderMapper.update(order);
    }

    @Override
    public List<Order> getOrderListByUserId(String userId) {
        return orderMapper.getOrderListByUserId(userId);
    }

}
