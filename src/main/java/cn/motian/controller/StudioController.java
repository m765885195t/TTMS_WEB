package cn.motian.controller;

import cn.motian.constant.TTMSConst;
import cn.motian.model.Studio;
import cn.motian.serveice.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import static cn.motian.constant.TTMSConst.TTMS_RESULT_STATUS.FAIL;
import static cn.motian.constant.TTMSConst.TTMS_RESULT_STATUS.SUCCEED;

@Controller
@RequestMapping(TTMSConst.TTMS_SERVER_URL.ADMINISTRATOR)
public class StudioController {
    @Autowired
    private StudioService studioService;

    @RequestMapping(params = "method=addStudio", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addStudio(
            @RequestParam String name,
            @RequestParam String row,
            @RequestParam String col,
            @RequestParam(required = false) String introduce
            ) {
        Studio studio = new Studio(name, row, col, introduce);
        Map<String, Object> rs = new HashMap<>();
        rs.put("result", studioService.addStudio(studio) ? SUCCEED : FAIL);
        return rs;
    }

}