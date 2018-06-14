package cn.motian.controller;

import cn.motian.constant.TTMSConst;
import cn.motian.model.Seat;
import cn.motian.serveice.SeatService;
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
@RequestMapping(TTMSConst.TTMS_SERVER_URL.ADMINISTRATOR)
public class SeatController {
    @Autowired
    private SeatService seatService;

    @RequestMapping(params = "method=updateSeat", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateSeat(
            @RequestParam String unionId,
            @RequestParam String status
    ) {
        Seat seat = seatService.getByUnionId(unionId);
        seat.setStatus(status);
        Map<String, Object> rs = new HashMap<>();
        rs.put("result", seatService.updateSeat(seat) ? SUCCEED : FAIL);
        return rs;
    }

    @RequestMapping(params = "method=getSeatByStudioId", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getSeatByStudioId(
            @RequestParam String studioId) {
        Map<String, Object> rs = new HashMap<>();
        List<Seat> seatList = seatService.getSeatByStudioId(studioId);
        rs.put("seatList", seatList);
        return rs;
    }

    @RequestMapping(params = "method=getSeatByStudioName", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getSeatByStudioName(
            @RequestParam String studioName) {
        Map<String, Object> rs = new HashMap<>();
        List<Seat> seatList = seatService.getSeatByStudioName(studioName);
        rs.put("seatList", seatList);
        return rs;
    }

    @RequestMapping(params = "method=getSeatByPosition", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getSeatByPosition(
            @RequestParam String studioName,
            @RequestParam String row,
            @RequestParam String colum
    ) {
        Map<String, Object> rs = new HashMap<>();
        Seat seat = seatService.getSeatByPosition(studioName, row, colum);
        rs.put("seatList", seat);
        return rs;
    }
}