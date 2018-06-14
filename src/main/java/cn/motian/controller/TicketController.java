package cn.motian.controller;

import cn.motian.constant.TTMSConst;
import cn.motian.model.Ticket;
import cn.motian.serveice.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(TTMSConst.TTMS_SERVER_URL.CONDUCTOR)
public class TicketController {
    @Autowired
    private TicketService ticketService;


    @RequestMapping(params = "method=getTicketByScheduleIdAndSeatId", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getTicketByScheduleIdAndSeatId(
            @RequestParam String seatId,
            @RequestParam String scheduleId
    ) {
        Map<String, Object> rs = new HashMap<>();
        Ticket ticket = ticketService.getTicketByScheduleIdAndSeatId(seatId,scheduleId);
        rs.put("ticket", ticket);
        return rs;
    }


}