package cn.motian.serveice;

public interface PayService {
    boolean pay(String userId,String ticketList,String paymentAmount);
}
