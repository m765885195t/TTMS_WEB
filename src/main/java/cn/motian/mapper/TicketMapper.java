package cn.motian.mapper;

import cn.motian.model.Ticket;

import java.util.List;


public interface TicketMapper {
    boolean addTicket(Ticket ticket);

    Ticket getByUnionId(String unionId);

    boolean updateTicketStatus(Ticket studio);


    List<Ticket> getByScheduleId();
}
