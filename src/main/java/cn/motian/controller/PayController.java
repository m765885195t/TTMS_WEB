package cn.motian.controller;

import cn.motian.constant.TTMSConst;
import cn.motian.model.Ticket;
import cn.motian.serveice.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(TTMSConst.TTMS_SERVER_URL.ADMINISTRATOR)
public class PayController {
    @Autowired
    private PayService payService;

    @RequestMapping(params = "method=pay", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> Pay(
            @RequestParam List<Ticket> ticketList
    ) {

        Map<String, Object> rs = new HashMap<>();
//        rs.put("result", ture  ? SUCCEED : FAIL);

        return rs;
    }


}