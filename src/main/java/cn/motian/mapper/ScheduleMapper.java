package cn.motian.mapper;

import cn.motian.model.Schedule;

import java.util.List;

public interface ScheduleMapper {
    boolean insert(Schedule schedule);

    boolean update(Schedule schedule);

    Schedule getByUnionId(String unionId);

    boolean deleter(String unionId);

    List<Schedule> getScheduleList();

    Schedule getByName(String name);

    Schedule getByStudioidAndPlayidAndTime(String studioId, String playId, Long time);
}
