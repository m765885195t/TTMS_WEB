package cn.motian.mapper;

import cn.motian.model.Schedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScheduleMapper {
    boolean insert(Schedule schedule);

    boolean update(Schedule schedule);

    Schedule getByUnionId(String unionId);

    boolean deleter(String unionId);

    List<Schedule> getScheduleList();

    Schedule getByStudioidAndPlayidAndTime(@Param("studioId") String studioId,
                                           @Param("playId") String playId,
                                           @Param("time") Long time);
}
