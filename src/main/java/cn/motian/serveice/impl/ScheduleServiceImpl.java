package cn.motian.serveice.impl;

import cn.motian.constant.TTMSConst;
import cn.motian.mapper.ScheduleMapper;
import cn.motian.model.Schedule;
import cn.motian.model.Seat;
import cn.motian.model.Studio;
import cn.motian.model.Ticket;
import cn.motian.serveice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static cn.motian.constant.TTMSConst.TTMS_SEAT_STATUS.DAMAGE;
import static cn.motian.constant.TTMSConst.TTMS_SEAT_STATUS.USE;
import static cn.motian.constant.TTMSConst.TTMS_TICKET_STATUS.NOEXIT;
import static cn.motian.constant.TTMSConst.TTMS_TICKET_STATUS.UNSOLD;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private PlayService playService;
    @Autowired
    private TicketService ticketService;

    @Autowired
    private StudioService studioService;

    @Autowired
    private SeatService seatService;

    public boolean addSchedule(Schedule schedule) {
        System.out.println(schedule.toString());

        //name转换为id
        schedule.setStudioId(studioService.getByName(schedule.getStudioId()).getUnionId());
        schedule.setPlayId(playService.getByName(schedule.getPlayId()).getUnionId());
        // 状态转换为常量    前端传入表面字符
        schedule.setStatus(String.valueOf(TTMSConst.TTMS_SCHEDULE_STATUS.valueOf(schedule.getStatus()).getIndex()));
        System.out.println(schedule.toString());

        //插入schedule
        if (scheduleMapper.insert(schedule)) {
            // 生成票
            Studio studio = studioService.getByUnionId(schedule.getStudioId());
            System.out.println(studio.toString());
            List<Seat> seatList = seatService.getSeatByStudioId(studio.getUnionId());
            schedule = scheduleService.getByStudioidAndPlayidAndTime(schedule.getStudioId(), schedule.getPlayId(), schedule.getTime());
            Ticket ticket = null;
            for (Seat seat : seatList) {
                if (String.valueOf(USE.getIndex()).equals(seat.getStatus())) {
                    ticket = new Ticket(seat.getUnionId(), schedule.getUnionId(), schedule.getPrice(), String.valueOf(UNSOLD.ordinal()));
                } else if (String.valueOf(DAMAGE.getIndex()).equals(seat.getStatus())) {
                    ticket = new Ticket(seat.getUnionId(), schedule.getUnionId(), schedule.getPrice(), String.valueOf(NOEXIT.ordinal()));
                }
                ticketService.addTicket(ticket);
            }
            return true;
        }
        return false;
    }


    public Schedule getByStudioidAndPlayidAndTime(String studioId, String playId, String time) {
        return scheduleMapper.getByStudioidAndPlayidAndTime(studioId, playId, time);
    }


    @Override
    public Schedule getByUnionId(String unionId) {
        return scheduleMapper.getByUnionId(unionId);
    }


    @Override
    public boolean updateSchedule(Schedule schedule) {
        if (schedule.getStatus() != null) {
            schedule.setStatus(String.valueOf(TTMSConst.TTMS_SCHEDULE_STATUS.valueOf(schedule.getStatus())));
        }
        return scheduleMapper.update(schedule);
    }

    @Override
    public List<Schedule> getScheduleList() {
        List<Schedule> schedules = scheduleMapper.getScheduleList();
        if (schedules.size() > 0) {
            System.out.println(schedules.get(0).toString());
            schedules.stream()
                    .forEach(o -> {
                        o.setPlayId(playService.getByUnionId(o.getPlayId()).getName());
                        o.setStudioId(studioService.getByUnionId(o.getStudioId()).getName());
                    });
        }
        return schedules;
    }

    @Override
    public boolean deleterSchedule(String unionId) {
        return scheduleMapper.deleter(unionId);

    }
}
