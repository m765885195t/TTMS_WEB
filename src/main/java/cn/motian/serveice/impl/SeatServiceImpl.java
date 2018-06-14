package cn.motian.serveice.impl;

import cn.motian.constant.TTMSConst;
import cn.motian.mapper.SeatMapper;
import cn.motian.model.Seat;
import cn.motian.model.Studio;
import cn.motian.serveice.SeatService;
import cn.motian.serveice.StudioService;
import cn.motian.serveice.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static cn.motian.constant.TTMSConst.TTMS_SEAT_STATUS.DAMAGE;
import static cn.motian.constant.TTMSConst.TTMS_SEAT_STATUS.USE;


@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatMapper seatMapper;
    @Autowired
    private StudioService studioService;
    private TicketService ticketService;

    @Override
    public boolean addSeat(Seat seat) {
        return seatMapper.insert(seat);
    }

    public boolean updateSeat(Seat seat) {
        if (seat.getStatus() != null) {
            seat.setStatus(String.valueOf(TTMSConst.TTMS_SEAT_STATUS.valueOf(seat.getStatus()).ordinal()));
        }
        return seatMapper.update(seat);
    }

    public boolean deleterSeat(String unionId) {
//        if(ticketService.)   //检查该座位上是否有票
        return seatMapper.deleter(unionId);
    }

    @Override
    public List<Seat> getSeatByStudioName(String studioName) {
        return seatMapper.getSeatByStudioId(studioService.getByName(studioName).getUnionId());
    }

    @Override
    public Seat getByUnionId(String unionId) {
        return seatMapper.getByUnionId(unionId);
    }

    @Override
    public List<Seat> getSeatByStudioId(String studioId) {
        List<Seat> schedules = seatMapper.getSeatByStudioId(studioId);
        if (schedules.size() > 0) {
            System.out.println(schedules.get(0).toString());
            schedules.stream()
                    .forEach(o -> {
                        if (USE.getIndex() == Integer.valueOf(o.getStatus())) {
                            o.setStatus(String.valueOf(USE));
                        } else if (DAMAGE.getIndex() == Integer.valueOf(o.getStatus())) {
                            o.setStatus(String.valueOf(DAMAGE));

                        }
                    });
        }
        return schedules;
    }

    @Override
    public Seat getSeatByPosition(String studioName, String row, String colum) {
        Studio studio = studioService.getByName(studioName);
        return seatMapper.getSeatByPosition(studio.getUnionId(), row, colum);
    }
}
