package cn.motian.mapper;

import cn.motian.model.Seat;

public interface SeatMapper {
    boolean insert(Seat seat);

    boolean update(Seat seat);

    Seat getByUnionId(String unionId);

    boolean deleter(String unionId);
}
