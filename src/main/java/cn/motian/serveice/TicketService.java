package cn.motian.serveice;

import cn.motian.model.Ticket;

import java.util.List;

public interface TicketService {
    boolean addTicket(Ticket ticket);

    Ticket getByUnionId(String unionId);

    boolean updateTicketStatus(Ticket studio);

    List<Ticket> getByScheduleId(String scheduleId);

    Ticket getTicketByScheduleIdAndSeatId(String seatId, String scheduleId);
}
