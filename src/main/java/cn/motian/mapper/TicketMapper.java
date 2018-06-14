package cn.motian.mapper;

import cn.motian.model.Ticket;

import java.util.List;


public interface TicketMapper {
    boolean insert(Ticket ticket);

    Ticket getByUnionId(String unionId);

    boolean updateTicketStatus(Ticket studio);

    Ticket getTicketByScheduleIdAndSeatId(String seatId, String scheduleId);

    List<Ticket> getByScheduleId();
}
