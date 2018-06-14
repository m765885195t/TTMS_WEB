package cn.motian.controller;

import cn.motian.constant.TTMSConst;
import cn.motian.model.Schedule;
import cn.motian.serveice.PlayService;
import cn.motian.serveice.ScheduleService;
import cn.motian.serveice.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.motian.constant.TTMSConst.TTMS_RESULT_STATUS.FAIL;
import static cn.motian.constant.TTMSConst.TTMS_RESULT_STATUS.SUCCEED;

@Controller
@RequestMapping(TTMSConst.TTMS_SERVER_URL.MANAGER)
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private StudioService studioService;
    @Autowired
    private PlayService playService;

    @RequestMapping(params = "method=addSchedule", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addSchedule(
            @RequestParam String studioName,
            @RequestParam String playName,
            @RequestParam String time,
            @RequestParam String price,
            @RequestParam String status
    ) {
        Schedule schedule = new Schedule(studioName, playName, time, price, status);
        Map<String, Object> rs = new HashMap<>();
        rs.put("result", scheduleService.addSchedule(schedule) ? SUCCEED : FAIL);
        return rs;
    }

    @RequestMapping(params = "method=updateSchedule", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateSchedule(
            @RequestParam String unionId,
            @RequestParam String studioName,
            @RequestParam String playName,
            @RequestParam String time,
            @RequestParam String price,
            @RequestParam String status
    ) {
        Schedule schedule = scheduleService.getByUnionId(unionId);
        schedule.setPlayId(playService.getByName(playName).getUnionId());
        schedule.setStudioId(studioService.getByName(studioName).getUnionId());
        schedule.setTime(time);
        schedule.setPrice(price);
        schedule.setStatus(status);

        System.out.println(schedule);

        Map<String, Object> rs = new HashMap<>();
        rs.put("result", scheduleService.updateSchedule(schedule) ? SUCCEED : FAIL);
        return rs;
    }


    @RequestMapping(params = "method=getScheduleByUnionId", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getByUnionId(
            @RequestParam String unionId) {
        Map<String, Object> rs = new HashMap<>();
        Schedule schedule = scheduleService.getByUnionId(unionId);
        rs.put("schedule", schedule);
        return rs;
    }

    @RequestMapping(params = "method=getScheduleList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getScheduleList() {
        Map<String, Object> rs = new HashMap<>();
        List<Schedule> scheduleList = scheduleService.getScheduleList();
        rs.put("scheduleList", scheduleList);
        return rs;
    }

    @RequestMapping(params = "method=deleterSchedule", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleterSchedule(
            @RequestParam String unionId) {
        Map<String, Object> rs = new HashMap<>();
        rs.put("result", scheduleService.deleterSchedule(unionId) ? SUCCEED : FAIL);
        return rs;
    }

}