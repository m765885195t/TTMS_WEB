package cn.motian.mapper;

import cn.motian.model.Seat;

import java.util.List;

public interface SeatMapper {
    boolean insert(Seat seat);

    boolean update(Seat seat);

    Seat getByUnionId(String unionId);

    boolean deleter(String unionId);

    List<Seat> getSeatByStudioId(String studioId);

    Seat getSeatByPosition(String unionId, String row, String colum);
}
