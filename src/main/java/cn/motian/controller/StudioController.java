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
import java.util.List;
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

    @RequestMapping(params = "method=updateStudio", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateStudio(
            @RequestParam String unionId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String introduce
    ) {
        Studio studio = studioService.getByUnionId(unionId);
        studio.setName(name);
        studio.setIntroduce(introduce);

        System.out.println(studio);

        Map<String, Object> rs = new HashMap<>();
        rs.put("result", studioService.updateStudio(studio) ? SUCCEED : FAIL);
        return rs;
    }

    @RequestMapping(params = "method=updateStudioByName", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateStudioByName(
            @RequestParam String name,
            @RequestParam(required = false) String introduce
    ) {
        Studio studio = studioService.getByName(name);
        studio.setName(name);
        studio.setIntroduce(introduce);

        System.out.println(studio);

        Map<String, Object> rs = new HashMap<>();
        rs.put("result", studioService.updateStudio(studio) ? SUCCEED : FAIL);
        return rs;
    }

    @RequestMapping(params = "method=getStudioByUnionId", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getByUnionId(
            @RequestParam String unionId) {
        Map<String, Object> rs = new HashMap<>();
        Studio studio = studioService.getByUnionId(unionId);
        rs.put("studio", studio);
        return rs;
    }

    @RequestMapping(params = "method=getByName", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getByName(
            @RequestParam String name) {
        Map<String, Object> rs = new HashMap<>();
        Studio studio = studioService.getByName(name);
        rs.put("studio", studio);
        return rs;
    }


    @RequestMapping(params = "method=getStudioList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getStudioList() {
        Map<String, Object> rs = new HashMap<>();
        List<Studio> studioList = studioService.getStudioList();
        rs.put("studioList", studioList);
        return rs;
    }

    @RequestMapping(params = "method=deleterStudio", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleterStudio(
            @RequestParam String unionId) {
        Map<String, Object> rs = new HashMap<>();
        rs.put("result", studioService.deleterStudio(unionId) ? SUCCEED : FAIL);
        return rs;
    }

    @RequestMapping(params = "method=deleterStudioByName", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleterStudioByName(
            @RequestParam String name) {
        Map<String, Object> rs = new HashMap<>();
        rs.put("result", studioService.deleterStudioByName(name) ? SUCCEED : FAIL);
        return rs;
    }
}