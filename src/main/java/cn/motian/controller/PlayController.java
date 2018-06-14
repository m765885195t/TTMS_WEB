package cn.motian.controller;

import cn.motian.constant.TTMSConst;
import cn.motian.model.Play;
import cn.motian.serveice.PlayService;
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
public class PlayController {
    @Autowired
    private PlayService playService;

    @RequestMapping(params = "method=addPlay", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addPlay(
            @RequestParam String type,
            @RequestParam String language,
            @RequestParam String name,
            @RequestParam String introduction,
            @RequestParam(required = false) String image,
            @RequestParam int length
            ) {
        Play play = new Play(type, language, name, introduction, image, length);
        Map<String, Object> rs = new HashMap<>();
        rs.put("result", playService.addPlay(play) ? SUCCEED : FAIL);
        return rs;
    }

    @RequestMapping(params = "method=updatePlay", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updatePlay(
            @RequestParam String unionId,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String language,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String introduction,
            @RequestParam(required = false) String image,
            @RequestParam(required = false) String length
            ) {
        Play play = playService.getByUnionId(unionId);
        play.setType(type);
        play.setLanguage(language);
        play.setImage(introduction);
        play.setImage(image);
        play.setLanguage(length);
        play.setName(name);

        System.out.println(play);

        Map<String, Object> rs = new HashMap<>();
        rs.put("result", playService.updatePlay(play) ? SUCCEED : FAIL);
        return rs;
    }


    @RequestMapping(params = "method=getPlayByUnionId", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getByUnionId(
            @RequestParam String unionId) {
        Map<String, Object> rs = new HashMap<>();
        Play play = playService.getByUnionId(unionId);
        rs.put("play", play);
        return rs;
    }

    @RequestMapping(params = "method=getPlayList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getPlayList() {
        Map<String, Object> rs = new HashMap<>();
        List<Play> playList = playService.getPlayList();
        rs.put("playList", playList);
        return rs;
    }

    @RequestMapping(params = "method=deleterPlay", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleterPlay(
            @RequestParam String unionId) {
        Map<String, Object> rs = new HashMap<>();
        rs.put("result", playService.deleterPlay(unionId) ? SUCCEED : FAIL);
        return rs;
    }

}