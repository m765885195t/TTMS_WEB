package cn.motian.controller;

import cn.motian.constant.TTMSConst;
import cn.motian.model.Seat;
import cn.motian.serveice.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

}