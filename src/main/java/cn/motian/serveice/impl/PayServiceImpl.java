package cn.motian.serveice.impl;

import cn.motian.model.Order;
import cn.motian.model.OrderRecord;
import cn.motian.model.Ticket;
import cn.motian.serveice.OrderService;
import cn.motian.serveice.PayService;
import cn.motian.serveice.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static cn.motian.constant.TTMSConst.TTMS_Order_STATUS.PAY;

@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private OrderService orderService;

    public boolean pay(String userId, String ticket, String paymentAmount) {
        List<Ticket> ticketList = Arrays.stream(ticket.split(","))
                .map(o -> ticketService.getByUnionId(o))
                .collect(Collectors.toList());
        double ticketAmount = ticketList.stream()
                .map(o -> Double.parseDouble(o.getPrice()))
                .reduce((x, y) -> x + y).get();
        double retrievedAmount = Double.parseDouble(paymentAmount) - ticketAmount;
        if (retrievedAmount < 0) { // 支付金额不足
            return false;
        }
        // 创建订单
        Order order = new Order(userId, String.valueOf(paymentAmount),
                String.valueOf(retrievedAmount), String.valueOf(PAY.ordinal()));
        Order neworder = orderService.addOrder(order);
        // 创建订单记录
        ticketList.stream()
                .forEach(o -> {
                            OrderRecord orderRecord = new OrderRecord(o.getUnionId(), neworder.getUnionId(), o.getPrice());
                            orderService.addOrderRecord(orderRecord);
                        }
                );
        return true;
    }
}
