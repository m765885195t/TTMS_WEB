package cn.motian.serveice;

import cn.motian.model.Seat;

import java.util.List;

public interface SeatService {
    boolean addSeat(Seat seat);

    boolean updateSeat(Seat seat);

    Seat getByUnionId(String unionId);


    List<Seat> getSeatByStudioId(String studioId);

    Seat getSeatByPosition(String studioName, String row, String colum);

    boolean deleterSeat(String unionId);

    List<Seat> getSeatByStudioName(String studioName);
}
