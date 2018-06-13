package cn.motian.serveice;

import cn.motian.model.Seat;

public interface SeatService {
    boolean addSeat(Seat seat);

    boolean updateSeat(Seat seat);

    Seat getByUnionId(String unionId);

    boolean deleterSeat(String unionId);
}
