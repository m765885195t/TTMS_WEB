package cn.motian.serveice.impl;

import cn.motian.mapper.SeatMapper;
import cn.motian.model.Seat;
import cn.motian.serveice.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatMapper seatMapper;

    @Override
    public boolean addSeat(Seat seat) {
        return seatMapper.insert(seat);
    }

    public boolean updateSeat(Seat seat) {
        return seatMapper.update(seat);
    }

    @Override
    public Seat getByUnionId(String unionId) {
        return seatMapper.getByUnionId(unionId);
    }

    @Override
    public boolean deleterSeat(String unionId) {

        return seatMapper.deleter(unionId);
    }
}
