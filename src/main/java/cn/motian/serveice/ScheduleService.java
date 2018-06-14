package cn.motian.serveice;

import cn.motian.model.Schedule;

import java.util.List;


public interface ScheduleService {
    boolean addSchedule(Schedule studio);

    Schedule getByUnionId(String unionId);

    boolean updateSchedule(Schedule studio);

    List<Schedule> getScheduleList();

    Schedule getByStudioidAndPlayidAndTime(String studioId, String playId, Long time);

    boolean deleterSchedule(String unionId);
}
